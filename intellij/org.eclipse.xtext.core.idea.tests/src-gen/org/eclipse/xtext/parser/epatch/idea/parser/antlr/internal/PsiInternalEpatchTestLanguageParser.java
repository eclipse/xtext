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
    // PsiInternalEpatchTestLanguage.g:52:1: entryRuleEPatch returns [Boolean current=false] : iv_ruleEPatch= ruleEPatch EOF ;
    public final Boolean entryRuleEPatch() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEPatch = null;


        try {
            // PsiInternalEpatchTestLanguage.g:52:48: (iv_ruleEPatch= ruleEPatch EOF )
            // PsiInternalEpatchTestLanguage.g:53:2: iv_ruleEPatch= ruleEPatch EOF
            {
             markComposite(elementTypeProvider.getEPatchElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEPatch=ruleEPatch();

            state._fsp--;

             current =iv_ruleEPatch; 
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
    // $ANTLR end "entryRuleEPatch"


    // $ANTLR start "ruleEPatch"
    // PsiInternalEpatchTestLanguage.g:59:1: ruleEPatch returns [Boolean current=false] : (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) ;
    public final Boolean ruleEPatch() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Boolean lv_imports_3_0 = null;

        Boolean lv_resources_4_0 = null;

        Boolean lv_objects_5_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:60:1: ( (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) )
            // PsiInternalEpatchTestLanguage.g:61:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            {
            // PsiInternalEpatchTestLanguage.g:61:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            // PsiInternalEpatchTestLanguage.g:62:3: otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getEPatch_EpatchKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:69:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:71:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEPatch_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEPatch_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:93:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:94:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:94:4: (lv_imports_3_0= ruleImport )
            	    // PsiInternalEpatchTestLanguage.g:95:5: lv_imports_3_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ImportsImportParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_imports_3_0=ruleImport();

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

            // PsiInternalEpatchTestLanguage.g:108:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:109:4: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:109:4: (lv_resources_4_0= ruleNamedResource )
            	    // PsiInternalEpatchTestLanguage.g:110:5: lv_resources_4_0= ruleNamedResource
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_resources_4_0=ruleNamedResource();

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

            // PsiInternalEpatchTestLanguage.g:123:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:124:4: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:124:4: (lv_objects_5_0= ruleObjectRef )
            	    // PsiInternalEpatchTestLanguage.g:125:5: lv_objects_5_0= ruleObjectRef
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_objects_5_0=ruleObjectRef();

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
        return current;
    }
    // $ANTLR end "ruleEPatch"


    // $ANTLR start "entryRuleImport"
    // PsiInternalEpatchTestLanguage.g:149:1: entryRuleImport returns [Boolean current=false] : iv_ruleImport= ruleImport EOF ;
    public final Boolean entryRuleImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:149:48: (iv_ruleImport= ruleImport EOF )
            // PsiInternalEpatchTestLanguage.g:150:2: iv_ruleImport= ruleImport EOF
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
    // PsiInternalEpatchTestLanguage.g:156:1: ruleImport returns [Boolean current=false] : (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final Boolean ruleImport() throws RecognitionException {
        Boolean current = false;

        Boolean this_ModelImport_0 = null;

        Boolean this_JavaImport_1 = null;

        Boolean this_ExtensionImport_2 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:157:1: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) )
            // PsiInternalEpatchTestLanguage.g:158:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            {
            // PsiInternalEpatchTestLanguage.g:158:2: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt4=1;
                    }
                    break;
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
                    // PsiInternalEpatchTestLanguage.g:159:3: this_ModelImport_0= ruleModelImport
                    {

                    			markComposite(elementTypeProvider.getImport_ModelImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ModelImport_0=ruleModelImport();

                    state._fsp--;


                    			current = this_ModelImport_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:168:3: this_JavaImport_1= ruleJavaImport
                    {

                    			markComposite(elementTypeProvider.getImport_JavaImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_JavaImport_1=ruleJavaImport();

                    state._fsp--;


                    			current = this_JavaImport_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:177:3: this_ExtensionImport_2= ruleExtensionImport
                    {

                    			markComposite(elementTypeProvider.getImport_ExtensionImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExtensionImport_2=ruleExtensionImport();

                    state._fsp--;


                    			current = this_ExtensionImport_2;
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
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleModelImport"
    // PsiInternalEpatchTestLanguage.g:189:1: entryRuleModelImport returns [Boolean current=false] : iv_ruleModelImport= ruleModelImport EOF ;
    public final Boolean entryRuleModelImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModelImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:189:53: (iv_ruleModelImport= ruleModelImport EOF )
            // PsiInternalEpatchTestLanguage.g:190:2: iv_ruleModelImport= ruleModelImport EOF
            {
             markComposite(elementTypeProvider.getModelImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelImport=ruleModelImport();

            state._fsp--;

             current =iv_ruleModelImport; 
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
    // $ANTLR end "entryRuleModelImport"


    // $ANTLR start "ruleModelImport"
    // PsiInternalEpatchTestLanguage.g:196:1: ruleModelImport returns [Boolean current=false] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final Boolean ruleModelImport() throws RecognitionException {
        Boolean current = false;

        Boolean this_ResourceImport_0 = null;

        Boolean this_EPackageImport_1 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:197:1: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // PsiInternalEpatchTestLanguage.g:198:2: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // PsiInternalEpatchTestLanguage.g:198:2: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
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
                    // PsiInternalEpatchTestLanguage.g:199:3: this_ResourceImport_0= ruleResourceImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_ResourceImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ResourceImport_0=ruleResourceImport();

                    state._fsp--;


                    			current = this_ResourceImport_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:208:3: this_EPackageImport_1= ruleEPackageImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_EPackageImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EPackageImport_1=ruleEPackageImport();

                    state._fsp--;


                    			current = this_EPackageImport_1;
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
        return current;
    }
    // $ANTLR end "ruleModelImport"


    // $ANTLR start "entryRuleResourceImport"
    // PsiInternalEpatchTestLanguage.g:220:1: entryRuleResourceImport returns [Boolean current=false] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final Boolean entryRuleResourceImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleResourceImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:220:56: (iv_ruleResourceImport= ruleResourceImport EOF )
            // PsiInternalEpatchTestLanguage.g:221:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             markComposite(elementTypeProvider.getResourceImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleResourceImport=ruleResourceImport();

            state._fsp--;

             current =iv_ruleResourceImport; 
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
    // $ANTLR end "entryRuleResourceImport"


    // $ANTLR start "ruleResourceImport"
    // PsiInternalEpatchTestLanguage.g:227:1: ruleResourceImport returns [Boolean current=false] : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final Boolean ruleResourceImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_uri_3_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:228:1: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // PsiInternalEpatchTestLanguage.g:229:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:229:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:230:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getResourceImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:237:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:238:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:238:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:239:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getResourceImport_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getResourceImport_UriKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:261:3: ( (lv_uri_3_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:262:4: (lv_uri_3_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:262:4: (lv_uri_3_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:263:5: lv_uri_3_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleResourceImport"


    // $ANTLR start "entryRuleEPackageImport"
    // PsiInternalEpatchTestLanguage.g:282:1: entryRuleEPackageImport returns [Boolean current=false] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final Boolean entryRuleEPackageImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEPackageImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:282:56: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // PsiInternalEpatchTestLanguage.g:283:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             markComposite(elementTypeProvider.getEPackageImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEPackageImport=ruleEPackageImport();

            state._fsp--;

             current =iv_ruleEPackageImport; 
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
    // $ANTLR end "entryRuleEPackageImport"


    // $ANTLR start "ruleEPackageImport"
    // PsiInternalEpatchTestLanguage.g:289:1: ruleEPackageImport returns [Boolean current=false] : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final Boolean ruleEPackageImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_nsURI_3_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:290:1: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // PsiInternalEpatchTestLanguage.g:291:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:291:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:292:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getEPackageImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:300:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:301:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEPackageImport_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEPackageImport_NsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:323:3: ( (lv_nsURI_3_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:324:4: (lv_nsURI_3_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:324:4: (lv_nsURI_3_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:325:5: lv_nsURI_3_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleEPackageImport"


    // $ANTLR start "entryRuleJavaImport"
    // PsiInternalEpatchTestLanguage.g:344:1: entryRuleJavaImport returns [Boolean current=false] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final Boolean entryRuleJavaImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJavaImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:344:52: (iv_ruleJavaImport= ruleJavaImport EOF )
            // PsiInternalEpatchTestLanguage.g:345:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             markComposite(elementTypeProvider.getJavaImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJavaImport=ruleJavaImport();

            state._fsp--;

             current =iv_ruleJavaImport; 
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
    // $ANTLR end "entryRuleJavaImport"


    // $ANTLR start "ruleJavaImport"
    // PsiInternalEpatchTestLanguage.g:351:1: ruleJavaImport returns [Boolean current=false] : (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleJavaImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:352:1: ( (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // PsiInternalEpatchTestLanguage.g:353:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalEpatchTestLanguage.g:353:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // PsiInternalEpatchTestLanguage.g:354:3: otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getJavaImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJavaImport_JavaKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:368:3: ( (lv_path_2_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:369:4: (lv_path_2_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:369:4: (lv_path_2_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:370:5: lv_path_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_path_2_0);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:385:3: (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:386:4: otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getJavaImport_FullStopKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalEpatchTestLanguage.g:393:4: ( (lv_path_4_0= RULE_ID ) )
            	    // PsiInternalEpatchTestLanguage.g:394:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:394:5: (lv_path_4_0= RULE_ID )
            	    // PsiInternalEpatchTestLanguage.g:395:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
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
        return current;
    }
    // $ANTLR end "ruleJavaImport"


    // $ANTLR start "entryRuleExtensionImport"
    // PsiInternalEpatchTestLanguage.g:415:1: entryRuleExtensionImport returns [Boolean current=false] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final Boolean entryRuleExtensionImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtensionImport = null;


        try {
            // PsiInternalEpatchTestLanguage.g:415:57: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // PsiInternalEpatchTestLanguage.g:416:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             markComposite(elementTypeProvider.getExtensionImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtensionImport=ruleExtensionImport();

            state._fsp--;

             current =iv_ruleExtensionImport; 
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
    // $ANTLR end "entryRuleExtensionImport"


    // $ANTLR start "ruleExtensionImport"
    // PsiInternalEpatchTestLanguage.g:422:1: ruleExtensionImport returns [Boolean current=false] : (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleExtensionImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:423:1: ( (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // PsiInternalEpatchTestLanguage.g:424:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalEpatchTestLanguage.g:424:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // PsiInternalEpatchTestLanguage.g:425:3: otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getExtensionImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getExtensionImport_ExtensionKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:439:3: ( (lv_path_2_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:440:4: (lv_path_2_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:440:4: (lv_path_2_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:441:5: lv_path_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					doneLeaf(lv_path_2_0);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:456:3: (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:457:4: otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getExtensionImport_ColonColonKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalEpatchTestLanguage.g:464:4: ( (lv_path_4_0= RULE_ID ) )
            	    // PsiInternalEpatchTestLanguage.g:465:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:465:5: (lv_path_4_0= RULE_ID )
            	    // PsiInternalEpatchTestLanguage.g:466:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
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
        return current;
    }
    // $ANTLR end "ruleExtensionImport"


    // $ANTLR start "entryRuleNamedResource"
    // PsiInternalEpatchTestLanguage.g:486:1: entryRuleNamedResource returns [Boolean current=false] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final Boolean entryRuleNamedResource() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamedResource = null;


        try {
            // PsiInternalEpatchTestLanguage.g:486:55: (iv_ruleNamedResource= ruleNamedResource EOF )
            // PsiInternalEpatchTestLanguage.g:487:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             markComposite(elementTypeProvider.getNamedResourceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedResource=ruleNamedResource();

            state._fsp--;

             current =iv_ruleNamedResource; 
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
    // $ANTLR end "entryRuleNamedResource"


    // $ANTLR start "ruleNamedResource"
    // PsiInternalEpatchTestLanguage.g:493:1: ruleNamedResource returns [Boolean current=false] : (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) ;
    public final Boolean ruleNamedResource() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_leftRoot_6_0 = null;

        Boolean lv_rightRoot_11_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:494:1: ( (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) )
            // PsiInternalEpatchTestLanguage.g:495:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            {
            // PsiInternalEpatchTestLanguage.g:495:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            // PsiInternalEpatchTestLanguage.g:496:3: otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}'
            {

            			markLeaf(elementTypeProvider.getNamedResource_ResourceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:503:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:504:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:504:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:505:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNamedResource_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
            		
            // PsiInternalEpatchTestLanguage.g:534:3: ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
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
                    // PsiInternalEpatchTestLanguage.g:535:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:535:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // PsiInternalEpatchTestLanguage.g:536:5: otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {

                    					markLeaf(elementTypeProvider.getNamedResource_UriKeyword_4_0_0ElementType());
                    				
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEpatchTestLanguage.g:543:5: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:544:6: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:544:6: (lv_leftUri_5_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:545:7: lv_leftUri_5_0= RULE_STRING
                    {

                    							markLeaf(elementTypeProvider.getNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_leftUri_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

                    							doneLeaf(lv_leftUri_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:562:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:562:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:563:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:563:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:564:6: lv_leftRoot_6_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_17);
                    lv_leftRoot_6_0=ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
            		
            // PsiInternalEpatchTestLanguage.g:592:3: ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
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
                    // PsiInternalEpatchTestLanguage.g:593:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:593:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // PsiInternalEpatchTestLanguage.g:594:5: otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {

                    					markLeaf(elementTypeProvider.getNamedResource_UriKeyword_7_0_0ElementType());
                    				
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    					doneLeaf(otherlv_9);
                    				
                    // PsiInternalEpatchTestLanguage.g:601:5: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:602:6: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:602:6: (lv_rightUri_10_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:603:7: lv_rightUri_10_0= RULE_STRING
                    {

                    							markLeaf(elementTypeProvider.getNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_rightUri_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

                    							doneLeaf(lv_rightUri_10_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:620:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:620:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:621:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:621:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:622:6: lv_rightRoot_11_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_17);
                    lv_rightRoot_11_0=ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleNamedResource"


    // $ANTLR start "entryRuleObjectRef"
    // PsiInternalEpatchTestLanguage.g:654:1: entryRuleObjectRef returns [Boolean current=false] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final Boolean entryRuleObjectRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleObjectRef = null;


        try {
            // PsiInternalEpatchTestLanguage.g:654:51: (iv_ruleObjectRef= ruleObjectRef EOF )
            // PsiInternalEpatchTestLanguage.g:655:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             markComposite(elementTypeProvider.getObjectRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectRef=ruleObjectRef();

            state._fsp--;

             current =iv_ruleObjectRef; 
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
    // $ANTLR end "entryRuleObjectRef"


    // $ANTLR start "ruleObjectRef"
    // PsiInternalEpatchTestLanguage.g:661:1: ruleObjectRef returns [Boolean current=false] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) ;
    public final Boolean ruleObjectRef() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_assignments_11_0 = null;

        Boolean lv_assignments_12_0 = null;

        Boolean lv_leftMig_14_0 = null;

        Boolean lv_rightMig_16_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:662:1: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) )
            // PsiInternalEpatchTestLanguage.g:663:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            {
            // PsiInternalEpatchTestLanguage.g:663:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            // PsiInternalEpatchTestLanguage.g:664:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            {

            			markLeaf(elementTypeProvider.getObjectRef_ObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:671:3: ( (lv_name_1_0= RULE_ID ) )?
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
                    // PsiInternalEpatchTestLanguage.g:672:4: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:672:4: (lv_name_1_0= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:673:5: lv_name_1_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getObjectRef_NameIDTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    					doneLeaf(lv_name_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:688:3: ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    // PsiInternalEpatchTestLanguage.g:689:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:689:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:690:5: ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:690:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:691:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:691:6: (otherlv_2= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:692:7: otherlv_2= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:707:5: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:708:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:708:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:709:7: lv_leftFrag_3_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_leftFrag_3_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_22); 

                    							doneLeaf(lv_leftFrag_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:726:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:726:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:727:5: otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {

                    					markLeaf(elementTypeProvider.getObjectRef_LeftKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEpatchTestLanguage.g:734:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:735:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:735:6: (otherlv_5= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:736:7: otherlv_5= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:751:5: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:752:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:752:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:753:7: lv_leftFrag_6_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_leftFrag_6_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_18); 

                    							doneLeaf(lv_leftFrag_6_0);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getObjectRef_RightKeyword_2_1_3ElementType());
                    				
                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalEpatchTestLanguage.g:775:5: ( (otherlv_8= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:776:6: (otherlv_8= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:776:6: (otherlv_8= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:777:7: otherlv_8= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType());
                    						
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_8);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:792:5: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:793:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:793:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:794:7: lv_rightFrag_9_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_rightFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_22); 

                    							doneLeaf(lv_rightFrag_9_0);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:811:3: (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:812:4: otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}'
                    {

                    				markLeaf(elementTypeProvider.getObjectRef_LeftCurlyBracketKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalEpatchTestLanguage.g:819:4: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
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
                    	    // PsiInternalEpatchTestLanguage.g:820:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:820:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:821:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:821:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:822:7: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    lv_assignments_11_0=ruleBiSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalEpatchTestLanguage.g:836:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:836:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:837:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:837:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:838:7: lv_assignments_12_0= ruleBiListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    lv_assignments_12_0=ruleBiListAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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

                    // PsiInternalEpatchTestLanguage.g:852:4: (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:853:5: otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {

                            					markLeaf(elementTypeProvider.getObjectRef_LeftKeyword_3_2_0ElementType());
                            				
                            otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_24); 

                            					doneLeaf(otherlv_13);
                            				
                            // PsiInternalEpatchTestLanguage.g:860:5: ( (lv_leftMig_14_0= ruleMigration ) )
                            // PsiInternalEpatchTestLanguage.g:861:6: (lv_leftMig_14_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:861:6: (lv_leftMig_14_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:862:7: lv_leftMig_14_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_25);
                            lv_leftMig_14_0=ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }


                            }
                            break;

                    }

                    // PsiInternalEpatchTestLanguage.g:876:4: (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:877:5: otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {

                            					markLeaf(elementTypeProvider.getObjectRef_RightKeyword_3_3_0ElementType());
                            				
                            otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_24); 

                            					doneLeaf(otherlv_15);
                            				
                            // PsiInternalEpatchTestLanguage.g:884:5: ( (lv_rightMig_16_0= ruleMigration ) )
                            // PsiInternalEpatchTestLanguage.g:885:6: (lv_rightMig_16_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:885:6: (lv_rightMig_16_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:886:7: lv_rightMig_16_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_19);
                            lv_rightMig_16_0=ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

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
        return current;
    }
    // $ANTLR end "ruleObjectRef"


    // $ANTLR start "entryRuleBiSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:912:1: entryRuleBiSingleAssignment returns [Boolean current=false] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final Boolean entryRuleBiSingleAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBiSingleAssignment = null;


        try {
            // PsiInternalEpatchTestLanguage.g:912:60: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:913:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getBiSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();

            state._fsp--;

             current =iv_ruleBiSingleAssignment; 
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
    // $ANTLR end "entryRuleBiSingleAssignment"


    // $ANTLR start "ruleBiSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:919:1: ruleBiSingleAssignment returns [Boolean current=false] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) ;
    public final Boolean ruleBiSingleAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_leftValue_2_0 = null;

        Boolean lv_rightValue_4_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:920:1: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) )
            // PsiInternalEpatchTestLanguage.g:921:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:921:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            // PsiInternalEpatchTestLanguage.g:922:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';'
            {
            // PsiInternalEpatchTestLanguage.g:922:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:923:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:923:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:924:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:946:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:947:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:947:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:948:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_28);
            lv_leftValue_2_0=ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiSingleAssignment_VerticalLineKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalEpatchTestLanguage.g:968:3: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:969:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:969:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:970:5: lv_rightValue_4_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            lv_rightValue_4_0=ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleBiSingleAssignment"


    // $ANTLR start "entryRuleBiListAssignment"
    // PsiInternalEpatchTestLanguage.g:994:1: entryRuleBiListAssignment returns [Boolean current=false] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final Boolean entryRuleBiListAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBiListAssignment = null;


        try {
            // PsiInternalEpatchTestLanguage.g:994:58: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:995:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             markComposite(elementTypeProvider.getBiListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBiListAssignment=ruleBiListAssignment();

            state._fsp--;

             current =iv_ruleBiListAssignment; 
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
    // $ANTLR end "entryRuleBiListAssignment"


    // $ANTLR start "ruleBiListAssignment"
    // PsiInternalEpatchTestLanguage.g:1001:1: ruleBiListAssignment returns [Boolean current=false] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) ;
    public final Boolean ruleBiListAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Boolean lv_leftValues_3_0 = null;

        Boolean lv_leftValues_5_0 = null;

        Boolean lv_rightValues_7_0 = null;

        Boolean lv_rightValues_9_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1002:1: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) )
            // PsiInternalEpatchTestLanguage.g:1003:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:1003:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            // PsiInternalEpatchTestLanguage.g:1004:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';'
            {
            // PsiInternalEpatchTestLanguage.g:1004:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1005:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1005:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1006:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
            		
            // PsiInternalEpatchTestLanguage.g:1035:3: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1036:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:1036:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:1037:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:1037:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:1038:6: lv_leftValues_3_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_31);
                    lv_leftValues_3_0=ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1051:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:1052:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBiListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_32); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:1059:5: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:1060:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1060:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:1061:7: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_31);
                    	    lv_leftValues_5_0=ruleListAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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
            		
            // PsiInternalEpatchTestLanguage.g:1083:3: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1084:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:1084:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:1085:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:1085:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:1086:6: lv_rightValues_7_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_rightValues_7_0=ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1099:4: (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:1100:5: otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBiListAssignment_CommaKeyword_5_1_0ElementType());
                    	    				
                    	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_32); 

                    	    					doneLeaf(otherlv_8);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:1107:5: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:1108:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1108:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:1109:7: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    lv_rightValues_9_0=ruleListAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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
        return current;
    }
    // $ANTLR end "ruleBiListAssignment"


    // $ANTLR start "entryRuleMonoSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:1142:1: entryRuleMonoSingleAssignment returns [Boolean current=false] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final Boolean entryRuleMonoSingleAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMonoSingleAssignment = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1142:62: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:1143:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();

            state._fsp--;

             current =iv_ruleMonoSingleAssignment; 
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
    // $ANTLR end "entryRuleMonoSingleAssignment"


    // $ANTLR start "ruleMonoSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:1149:1: ruleMonoSingleAssignment returns [Boolean current=false] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) ;
    public final Boolean ruleMonoSingleAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_leftValue_2_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1150:1: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) )
            // PsiInternalEpatchTestLanguage.g:1151:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:1151:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            // PsiInternalEpatchTestLanguage.g:1152:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';'
            {
            // PsiInternalEpatchTestLanguage.g:1152:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1153:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1153:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1154:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMonoSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:1176:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:1177:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:1177:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:1178:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            lv_leftValue_2_0=ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleMonoSingleAssignment"


    // $ANTLR start "entryRuleMonoListAssignment"
    // PsiInternalEpatchTestLanguage.g:1202:1: entryRuleMonoListAssignment returns [Boolean current=false] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final Boolean entryRuleMonoListAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMonoListAssignment = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1202:60: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:1203:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();

            state._fsp--;

             current =iv_ruleMonoListAssignment; 
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
    // $ANTLR end "entryRuleMonoListAssignment"


    // $ANTLR start "ruleMonoListAssignment"
    // PsiInternalEpatchTestLanguage.g:1209:1: ruleMonoListAssignment returns [Boolean current=false] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) ;
    public final Boolean ruleMonoListAssignment() throws RecognitionException {
        Boolean current = false;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Boolean lv_leftValues_3_0 = null;

        Boolean lv_leftValues_5_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1210:1: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) )
            // PsiInternalEpatchTestLanguage.g:1211:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:1211:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            // PsiInternalEpatchTestLanguage.g:1212:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';'
            {
            // PsiInternalEpatchTestLanguage.g:1212:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1213:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1213:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1214:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
            		
            // PsiInternalEpatchTestLanguage.g:1243:3: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1244:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:1244:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:1245:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:1245:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:1246:6: lv_leftValues_3_0= ruleAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_leftValues_3_0=ruleAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1259:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:1260:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getMonoListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_36); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:1267:5: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:1268:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1268:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:1269:7: lv_leftValues_5_0= ruleAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    lv_leftValues_5_0=ruleAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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
        return current;
    }
    // $ANTLR end "ruleMonoListAssignment"


    // $ANTLR start "entryRuleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1302:1: entryRuleAssignmentValue returns [Boolean current=false] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final Boolean entryRuleAssignmentValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssignmentValue = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1302:57: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1303:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentValue=ruleAssignmentValue();

            state._fsp--;

             current =iv_ruleAssignmentValue; 
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
    // $ANTLR end "entryRuleAssignmentValue"


    // $ANTLR start "ruleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1309:1: ruleAssignmentValue returns [Boolean current=false] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
    public final Boolean ruleAssignmentValue() throws RecognitionException {
        Boolean current = false;

        Token lv_value_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_refFeature_3_0=null;
        Token otherlv_4=null;
        Token lv_refIndex_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_impFrag_9_0=null;
        Boolean lv_newObject_7_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1310:1: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1311:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1311:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    // PsiInternalEpatchTestLanguage.g:1312:3: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1312:3: ( (lv_value_0_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1313:4: (lv_value_0_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1313:4: (lv_value_0_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1314:5: lv_value_0_0= RULE_STRING
                    {

                    					markLeaf(elementTypeProvider.getAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_value_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1330:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1330:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1331:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1331:4: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1332:5: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1332:5: (otherlv_1= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1333:6: otherlv_1= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType());
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						doneLeaf(otherlv_1);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1348:4: (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1349:5: otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            {

                            					markLeaf(elementTypeProvider.getAssignmentValue_FullStopKeyword_1_1_0ElementType());
                            				
                            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_2);
                            				
                            // PsiInternalEpatchTestLanguage.g:1356:5: ( (lv_refFeature_3_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1357:6: (lv_refFeature_3_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1357:6: (lv_refFeature_3_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1358:7: lv_refFeature_3_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_refFeature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            							doneLeaf(lv_refFeature_3_0);
                            						

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1373:5: (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1374:6: otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']'
                                    {

                                    						markLeaf(elementTypeProvider.getAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType());
                                    					
                                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    						doneLeaf(otherlv_4);
                                    					
                                    // PsiInternalEpatchTestLanguage.g:1381:6: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1382:7: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1382:7: (lv_refIndex_5_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1383:8: lv_refIndex_5_0= RULE_INT
                                    {

                                    								markLeaf(elementTypeProvider.getAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType());
                                    							

                                    								if(!current) {
                                    									associateWithSemanticElement();
                                    									current = true;
                                    								}
                                    							
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
                    // PsiInternalEpatchTestLanguage.g:1409:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1409:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1410:4: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1410:4: (lv_newObject_7_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1411:5: lv_newObject_7_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_newObject_7_0=ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEpatchTestLanguage.g:1425:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1425:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1426:4: ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1426:4: ( (otherlv_8= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1427:5: (otherlv_8= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1427:5: (otherlv_8= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1428:6: otherlv_8= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getAssignmentValue_ImportImportCrossReference_3_0_0ElementType());
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    						doneLeaf(otherlv_8);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1443:4: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1444:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1444:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1445:6: lv_impFrag_9_0= RULE_FRAGMENT
                    {

                    						markLeaf(elementTypeProvider.getAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
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
        return current;
    }
    // $ANTLR end "ruleAssignmentValue"


    // $ANTLR start "entryRuleListAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1465:1: entryRuleListAssignmentValue returns [Boolean current=false] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final Boolean entryRuleListAssignmentValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleListAssignmentValue = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1465:61: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1466:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getListAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();

            state._fsp--;

             current =iv_ruleListAssignmentValue; 
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
    // $ANTLR end "entryRuleListAssignmentValue"


    // $ANTLR start "ruleListAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1472:1: ruleListAssignmentValue returns [Boolean current=false] : ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
    public final Boolean ruleListAssignmentValue() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_newObject_12_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1473:1: ( ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1474:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1474:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1475:3: ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1475:3: ( (lv_index_0_0= RULE_INT ) )
            // PsiInternalEpatchTestLanguage.g:1476:4: (lv_index_0_0= RULE_INT )
            {
            // PsiInternalEpatchTestLanguage.g:1476:4: (lv_index_0_0= RULE_INT )
            // PsiInternalEpatchTestLanguage.g:1477:5: lv_index_0_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_index_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_39); 

            					doneLeaf(lv_index_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getListAssignmentValue_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_40); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:1499:3: ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
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
                    // PsiInternalEpatchTestLanguage.g:1500:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    {
                    // PsiInternalEpatchTestLanguage.g:1500:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    // PsiInternalEpatchTestLanguage.g:1501:5: otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']'
                    {

                    					markLeaf(elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalEpatchTestLanguage.g:1508:5: ( (lv_refIndex_3_0= RULE_INT ) )
                    // PsiInternalEpatchTestLanguage.g:1509:6: (lv_refIndex_3_0= RULE_INT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1509:6: (lv_refIndex_3_0= RULE_INT )
                    // PsiInternalEpatchTestLanguage.g:1510:7: lv_refIndex_3_0= RULE_INT
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
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
                    // PsiInternalEpatchTestLanguage.g:1534:4: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1534:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1535:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1535:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1536:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:1552:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1552:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1553:5: ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1553:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1554:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1554:6: (otherlv_6= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1555:7: otherlv_6= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType());
                    						
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    							doneLeaf(otherlv_6);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1570:5: (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1571:6: otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            {

                            						markLeaf(elementTypeProvider.getListAssignmentValue_FullStopKeyword_2_2_1_0ElementType());
                            					
                            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            						doneLeaf(otherlv_7);
                            					
                            // PsiInternalEpatchTestLanguage.g:1578:6: ( (lv_refFeature_8_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1579:7: (lv_refFeature_8_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1579:7: (lv_refFeature_8_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1580:8: lv_refFeature_8_0= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType());
                            							

                            								if(!current) {
                            									associateWithSemanticElement();
                            									current = true;
                            								}
                            							
                            lv_refFeature_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            								doneLeaf(lv_refFeature_8_0);
                            							

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1595:6: (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1596:7: otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']'
                                    {

                                    							markLeaf(elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType());
                                    						
                                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    							doneLeaf(otherlv_9);
                                    						
                                    // PsiInternalEpatchTestLanguage.g:1603:7: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1604:8: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1604:8: (lv_refIndex_10_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1605:9: lv_refIndex_10_0= RULE_INT
                                    {

                                    									markLeaf(elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType());
                                    								

                                    									if(!current) {
                                    										associateWithSemanticElement();
                                    										current = true;
                                    									}
                                    								
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
                    // PsiInternalEpatchTestLanguage.g:1631:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1631:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1632:5: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1632:5: (lv_newObject_12_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1633:6: lv_newObject_12_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_newObject_12_0=ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalEpatchTestLanguage.g:1647:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1647:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1648:5: ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1648:5: ( (otherlv_13= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1649:6: (otherlv_13= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1649:6: (otherlv_13= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1650:7: otherlv_13= RULE_ID
                    {

                    							if (!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    							markLeaf(elementTypeProvider.getListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType());
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_13);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1665:5: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1666:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1666:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1667:7: lv_impFrag_14_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
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
        return current;
    }
    // $ANTLR end "ruleListAssignmentValue"


    // $ANTLR start "entryRuleSingleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1688:1: entryRuleSingleAssignmentValue returns [Boolean current=false] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final Boolean entryRuleSingleAssignmentValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleAssignmentValue = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1688:63: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1689:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getSingleAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();

            state._fsp--;

             current =iv_ruleSingleAssignmentValue; 
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
    // $ANTLR end "entryRuleSingleAssignmentValue"


    // $ANTLR start "ruleSingleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1695:1: ruleSingleAssignmentValue returns [Boolean current=false] : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
    public final Boolean ruleSingleAssignmentValue() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_newObject_8_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1696:1: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1697:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1697:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
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

                if ( (LA30_3==EOF||LA30_3==19||LA30_3==24||LA30_3==28) ) {
                    alt30=3;
                }
                else if ( (LA30_3==RULE_FRAGMENT) ) {
                    alt30=5;
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
                    // PsiInternalEpatchTestLanguage.g:1698:3: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1698:3: ( (lv_keyword_0_0= 'null' ) )
                    // PsiInternalEpatchTestLanguage.g:1699:4: (lv_keyword_0_0= 'null' )
                    {
                    // PsiInternalEpatchTestLanguage.g:1699:4: (lv_keyword_0_0= 'null' )
                    // PsiInternalEpatchTestLanguage.g:1700:5: lv_keyword_0_0= 'null'
                    {

                    					markLeaf(elementTypeProvider.getSingleAssignmentValue_KeywordNullKeyword_0_0ElementType());
                    				
                    lv_keyword_0_0=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_keyword_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1716:3: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1716:3: ( (lv_value_1_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1717:4: (lv_value_1_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1717:4: (lv_value_1_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1718:5: lv_value_1_0= RULE_STRING
                    {

                    					markLeaf(elementTypeProvider.getSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_value_1_0);
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:1734:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1734:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1735:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1735:4: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1736:5: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1736:5: (otherlv_2= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1737:6: otherlv_2= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						doneLeaf(otherlv_2);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1752:4: (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1753:5: otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            {

                            					markLeaf(elementTypeProvider.getSingleAssignmentValue_FullStopKeyword_2_1_0ElementType());
                            				
                            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_3);
                            				
                            // PsiInternalEpatchTestLanguage.g:1760:5: ( (lv_refFeature_4_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1761:6: (lv_refFeature_4_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1761:6: (lv_refFeature_4_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1762:7: lv_refFeature_4_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_refFeature_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            							doneLeaf(lv_refFeature_4_0);
                            						

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1777:5: (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1778:6: otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']'
                                    {

                                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType());
                                    					
                                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    						doneLeaf(otherlv_5);
                                    					
                                    // PsiInternalEpatchTestLanguage.g:1785:6: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1786:7: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1786:7: (lv_refIndex_6_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1787:8: lv_refIndex_6_0= RULE_INT
                                    {

                                    								markLeaf(elementTypeProvider.getSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType());
                                    							

                                    								if(!current) {
                                    									associateWithSemanticElement();
                                    									current = true;
                                    								}
                                    							
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
                    // PsiInternalEpatchTestLanguage.g:1813:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1813:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1814:4: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1814:4: (lv_newObject_8_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1815:5: lv_newObject_8_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_newObject_8_0=ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalEpatchTestLanguage.g:1829:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1829:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1830:4: ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1830:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1831:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1831:5: (otherlv_9= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1832:6: otherlv_9= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType());
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    						doneLeaf(otherlv_9);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1847:4: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1848:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1848:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1849:6: lv_impFrag_10_0= RULE_FRAGMENT
                    {

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
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
        return current;
    }
    // $ANTLR end "ruleSingleAssignmentValue"


    // $ANTLR start "entryRuleCreatedObject"
    // PsiInternalEpatchTestLanguage.g:1869:1: entryRuleCreatedObject returns [Boolean current=false] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final Boolean entryRuleCreatedObject() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCreatedObject = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1869:55: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // PsiInternalEpatchTestLanguage.g:1870:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             markComposite(elementTypeProvider.getCreatedObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCreatedObject=ruleCreatedObject();

            state._fsp--;

             current =iv_ruleCreatedObject; 
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
    // $ANTLR end "entryRuleCreatedObject"


    // $ANTLR start "ruleCreatedObject"
    // PsiInternalEpatchTestLanguage.g:1876:1: ruleCreatedObject returns [Boolean current=false] : ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) ;
    public final Boolean ruleCreatedObject() throws RecognitionException {
        Boolean current = false;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Boolean this_ObjectNew_0 = null;

        Boolean this_ObjectCopy_1 = null;

        Boolean lv_assignments_4_0 = null;

        Boolean lv_assignments_5_0 = null;

        Boolean lv_leftMig_6_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1877:1: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) )
            // PsiInternalEpatchTestLanguage.g:1878:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            {
            // PsiInternalEpatchTestLanguage.g:1878:2: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            // PsiInternalEpatchTestLanguage.g:1879:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            {
            // PsiInternalEpatchTestLanguage.g:1879:3: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
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
                    // PsiInternalEpatchTestLanguage.g:1880:4: this_ObjectNew_0= ruleObjectNew
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectNewParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_41);
                    this_ObjectNew_0=ruleObjectNew();

                    state._fsp--;


                    				current = this_ObjectNew_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1889:4: this_ObjectCopy_1= ruleObjectCopy
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectCopyParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_41);
                    this_ObjectCopy_1=ruleObjectCopy();

                    state._fsp--;


                    				current = this_ObjectCopy_1;
                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:1898:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1899:4: (lv_name_2_0= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1899:4: (lv_name_2_0= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1900:5: lv_name_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

                    					doneLeaf(lv_name_2_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:1915:3: (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1916:4: otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}'
                    {

                    				markLeaf(elementTypeProvider.getCreatedObject_LeftCurlyBracketKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalEpatchTestLanguage.g:1923:4: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
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
                    	    // PsiInternalEpatchTestLanguage.g:1924:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1924:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:1925:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1925:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:1926:7: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    lv_assignments_4_0=ruleMonoSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalEpatchTestLanguage.g:1940:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1940:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:1941:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1941:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:1942:7: lv_assignments_5_0= ruleMonoListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    lv_assignments_5_0=ruleMonoListAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

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

                    // PsiInternalEpatchTestLanguage.g:1956:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1957:5: (lv_leftMig_6_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:1957:5: (lv_leftMig_6_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:1958:6: lv_leftMig_6_0= ruleMigration
                            {

                            						markComposite(elementTypeProvider.getCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_19);
                            lv_leftMig_6_0=ruleMigration();

                            state._fsp--;


                            						doneComposite();
                            						if(!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            					

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
        return current;
    }
    // $ANTLR end "ruleCreatedObject"


    // $ANTLR start "entryRuleObjectNew"
    // PsiInternalEpatchTestLanguage.g:1983:1: entryRuleObjectNew returns [Boolean current=false] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final Boolean entryRuleObjectNew() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleObjectNew = null;


        try {
            // PsiInternalEpatchTestLanguage.g:1983:51: (iv_ruleObjectNew= ruleObjectNew EOF )
            // PsiInternalEpatchTestLanguage.g:1984:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             markComposite(elementTypeProvider.getObjectNewElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectNew=ruleObjectNew();

            state._fsp--;

             current =iv_ruleObjectNew; 
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
    // $ANTLR end "entryRuleObjectNew"


    // $ANTLR start "ruleObjectNew"
    // PsiInternalEpatchTestLanguage.g:1990:1: ruleObjectNew returns [Boolean current=false] : (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final Boolean ruleObjectNew() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_impFrag_2_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1991:1: ( (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1992:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1992:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // PsiInternalEpatchTestLanguage.g:1993:3: otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf(elementTypeProvider.getObjectNew_NewKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:2000:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:2001:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:2001:4: (otherlv_1= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:2002:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getObjectNew_ImportImportCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:2017:3: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // PsiInternalEpatchTestLanguage.g:2018:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // PsiInternalEpatchTestLanguage.g:2018:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            // PsiInternalEpatchTestLanguage.g:2019:5: lv_impFrag_2_0= RULE_FRAGMENT
            {

            					markLeaf(elementTypeProvider.getObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleObjectNew"


    // $ANTLR start "entryRuleObjectCopy"
    // PsiInternalEpatchTestLanguage.g:2038:1: entryRuleObjectCopy returns [Boolean current=false] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final Boolean entryRuleObjectCopy() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleObjectCopy = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2038:52: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // PsiInternalEpatchTestLanguage.g:2039:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             markComposite(elementTypeProvider.getObjectCopyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectCopy=ruleObjectCopy();

            state._fsp--;

             current =iv_ruleObjectCopy; 
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
    // $ANTLR end "entryRuleObjectCopy"


    // $ANTLR start "ruleObjectCopy"
    // PsiInternalEpatchTestLanguage.g:2045:1: ruleObjectCopy returns [Boolean current=false] : (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final Boolean ruleObjectCopy() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fragment_2_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:2046:1: ( (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // PsiInternalEpatchTestLanguage.g:2047:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:2047:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // PsiInternalEpatchTestLanguage.g:2048:3: otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf(elementTypeProvider.getObjectCopy_CopyKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:2055:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:2056:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:2056:4: (otherlv_1= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:2057:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:2072:3: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // PsiInternalEpatchTestLanguage.g:2073:4: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // PsiInternalEpatchTestLanguage.g:2073:4: (lv_fragment_2_0= RULE_FRAGMENT )
            // PsiInternalEpatchTestLanguage.g:2074:5: lv_fragment_2_0= RULE_FRAGMENT
            {

            					markLeaf(elementTypeProvider.getObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleObjectCopy"


    // $ANTLR start "entryRuleMigration"
    // PsiInternalEpatchTestLanguage.g:2093:1: entryRuleMigration returns [Boolean current=false] : iv_ruleMigration= ruleMigration EOF ;
    public final Boolean entryRuleMigration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMigration = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2093:51: (iv_ruleMigration= ruleMigration EOF )
            // PsiInternalEpatchTestLanguage.g:2094:2: iv_ruleMigration= ruleMigration EOF
            {
             markComposite(elementTypeProvider.getMigrationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMigration=ruleMigration();

            state._fsp--;

             current =iv_ruleMigration; 
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
    // $ANTLR end "entryRuleMigration"


    // $ANTLR start "ruleMigration"
    // PsiInternalEpatchTestLanguage.g:2100:1: ruleMigration returns [Boolean current=false] : ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) ;
    public final Boolean ruleMigration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Boolean lv_first_2_0 = null;

        Boolean lv_asOp_4_0 = null;

        Boolean lv_eachOp_6_0 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2101:1: ( ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) )
            // PsiInternalEpatchTestLanguage.g:2102:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:2102:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            // PsiInternalEpatchTestLanguage.g:2103:3: () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';'
            {
            // PsiInternalEpatchTestLanguage.g:2103:3: ()
            // PsiInternalEpatchTestLanguage.g:2104:4: 
            {

            				precedeComposite(elementTypeProvider.getMigration_MigrationAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getMigration_MigrateKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_43); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:2117:3: ( (lv_first_2_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:2118:4: (lv_first_2_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:2118:4: (lv_first_2_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:2119:5: lv_first_2_0= ruleExecutable
                    {

                    					markComposite(elementTypeProvider.getMigration_FirstExecutableParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_44);
                    lv_first_2_0=ruleExecutable();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:2132:3: ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )?
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
                    // PsiInternalEpatchTestLanguage.g:2133:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:2133:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    // PsiInternalEpatchTestLanguage.g:2134:5: otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) )
                    {

                    					markLeaf(elementTypeProvider.getMigration_AsKeyword_3_0_0ElementType());
                    				
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_45); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalEpatchTestLanguage.g:2141:5: ( (lv_asOp_4_0= ruleExecutable ) )
                    // PsiInternalEpatchTestLanguage.g:2142:6: (lv_asOp_4_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:2142:6: (lv_asOp_4_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:2143:7: lv_asOp_4_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_17);
                    lv_asOp_4_0=ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:2158:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:2158:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    // PsiInternalEpatchTestLanguage.g:2159:5: otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) )
                    {

                    					markLeaf(elementTypeProvider.getMigration_EachKeyword_3_1_0ElementType());
                    				
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_45); 

                    					doneLeaf(otherlv_5);
                    				
                    // PsiInternalEpatchTestLanguage.g:2166:5: ( (lv_eachOp_6_0= ruleExecutable ) )
                    // PsiInternalEpatchTestLanguage.g:2167:6: (lv_eachOp_6_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:2167:6: (lv_eachOp_6_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:2168:7: lv_eachOp_6_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_17);
                    lv_eachOp_6_0=ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

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
        return current;
    }
    // $ANTLR end "ruleMigration"


    // $ANTLR start "entryRuleExecutable"
    // PsiInternalEpatchTestLanguage.g:2194:1: entryRuleExecutable returns [Boolean current=false] : iv_ruleExecutable= ruleExecutable EOF ;
    public final Boolean entryRuleExecutable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExecutable = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2194:52: (iv_ruleExecutable= ruleExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:2195:2: iv_ruleExecutable= ruleExecutable EOF
            {
             markComposite(elementTypeProvider.getExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExecutable=ruleExecutable();

            state._fsp--;

             current =iv_ruleExecutable; 
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
    // $ANTLR end "entryRuleExecutable"


    // $ANTLR start "ruleExecutable"
    // PsiInternalEpatchTestLanguage.g:2201:1: ruleExecutable returns [Boolean current=false] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final Boolean ruleExecutable() throws RecognitionException {
        Boolean current = false;

        Boolean this_JavaExecutable_0 = null;

        Boolean this_ExpressionExecutable_1 = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2202:1: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // PsiInternalEpatchTestLanguage.g:2203:2: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // PsiInternalEpatchTestLanguage.g:2203:2: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
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
                    // PsiInternalEpatchTestLanguage.g:2204:3: this_JavaExecutable_0= ruleJavaExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_JavaExecutableParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_JavaExecutable_0=ruleJavaExecutable();

                    state._fsp--;


                    			current = this_JavaExecutable_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:2213:3: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_ExpressionExecutableParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExpressionExecutable_1=ruleExpressionExecutable();

                    state._fsp--;


                    			current = this_ExpressionExecutable_1;
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
        return current;
    }
    // $ANTLR end "ruleExecutable"


    // $ANTLR start "entryRuleJavaExecutable"
    // PsiInternalEpatchTestLanguage.g:2225:1: entryRuleJavaExecutable returns [Boolean current=false] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final Boolean entryRuleJavaExecutable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJavaExecutable = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2225:56: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:2226:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             markComposite(elementTypeProvider.getJavaExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJavaExecutable=ruleJavaExecutable();

            state._fsp--;

             current =iv_ruleJavaExecutable; 
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
    // $ANTLR end "entryRuleJavaExecutable"


    // $ANTLR start "ruleJavaExecutable"
    // PsiInternalEpatchTestLanguage.g:2232:1: ruleJavaExecutable returns [Boolean current=false] : (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) ;
    public final Boolean ruleJavaExecutable() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalEpatchTestLanguage.g:2233:1: ( (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) )
            // PsiInternalEpatchTestLanguage.g:2234:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            {
            // PsiInternalEpatchTestLanguage.g:2234:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            // PsiInternalEpatchTestLanguage.g:2235:3: otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJavaExecutable_JavaKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:2242:3: ( (lv_method_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:2243:4: (lv_method_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:2243:4: (lv_method_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:2244:5: lv_method_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleJavaExecutable"


    // $ANTLR start "entryRuleExpressionExecutable"
    // PsiInternalEpatchTestLanguage.g:2277:1: entryRuleExpressionExecutable returns [Boolean current=false] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final Boolean entryRuleExpressionExecutable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpressionExecutable = null;


        try {
            // PsiInternalEpatchTestLanguage.g:2277:62: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:2278:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             markComposite(elementTypeProvider.getExpressionExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();

            state._fsp--;

             current =iv_ruleExpressionExecutable; 
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
    // $ANTLR end "entryRuleExpressionExecutable"


    // $ANTLR start "ruleExpressionExecutable"
    // PsiInternalEpatchTestLanguage.g:2284:1: ruleExpressionExecutable returns [Boolean current=false] : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final Boolean ruleExpressionExecutable() throws RecognitionException {
        Boolean current = false;

        Token lv_exprstr_0_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:2285:1: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:2286:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // PsiInternalEpatchTestLanguage.g:2286:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:2287:3: (lv_exprstr_0_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:2287:3: (lv_exprstr_0_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:2288:4: lv_exprstr_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
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
        return current;
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
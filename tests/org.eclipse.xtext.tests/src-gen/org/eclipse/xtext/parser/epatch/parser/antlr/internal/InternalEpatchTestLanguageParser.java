package org.eclipse.xtext.parser.epatch.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEpatchTestLanguageParser extends AbstractInternalAntlrParser {
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


        public InternalEpatchTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEpatchTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEpatchTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g"; }



     	private EpatchTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEpatchTestLanguageParser(TokenStream input, EpatchTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EPatch";	
       	}
       	
       	@Override
       	protected EpatchTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEPatch"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:67:1: entryRuleEPatch returns [EObject current=null] : iv_ruleEPatch= ruleEPatch EOF ;
    public final EObject entryRuleEPatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPatch = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:68:2: (iv_ruleEPatch= ruleEPatch EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:69:2: iv_ruleEPatch= ruleEPatch EOF
            {
             newCompositeNode(grammarAccess.getEPatchRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPatch_in_entryRuleEPatch75);
            iv_ruleEPatch=ruleEPatch();

            state._fsp--;

             current =iv_ruleEPatch; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPatch85); 

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
    // $ANTLR end "entryRuleEPatch"


    // $ANTLR start "ruleEPatch"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:76:1: ruleEPatch returns [EObject current=null] : (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) ;
    public final EObject ruleEPatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_imports_3_0 = null;

        EObject lv_resources_4_0 = null;

        EObject lv_objects_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:79:28: ( (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:1: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:1: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:80:3: otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEPatch122); 

                	newLeafNode(otherlv_0, grammarAccess.getEPatchAccess().getEpatchKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPatch139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEPatchAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEPatchRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEPatch156); 

                	newLeafNode(otherlv_2, grammarAccess.getEPatchAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:106:1: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:107:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:107:1: (lv_imports_3_0= ruleImport )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:108:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPatchAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleEPatch177);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPatchRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:124:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:125:1: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:125:1: (lv_resources_4_0= ruleNamedResource )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:126:3: lv_resources_4_0= ruleNamedResource
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPatchAccess().getResourcesNamedResourceParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_ruleEPatch199);
            	    lv_resources_4_0=ruleNamedResource();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPatchRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"resources",
            	            		lv_resources_4_0, 
            	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.NamedResource");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:142:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:143:1: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:143:1: (lv_objects_5_0= ruleObjectRef )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:144:3: lv_objects_5_0= ruleObjectRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPatchAccess().getObjectsObjectRefParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_ruleEPatch221);
            	    lv_objects_5_0=ruleObjectRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPatchRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"objects",
            	            		lv_objects_5_0, 
            	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.ObjectRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEPatch234); 

                	newLeafNode(otherlv_6, grammarAccess.getEPatchAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleEPatch"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:172:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:173:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:174:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport270);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport280); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:181:1: ruleImport returns [EObject current=null] : (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        EObject this_ModelImport_0 = null;

        EObject this_JavaImport_1 = null;

        EObject this_ExtensionImport_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:184:28: ( (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:185:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:185:1: (this_ModelImport_0= ruleModelImport | this_JavaImport_1= ruleJavaImport | this_ExtensionImport_2= ruleExtensionImport )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:186:5: this_ModelImport_0= ruleModelImport
                    {
                     
                            newCompositeNode(grammarAccess.getImportAccess().getModelImportParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_ruleImport327);
                    this_ModelImport_0=ruleModelImport();

                    state._fsp--;

                     
                            current = this_ModelImport_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:196:5: this_JavaImport_1= ruleJavaImport
                    {
                     
                            newCompositeNode(grammarAccess.getImportAccess().getJavaImportParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_ruleImport354);
                    this_JavaImport_1=ruleJavaImport();

                    state._fsp--;

                     
                            current = this_JavaImport_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:206:5: this_ExtensionImport_2= ruleExtensionImport
                    {
                     
                            newCompositeNode(grammarAccess.getImportAccess().getExtensionImportParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_ruleImport381);
                    this_ExtensionImport_2=ruleExtensionImport();

                    state._fsp--;

                     
                            current = this_ExtensionImport_2; 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleModelImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:222:1: entryRuleModelImport returns [EObject current=null] : iv_ruleModelImport= ruleModelImport EOF ;
    public final EObject entryRuleModelImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:223:2: (iv_ruleModelImport= ruleModelImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:224:2: iv_ruleModelImport= ruleModelImport EOF
            {
             newCompositeNode(grammarAccess.getModelImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_entryRuleModelImport416);
            iv_ruleModelImport=ruleModelImport();

            state._fsp--;

             current =iv_ruleModelImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelImport426); 

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
    // $ANTLR end "entryRuleModelImport"


    // $ANTLR start "ruleModelImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:231:1: ruleModelImport returns [EObject current=null] : (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) ;
    public final EObject ruleModelImport() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceImport_0 = null;

        EObject this_EPackageImport_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:234:28: ( (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:235:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:235:1: (this_ResourceImport_0= ruleResourceImport | this_EPackageImport_1= ruleEPackageImport )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:236:5: this_ResourceImport_0= ruleResourceImport
                    {
                     
                            newCompositeNode(grammarAccess.getModelImportAccess().getResourceImportParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_ruleModelImport473);
                    this_ResourceImport_0=ruleResourceImport();

                    state._fsp--;

                     
                            current = this_ResourceImport_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:246:5: this_EPackageImport_1= ruleEPackageImport
                    {
                     
                            newCompositeNode(grammarAccess.getModelImportAccess().getEPackageImportParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_ruleModelImport500);
                    this_EPackageImport_1=ruleEPackageImport();

                    state._fsp--;

                     
                            current = this_EPackageImport_1; 
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
    // $ANTLR end "ruleModelImport"


    // $ANTLR start "entryRuleResourceImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:262:1: entryRuleResourceImport returns [EObject current=null] : iv_ruleResourceImport= ruleResourceImport EOF ;
    public final EObject entryRuleResourceImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:263:2: (iv_ruleResourceImport= ruleResourceImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:264:2: iv_ruleResourceImport= ruleResourceImport EOF
            {
             newCompositeNode(grammarAccess.getResourceImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_entryRuleResourceImport535);
            iv_ruleResourceImport=ruleResourceImport();

            state._fsp--;

             current =iv_ruleResourceImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceImport545); 

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
    // $ANTLR end "entryRuleResourceImport"


    // $ANTLR start "ruleResourceImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:271:1: ruleResourceImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleResourceImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_uri_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:274:28: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:275:1: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:275:1: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:275:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleResourceImport582); 

                	newLeafNode(otherlv_0, grammarAccess.getResourceImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:279:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:280:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:280:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:281:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleResourceImport599); 

            			newLeafNode(lv_name_1_0, grammarAccess.getResourceImportAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResourceImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleResourceImport616); 

                	newLeafNode(otherlv_2, grammarAccess.getResourceImportAccess().getUriKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:301:1: ( (lv_uri_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:302:1: (lv_uri_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:302:1: (lv_uri_3_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:303:3: lv_uri_3_0= RULE_STRING
            {
            lv_uri_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceImport633); 

            			newLeafNode(lv_uri_3_0, grammarAccess.getResourceImportAccess().getUriSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResourceImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"uri",
                    		lv_uri_3_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleResourceImport"


    // $ANTLR start "entryRuleEPackageImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:327:1: entryRuleEPackageImport returns [EObject current=null] : iv_ruleEPackageImport= ruleEPackageImport EOF ;
    public final EObject entryRuleEPackageImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:328:2: (iv_ruleEPackageImport= ruleEPackageImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:329:2: iv_ruleEPackageImport= ruleEPackageImport EOF
            {
             newCompositeNode(grammarAccess.getEPackageImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport674);
            iv_ruleEPackageImport=ruleEPackageImport();

            state._fsp--;

             current =iv_ruleEPackageImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageImport684); 

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
    // $ANTLR end "entryRuleEPackageImport"


    // $ANTLR start "ruleEPackageImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:336:1: ruleEPackageImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleEPackageImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_nsURI_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:339:28: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:340:1: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:340:1: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:340:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEPackageImport721); 

                	newLeafNode(otherlv_0, grammarAccess.getEPackageImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:344:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:345:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:345:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:346:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPackageImport738); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEPackageImportAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEPackageImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEPackageImport755); 

                	newLeafNode(otherlv_2, grammarAccess.getEPackageImportAccess().getNsKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:366:1: ( (lv_nsURI_3_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:1: (lv_nsURI_3_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:367:1: (lv_nsURI_3_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:368:3: lv_nsURI_3_0= RULE_STRING
            {
            lv_nsURI_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEPackageImport772); 

            			newLeafNode(lv_nsURI_3_0, grammarAccess.getEPackageImportAccess().getNsURISTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEPackageImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"nsURI",
                    		lv_nsURI_3_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleEPackageImport"


    // $ANTLR start "entryRuleJavaImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:392:1: entryRuleJavaImport returns [EObject current=null] : iv_ruleJavaImport= ruleJavaImport EOF ;
    public final EObject entryRuleJavaImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:393:2: (iv_ruleJavaImport= ruleJavaImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:394:2: iv_ruleJavaImport= ruleJavaImport EOF
            {
             newCompositeNode(grammarAccess.getJavaImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_entryRuleJavaImport813);
            iv_ruleJavaImport=ruleJavaImport();

            state._fsp--;

             current =iv_ruleJavaImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaImport823); 

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
    // $ANTLR end "entryRuleJavaImport"


    // $ANTLR start "ruleJavaImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:401:1: ruleJavaImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleJavaImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:404:28: ( (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:405:1: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:405:1: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:405:3: otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleJavaImport860); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaImportAccess().getImportKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaImport872); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaImportAccess().getJavaKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:413:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:414:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:414:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:415:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport889); 

            			newLeafNode(lv_path_2_0, grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaImportRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"path",
                    		lv_path_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:431:2: (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:431:4: otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleJavaImport907); 

            	        	newLeafNode(otherlv_3, grammarAccess.getJavaImportAccess().getFullStopKeyword_3_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:435:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:436:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:436:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:437:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport924); 

            	    			newLeafNode(lv_path_4_0, grammarAccess.getJavaImportAccess().getPathIDTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getJavaImportRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"path",
            	            		lv_path_4_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

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
    // $ANTLR end "ruleJavaImport"


    // $ANTLR start "entryRuleExtensionImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:461:1: entryRuleExtensionImport returns [EObject current=null] : iv_ruleExtensionImport= ruleExtensionImport EOF ;
    public final EObject entryRuleExtensionImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionImport = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:462:2: (iv_ruleExtensionImport= ruleExtensionImport EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:463:2: iv_ruleExtensionImport= ruleExtensionImport EOF
            {
             newCompositeNode(grammarAccess.getExtensionImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport967);
            iv_ruleExtensionImport=ruleExtensionImport();

            state._fsp--;

             current =iv_ruleExtensionImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtensionImport977); 

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
    // $ANTLR end "entryRuleExtensionImport"


    // $ANTLR start "ruleExtensionImport"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:470:1: ruleExtensionImport returns [EObject current=null] : (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final EObject ruleExtensionImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:473:28: ( (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:474:1: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:474:1: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:474:3: otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleExtensionImport1014); 

                	newLeafNode(otherlv_0, grammarAccess.getExtensionImportAccess().getImportKeyword_0());
                
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleExtensionImport1026); 

                	newLeafNode(otherlv_1, grammarAccess.getExtensionImportAccess().getExtensionKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:482:1: ( (lv_path_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:483:1: (lv_path_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:483:1: (lv_path_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:484:3: lv_path_2_0= RULE_ID
            {
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport1043); 

            			newLeafNode(lv_path_2_0, grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExtensionImportRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"path",
                    		lv_path_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:500:2: (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:500:4: otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleExtensionImport1061); 

            	        	newLeafNode(otherlv_3, grammarAccess.getExtensionImportAccess().getColonColonKeyword_3_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:504:1: ( (lv_path_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:505:1: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:505:1: (lv_path_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:506:3: lv_path_4_0= RULE_ID
            	    {
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport1078); 

            	    			newLeafNode(lv_path_4_0, grammarAccess.getExtensionImportAccess().getPathIDTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getExtensionImportRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"path",
            	            		lv_path_4_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

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
    // $ANTLR end "ruleExtensionImport"


    // $ANTLR start "entryRuleNamedResource"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:530:1: entryRuleNamedResource returns [EObject current=null] : iv_ruleNamedResource= ruleNamedResource EOF ;
    public final EObject entryRuleNamedResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResource = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:531:2: (iv_ruleNamedResource= ruleNamedResource EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:532:2: iv_ruleNamedResource= ruleNamedResource EOF
            {
             newCompositeNode(grammarAccess.getNamedResourceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_entryRuleNamedResource1121);
            iv_ruleNamedResource=ruleNamedResource();

            state._fsp--;

             current =iv_ruleNamedResource; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedResource1131); 

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
    // $ANTLR end "entryRuleNamedResource"


    // $ANTLR start "ruleNamedResource"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:539:1: ruleNamedResource returns [EObject current=null] : (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) ;
    public final EObject ruleNamedResource() throws RecognitionException {
        EObject current = null;

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
        EObject lv_leftRoot_6_0 = null;

        EObject lv_rightRoot_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:542:28: ( (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:543:1: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:543:1: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:543:3: otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNamedResource1168); 

                	newLeafNode(otherlv_0, grammarAccess.getNamedResourceAccess().getResourceKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:547:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:548:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:548:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:549:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedResource1185); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNamedResourceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamedResourceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNamedResource1202); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResourceAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNamedResource1214); 

                	newLeafNode(otherlv_3, grammarAccess.getNamedResourceAccess().getLeftKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:1: ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:2: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:2: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:573:4: otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1228); 

                        	newLeafNode(otherlv_4, grammarAccess.getNamedResourceAccess().getUriKeyword_4_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:577:1: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:1: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:578:1: (lv_leftUri_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:579:3: lv_leftUri_5_0= RULE_STRING
                    {
                    lv_leftUri_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1245); 

                    			newLeafNode(lv_leftUri_5_0, grammarAccess.getNamedResourceAccess().getLeftUriSTRINGTerminalRuleCall_4_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNamedResourceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"leftUri",
                            		lv_leftUri_5_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:596:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:596:6: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:597:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:597:1: (lv_leftRoot_6_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:598:3: lv_leftRoot_6_0= ruleCreatedObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getNamedResourceAccess().getLeftRootCreatedObjectParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1278);
                    lv_leftRoot_6_0=ruleCreatedObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNamedResourceRule());
                    	        }
                           		set(
                           			current, 
                           			"leftRoot",
                            		lv_leftRoot_6_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.CreatedObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1291); 

                	newLeafNode(otherlv_7, grammarAccess.getNamedResourceAccess().getSemicolonKeyword_5());
                
            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNamedResource1303); 

                	newLeafNode(otherlv_8, grammarAccess.getNamedResourceAccess().getRightKeyword_6());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:622:1: ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:622:2: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:622:2: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:622:4: otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1317); 

                        	newLeafNode(otherlv_9, grammarAccess.getNamedResourceAccess().getUriKeyword_7_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:626:1: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:627:1: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:627:1: (lv_rightUri_10_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:628:3: lv_rightUri_10_0= RULE_STRING
                    {
                    lv_rightUri_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1334); 

                    			newLeafNode(lv_rightUri_10_0, grammarAccess.getNamedResourceAccess().getRightUriSTRINGTerminalRuleCall_7_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNamedResourceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rightUri",
                            		lv_rightUri_10_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:645:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:645:6: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:646:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:646:1: (lv_rightRoot_11_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:647:3: lv_rightRoot_11_0= ruleCreatedObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getNamedResourceAccess().getRightRootCreatedObjectParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1367);
                    lv_rightRoot_11_0=ruleCreatedObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNamedResourceRule());
                    	        }
                           		set(
                           			current, 
                           			"rightRoot",
                            		lv_rightRoot_11_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.CreatedObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1380); 

                	newLeafNode(otherlv_12, grammarAccess.getNamedResourceAccess().getSemicolonKeyword_8());
                
            otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNamedResource1392); 

                	newLeafNode(otherlv_13, grammarAccess.getNamedResourceAccess().getRightCurlyBracketKeyword_9());
                

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
    // $ANTLR end "ruleNamedResource"


    // $ANTLR start "entryRuleObjectRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:681:1: entryRuleObjectRef returns [EObject current=null] : iv_ruleObjectRef= ruleObjectRef EOF ;
    public final EObject entryRuleObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:682:2: (iv_ruleObjectRef= ruleObjectRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:683:2: iv_ruleObjectRef= ruleObjectRef EOF
            {
             newCompositeNode(grammarAccess.getObjectRefRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_entryRuleObjectRef1430);
            iv_ruleObjectRef=ruleObjectRef();

            state._fsp--;

             current =iv_ruleObjectRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectRef1440); 

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
    // $ANTLR end "entryRuleObjectRef"


    // $ANTLR start "ruleObjectRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:690:1: ruleObjectRef returns [EObject current=null] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) ;
    public final EObject ruleObjectRef() throws RecognitionException {
        EObject current = null;

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
        EObject lv_assignments_11_0 = null;

        EObject lv_assignments_12_0 = null;

        EObject lv_leftMig_14_0 = null;

        EObject lv_rightMig_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:693:28: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:694:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:694:1: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:694:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleObjectRef1477); 

                	newLeafNode(otherlv_0, grammarAccess.getObjectRefAccess().getObjectKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:698:1: ( (lv_name_1_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:699:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:699:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:700:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1494); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getObjectRefAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:716:3: ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:716:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:716:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:716:5: ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:716:5: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:717:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:717:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:718:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1522); 

                    		newLeafNode(otherlv_2, grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_0_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:729:2: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:730:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:730:1: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:731:3: lv_leftFrag_3_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_3_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1539); 

                    			newLeafNode(lv_leftFrag_3_0, grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"leftFrag",
                            		lv_leftFrag_3_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:6: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:6: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:748:8: otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {
                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef1564); 

                        	newLeafNode(otherlv_4, grammarAccess.getObjectRefAccess().getLeftKeyword_2_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:752:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:753:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:754:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1584); 

                    		newLeafNode(otherlv_5, grammarAccess.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_1_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:765:2: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:766:1: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:767:3: lv_leftFrag_6_0= RULE_FRAGMENT
                    {
                    lv_leftFrag_6_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1601); 

                    			newLeafNode(lv_leftFrag_6_0, grammarAccess.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"leftFrag",
                            		lv_leftFrag_6_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef1618); 

                        	newLeafNode(otherlv_7, grammarAccess.getObjectRefAccess().getRightKeyword_2_1_3());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:787:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:788:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:788:1: (otherlv_8= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:789:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1638); 

                    		newLeafNode(otherlv_8, grammarAccess.getObjectRefAccess().getRightResNamedResourceCrossReference_2_1_4_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:800:2: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:801:1: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:802:3: lv_rightFrag_9_0= RULE_FRAGMENT
                    {
                    lv_rightFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1655); 

                    			newLeafNode(lv_rightFrag_9_0, grammarAccess.getObjectRefAccess().getRightFragFRAGMENTTerminalRuleCall_2_1_5_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectRefRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rightFrag",
                            		lv_rightFrag_9_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:818:4: (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:818:6: otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}'
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleObjectRef1675); 

                        	newLeafNode(otherlv_10, grammarAccess.getObjectRefAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:822:1: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            int LA12_2 = input.LA(2);

                            if ( (LA12_2==27) ) {
                                int LA12_3 = input.LA(3);

                                if ( ((LA12_3>=RULE_ID && LA12_3<=RULE_STRING)||(LA12_3>=33 && LA12_3<=35)) ) {
                                    alt12=1;
                                }
                                else if ( (LA12_3==29) ) {
                                    alt12=2;
                                }


                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:822:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:822:2: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:823:1: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:824:3: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1697);
                    	    lv_assignments_11_0=ruleBiSingleAssignment();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getObjectRefRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"assignments",
                    	            		lv_assignments_11_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.BiSingleAssignment");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:841:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:841:6: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:842:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:842:1: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:843:3: lv_assignments_12_0= ruleBiListAssignment
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getObjectRefAccess().getAssignmentsBiListAssignmentParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_ruleObjectRef1724);
                    	    lv_assignments_12_0=ruleBiListAssignment();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getObjectRefRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"assignments",
                    	            		lv_assignments_12_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.BiListAssignment");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:859:4: (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:859:6: otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {
                            otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef1739); 

                                	newLeafNode(otherlv_13, grammarAccess.getObjectRefAccess().getLeftKeyword_3_2_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:863:1: ( (lv_leftMig_14_0= ruleMigration ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:864:1: (lv_leftMig_14_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:864:1: (lv_leftMig_14_0= ruleMigration )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:865:3: lv_leftMig_14_0= ruleMigration
                            {
                             
                            	        newCompositeNode(grammarAccess.getObjectRefAccess().getLeftMigMigrationParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef1760);
                            lv_leftMig_14_0=ruleMigration();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getObjectRefRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"leftMig",
                                    		lv_leftMig_14_0, 
                                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Migration");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:4: (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:881:6: otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {
                            otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef1775); 

                                	newLeafNode(otherlv_15, grammarAccess.getObjectRefAccess().getRightKeyword_3_3_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:885:1: ( (lv_rightMig_16_0= ruleMigration ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:1: (lv_rightMig_16_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:886:1: (lv_rightMig_16_0= ruleMigration )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:887:3: lv_rightMig_16_0= ruleMigration
                            {
                             
                            	        newCompositeNode(grammarAccess.getObjectRefAccess().getRightMigMigrationParserRuleCall_3_3_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef1796);
                            lv_rightMig_16_0=ruleMigration();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getObjectRefRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"rightMig",
                                    		lv_rightMig_16_0, 
                                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Migration");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObjectRef1810); 

                        	newLeafNode(otherlv_17, grammarAccess.getObjectRefAccess().getRightCurlyBracketKeyword_3_4());
                        

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
    // $ANTLR end "ruleObjectRef"


    // $ANTLR start "entryRuleBiSingleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:917:1: entryRuleBiSingleAssignment returns [EObject current=null] : iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF ;
    public final EObject entryRuleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:918:2: (iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:919:2: iv_ruleBiSingleAssignment= ruleBiSingleAssignment EOF
            {
             newCompositeNode(grammarAccess.getBiSingleAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1850);
            iv_ruleBiSingleAssignment=ruleBiSingleAssignment();

            state._fsp--;

             current =iv_ruleBiSingleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiSingleAssignment1860); 

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
    // $ANTLR end "entryRuleBiSingleAssignment"


    // $ANTLR start "ruleBiSingleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:926:1: ruleBiSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) ;
    public final EObject ruleBiSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_leftValue_2_0 = null;

        EObject lv_rightValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:929:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:2: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:930:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:931:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:931:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:932:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiSingleAssignment1902); 

            			newLeafNode(lv_feature_0_0, grammarAccess.getBiSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBiSingleAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"feature",
                    		lv_feature_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBiSingleAssignment1919); 

                	newLeafNode(otherlv_1, grammarAccess.getBiSingleAssignmentAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:952:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:953:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:954:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        newCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1940);
            lv_leftValue_2_0=ruleSingleAssignmentValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBiSingleAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"leftValue",
                    		lv_leftValue_2_0, 
                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.SingleAssignmentValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBiSingleAssignment1952); 

                	newLeafNode(otherlv_3, grammarAccess.getBiSingleAssignmentAccess().getVerticalLineKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:974:1: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:975:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:975:1: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:976:3: lv_rightValue_4_0= ruleSingleAssignmentValue
            {
             
            	        newCompositeNode(grammarAccess.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1973);
            lv_rightValue_4_0=ruleSingleAssignmentValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBiSingleAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"rightValue",
                    		lv_rightValue_4_0, 
                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.SingleAssignmentValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBiSingleAssignment1985); 

                	newLeafNode(otherlv_5, grammarAccess.getBiSingleAssignmentAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleBiSingleAssignment"


    // $ANTLR start "entryRuleBiListAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1004:1: entryRuleBiListAssignment returns [EObject current=null] : iv_ruleBiListAssignment= ruleBiListAssignment EOF ;
    public final EObject entryRuleBiListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBiListAssignment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1005:2: (iv_ruleBiListAssignment= ruleBiListAssignment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1006:2: iv_ruleBiListAssignment= ruleBiListAssignment EOF
            {
             newCompositeNode(grammarAccess.getBiListAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2021);
            iv_ruleBiListAssignment=ruleBiListAssignment();

            state._fsp--;

             current =iv_ruleBiListAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiListAssignment2031); 

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
    // $ANTLR end "entryRuleBiListAssignment"


    // $ANTLR start "ruleBiListAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1013:1: ruleBiListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) ;
    public final EObject ruleBiListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;

        EObject lv_rightValues_7_0 = null;

        EObject lv_rightValues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1016:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1017:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1017:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1017:2: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1017:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1018:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1018:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1019:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiListAssignment2073); 

            			newLeafNode(lv_feature_0_0, grammarAccess.getBiListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBiListAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"feature",
                    		lv_feature_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBiListAssignment2090); 

                	newLeafNode(otherlv_1, grammarAccess.getBiListAssignmentAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleBiListAssignment2102); 

                	newLeafNode(otherlv_2, grammarAccess.getBiListAssignmentAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1043:1: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1043:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1043:2: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1044:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1044:1: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1045:3: lv_leftValues_3_0= ruleListAssignmentValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2124);
                    lv_leftValues_3_0=ruleListAssignmentValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBiListAssignmentRule());
                    	        }
                           		add(
                           			current, 
                           			"leftValues",
                            		lv_leftValues_3_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.ListAssignmentValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1061:2: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1061:4: otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2137); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBiListAssignmentAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1065:1: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1066:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1066:1: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1067:3: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2158);
                    	    lv_leftValues_5_0=ruleListAssignmentValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getBiListAssignmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"leftValues",
                    	            		lv_leftValues_5_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.ListAssignmentValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBiListAssignment2174); 

                	newLeafNode(otherlv_6, grammarAccess.getBiListAssignmentAccess().getVerticalLineKeyword_4());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1087:1: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1087:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1087:2: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1088:1: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1089:3: lv_rightValues_7_0= ruleListAssignmentValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2196);
                    lv_rightValues_7_0=ruleListAssignmentValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBiListAssignmentRule());
                    	        }
                           		add(
                           			current, 
                           			"rightValues",
                            		lv_rightValues_7_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.ListAssignmentValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1105:2: (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1105:4: otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {
                    	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2209); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getBiListAssignmentAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1109:1: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1110:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1110:1: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1111:3: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2230);
                    	    lv_rightValues_9_0=ruleListAssignmentValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getBiListAssignmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"rightValues",
                    	            		lv_rightValues_9_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.ListAssignmentValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            otherlv_10=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleBiListAssignment2246); 

                	newLeafNode(otherlv_10, grammarAccess.getBiListAssignmentAccess().getRightSquareBracketKeyword_6());
                
            otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBiListAssignment2258); 

                	newLeafNode(otherlv_11, grammarAccess.getBiListAssignmentAccess().getSemicolonKeyword_7());
                

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
    // $ANTLR end "ruleBiListAssignment"


    // $ANTLR start "entryRuleMonoSingleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1143:1: entryRuleMonoSingleAssignment returns [EObject current=null] : iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF ;
    public final EObject entryRuleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoSingleAssignment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1144:2: (iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1145:2: iv_ruleMonoSingleAssignment= ruleMonoSingleAssignment EOF
            {
             newCompositeNode(grammarAccess.getMonoSingleAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2294);
            iv_ruleMonoSingleAssignment=ruleMonoSingleAssignment();

            state._fsp--;

             current =iv_ruleMonoSingleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoSingleAssignment2304); 

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
    // $ANTLR end "entryRuleMonoSingleAssignment"


    // $ANTLR start "ruleMonoSingleAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1152:1: ruleMonoSingleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) ;
    public final EObject ruleMonoSingleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_leftValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1155:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1156:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1156:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1156:2: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1156:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1157:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1157:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1158:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2346); 

            			newLeafNode(lv_feature_0_0, grammarAccess.getMonoSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMonoSingleAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"feature",
                    		lv_feature_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoSingleAssignment2363); 

                	newLeafNode(otherlv_1, grammarAccess.getMonoSingleAssignmentAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1178:1: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1179:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1179:1: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1180:3: lv_leftValue_2_0= ruleSingleAssignmentValue
            {
             
            	        newCompositeNode(grammarAccess.getMonoSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2384);
            lv_leftValue_2_0=ruleSingleAssignmentValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMonoSingleAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"leftValue",
                    		lv_leftValue_2_0, 
                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.SingleAssignmentValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoSingleAssignment2396); 

                	newLeafNode(otherlv_3, grammarAccess.getMonoSingleAssignmentAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleMonoSingleAssignment"


    // $ANTLR start "entryRuleMonoListAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1208:1: entryRuleMonoListAssignment returns [EObject current=null] : iv_ruleMonoListAssignment= ruleMonoListAssignment EOF ;
    public final EObject entryRuleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonoListAssignment = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1209:2: (iv_ruleMonoListAssignment= ruleMonoListAssignment EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1210:2: iv_ruleMonoListAssignment= ruleMonoListAssignment EOF
            {
             newCompositeNode(grammarAccess.getMonoListAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2432);
            iv_ruleMonoListAssignment=ruleMonoListAssignment();

            state._fsp--;

             current =iv_ruleMonoListAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoListAssignment2442); 

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
    // $ANTLR end "entryRuleMonoListAssignment"


    // $ANTLR start "ruleMonoListAssignment"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1217:1: ruleMonoListAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) ;
    public final EObject ruleMonoListAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_leftValues_3_0 = null;

        EObject lv_leftValues_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1220:28: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1221:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1221:1: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1221:2: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1221:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1222:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1222:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1223:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoListAssignment2484); 

            			newLeafNode(lv_feature_0_0, grammarAccess.getMonoListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMonoListAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"feature",
                    		lv_feature_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoListAssignment2501); 

                	newLeafNode(otherlv_1, grammarAccess.getMonoListAssignmentAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMonoListAssignment2513); 

                	newLeafNode(otherlv_2, grammarAccess.getMonoListAssignmentAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:1: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1247:2: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1248:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1248:1: (lv_leftValues_3_0= ruleAssignmentValue )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1249:3: lv_leftValues_3_0= ruleAssignmentValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2535);
                    lv_leftValues_3_0=ruleAssignmentValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMonoListAssignmentRule());
                    	        }
                           		add(
                           			current, 
                           			"leftValues",
                            		lv_leftValues_3_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.AssignmentValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1265:2: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1265:4: otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleMonoListAssignment2548); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getMonoListAssignmentAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1269:1: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1270:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1270:1: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1271:3: lv_leftValues_5_0= ruleAssignmentValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2569);
                    	    lv_leftValues_5_0=ruleAssignmentValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMonoListAssignmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"leftValues",
                    	            		lv_leftValues_5_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.AssignmentValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMonoListAssignment2585); 

                	newLeafNode(otherlv_6, grammarAccess.getMonoListAssignmentAccess().getRightSquareBracketKeyword_4());
                
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoListAssignment2597); 

                	newLeafNode(otherlv_7, grammarAccess.getMonoListAssignmentAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleMonoListAssignment"


    // $ANTLR start "entryRuleAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1303:1: entryRuleAssignmentValue returns [EObject current=null] : iv_ruleAssignmentValue= ruleAssignmentValue EOF ;
    public final EObject entryRuleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1304:2: (iv_ruleAssignmentValue= ruleAssignmentValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1305:2: iv_ruleAssignmentValue= ruleAssignmentValue EOF
            {
             newCompositeNode(grammarAccess.getAssignmentValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2633);
            iv_ruleAssignmentValue=ruleAssignmentValue();

            state._fsp--;

             current =iv_ruleAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentValue2643); 

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
    // $ANTLR end "entryRuleAssignmentValue"


    // $ANTLR start "ruleAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1312:1: ruleAssignmentValue returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleAssignmentValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_refFeature_3_0=null;
        Token otherlv_4=null;
        Token lv_refIndex_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_impFrag_9_0=null;
        EObject lv_newObject_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1315:28: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1316:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1316:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1316:2: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1316:2: ( (lv_value_0_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1317:1: (lv_value_0_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1317:1: (lv_value_0_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1318:3: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAssignmentValue2685); 

                    			newLeafNode(lv_value_0_0, grammarAccess.getAssignmentValueAccess().getValueSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_0_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1335:6: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1335:6: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1335:7: ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1335:7: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1336:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1336:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1337:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2717); 

                    		newLeafNode(otherlv_1, grammarAccess.getAssignmentValueAccess().getRefObjectNamedObjectCrossReference_1_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1348:2: (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1348:4: otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            {
                            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAssignmentValue2730); 

                                	newLeafNode(otherlv_2, grammarAccess.getAssignmentValueAccess().getFullStopKeyword_1_1_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1352:1: ( (lv_refFeature_3_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1353:1: (lv_refFeature_3_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1353:1: (lv_refFeature_3_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1354:3: lv_refFeature_3_0= RULE_ID
                            {
                            lv_refFeature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2747); 

                            			newLeafNode(lv_refFeature_3_0, grammarAccess.getAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_1_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"refFeature",
                                    		lv_refFeature_3_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1370:2: (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1370:4: otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']'
                                    {
                                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAssignmentValue2765); 

                                        	newLeafNode(otherlv_4, grammarAccess.getAssignmentValueAccess().getLeftSquareBracketKeyword_1_1_2_0());
                                        
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1374:1: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1375:1: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1375:1: (lv_refIndex_5_0= RULE_INT )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1376:3: lv_refIndex_5_0= RULE_INT
                                    {
                                    lv_refIndex_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssignmentValue2782); 

                                    			newLeafNode(lv_refIndex_5_0, grammarAccess.getAssignmentValueAccess().getRefIndexINTTerminalRuleCall_1_1_2_1_0()); 
                                    		

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                                    	        }
                                           		setWithLastConsumed(
                                           			current, 
                                           			"refIndex",
                                            		lv_refIndex_5_0, 
                                            		"org.eclipse.xtext.common.Terminals.INT");
                                    	    

                                    }


                                    }

                                    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignmentValue2799); 

                                        	newLeafNode(otherlv_6, grammarAccess.getAssignmentValueAccess().getRightSquareBracketKeyword_1_1_2_2());
                                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1397:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1397:6: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1398:1: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1398:1: (lv_newObject_7_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1399:3: lv_newObject_7_0= ruleCreatedObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2831);
                    lv_newObject_7_0=ruleCreatedObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssignmentValueRule());
                    	        }
                           		set(
                           			current, 
                           			"newObject",
                            		lv_newObject_7_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.CreatedObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1416:6: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1416:6: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1416:7: ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1416:7: ( (otherlv_8= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1417:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1417:1: (otherlv_8= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1418:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue2858); 

                    		newLeafNode(otherlv_8, grammarAccess.getAssignmentValueAccess().getImportImportCrossReference_3_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1429:2: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1430:1: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1431:3: lv_impFrag_9_0= RULE_FRAGMENT
                    {
                    lv_impFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2875); 

                    			newLeafNode(lv_impFrag_9_0, grammarAccess.getAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"impFrag",
                            		lv_impFrag_9_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }


                    }


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
    // $ANTLR end "ruleAssignmentValue"


    // $ANTLR start "entryRuleListAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1455:1: entryRuleListAssignmentValue returns [EObject current=null] : iv_ruleListAssignmentValue= ruleListAssignmentValue EOF ;
    public final EObject entryRuleListAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1456:2: (iv_ruleListAssignmentValue= ruleListAssignmentValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1457:2: iv_ruleListAssignmentValue= ruleListAssignmentValue EOF
            {
             newCompositeNode(grammarAccess.getListAssignmentValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2917);
            iv_ruleListAssignmentValue=ruleListAssignmentValue();

            state._fsp--;

             current =iv_ruleListAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListAssignmentValue2927); 

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
    // $ANTLR end "entryRuleListAssignmentValue"


    // $ANTLR start "ruleListAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1464:1: ruleListAssignmentValue returns [EObject current=null] : ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
    public final EObject ruleListAssignmentValue() throws RecognitionException {
        EObject current = null;

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
        EObject lv_newObject_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1467:28: ( ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:1: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:1: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:2: ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1468:2: ( (lv_index_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1469:1: (lv_index_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1469:1: (lv_index_0_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1470:3: lv_index_0_0= RULE_INT
            {
            lv_index_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue2969); 

            			newLeafNode(lv_index_0_0, grammarAccess.getListAssignmentValueAccess().getIndexINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"index",
                    		lv_index_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleListAssignmentValue2986); 

                	newLeafNode(otherlv_1, grammarAccess.getListAssignmentValueAccess().getColonKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:1: ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:2: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:2: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1490:4: otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue3000); 

                        	newLeafNode(otherlv_2, grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1494:1: ( (lv_refIndex_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1495:1: (lv_refIndex_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1495:1: (lv_refIndex_3_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1496:3: lv_refIndex_3_0= RULE_INT
                    {
                    lv_refIndex_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue3017); 

                    			newLeafNode(lv_refIndex_3_0, grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"refIndex",
                            		lv_refIndex_3_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue3034); 

                        	newLeafNode(otherlv_4, grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1517:6: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1517:6: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1518:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1518:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1519:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleListAssignmentValue3058); 

                    			newLeafNode(lv_value_5_0, grammarAccess.getListAssignmentValueAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1536:6: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1536:6: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1536:7: ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1536:7: ( (otherlv_6= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1537:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1537:1: (otherlv_6= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1538:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue3090); 

                    		newLeafNode(otherlv_6, grammarAccess.getListAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_2_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1549:2: (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1549:4: otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            {
                            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleListAssignmentValue3103); 

                                	newLeafNode(otherlv_7, grammarAccess.getListAssignmentValueAccess().getFullStopKeyword_2_2_1_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1553:1: ( (lv_refFeature_8_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1554:1: (lv_refFeature_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1554:1: (lv_refFeature_8_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1555:3: lv_refFeature_8_0= RULE_ID
                            {
                            lv_refFeature_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue3120); 

                            			newLeafNode(lv_refFeature_8_0, grammarAccess.getListAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_2_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"refFeature",
                                    		lv_refFeature_8_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1571:2: (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1571:4: otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']'
                                    {
                                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue3138); 

                                        	newLeafNode(otherlv_9, grammarAccess.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_2_1_2_0());
                                        
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1575:1: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1576:1: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1576:1: (lv_refIndex_10_0= RULE_INT )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1577:3: lv_refIndex_10_0= RULE_INT
                                    {
                                    lv_refIndex_10_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue3155); 

                                    			newLeafNode(lv_refIndex_10_0, grammarAccess.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_2_1_2_1_0()); 
                                    		

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                                    	        }
                                           		setWithLastConsumed(
                                           			current, 
                                           			"refIndex",
                                            		lv_refIndex_10_0, 
                                            		"org.eclipse.xtext.common.Terminals.INT");
                                    	    

                                    }


                                    }

                                    otherlv_11=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue3172); 

                                        	newLeafNode(otherlv_11, grammarAccess.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_2_1_2_2());
                                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1598:6: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:1: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1599:1: (lv_newObject_12_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1600:3: lv_newObject_12_0= ruleCreatedObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getListAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3204);
                    lv_newObject_12_0=ruleCreatedObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getListAssignmentValueRule());
                    	        }
                           		set(
                           			current, 
                           			"newObject",
                            		lv_newObject_12_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.CreatedObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1617:6: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1617:6: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1617:7: ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1617:7: ( (otherlv_13= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1618:1: (otherlv_13= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1618:1: (otherlv_13= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1619:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue3231); 

                    		newLeafNode(otherlv_13, grammarAccess.getListAssignmentValueAccess().getImportImportCrossReference_2_4_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1630:2: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1631:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1631:1: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1632:3: lv_impFrag_14_0= RULE_FRAGMENT
                    {
                    lv_impFrag_14_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3248); 

                    			newLeafNode(lv_impFrag_14_0, grammarAccess.getListAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_2_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getListAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"impFrag",
                            		lv_impFrag_14_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }


                    }


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
    // $ANTLR end "ruleListAssignmentValue"


    // $ANTLR start "entryRuleSingleAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1656:1: entryRuleSingleAssignmentValue returns [EObject current=null] : iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF ;
    public final EObject entryRuleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAssignmentValue = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1657:2: (iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1658:2: iv_ruleSingleAssignmentValue= ruleSingleAssignmentValue EOF
            {
             newCompositeNode(grammarAccess.getSingleAssignmentValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3291);
            iv_ruleSingleAssignmentValue=ruleSingleAssignmentValue();

            state._fsp--;

             current =iv_ruleSingleAssignmentValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleAssignmentValue3301); 

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
    // $ANTLR end "entryRuleSingleAssignmentValue"


    // $ANTLR start "ruleSingleAssignmentValue"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1665:1: ruleSingleAssignmentValue returns [EObject current=null] : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
    public final EObject ruleSingleAssignmentValue() throws RecognitionException {
        EObject current = null;

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
        EObject lv_newObject_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1668:28: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1669:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1669:1: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1669:2: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1669:2: ( (lv_keyword_0_0= 'null' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1670:1: (lv_keyword_0_0= 'null' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1670:1: (lv_keyword_0_0= 'null' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1671:3: lv_keyword_0_0= 'null'
                    {
                    lv_keyword_0_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSingleAssignmentValue3344); 

                            newLeafNode(lv_keyword_0_0, grammarAccess.getSingleAssignmentValueAccess().getKeywordNullKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(current, "keyword", lv_keyword_0_0, "null");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1685:6: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1685:6: ( (lv_value_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1686:1: (lv_value_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1686:1: (lv_value_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1687:3: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3380); 

                    			newLeafNode(lv_value_1_0, grammarAccess.getSingleAssignmentValueAccess().getValueSTRINGTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1704:6: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1704:6: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1704:7: ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1704:7: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1705:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1706:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3412); 

                    		newLeafNode(otherlv_2, grammarAccess.getSingleAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1717:2: (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1717:4: otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            {
                            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleAssignmentValue3425); 

                                	newLeafNode(otherlv_3, grammarAccess.getSingleAssignmentValueAccess().getFullStopKeyword_2_1_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1721:1: ( (lv_refFeature_4_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1722:1: (lv_refFeature_4_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1722:1: (lv_refFeature_4_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1723:3: lv_refFeature_4_0= RULE_ID
                            {
                            lv_refFeature_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3442); 

                            			newLeafNode(lv_refFeature_4_0, grammarAccess.getSingleAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"refFeature",
                                    		lv_refFeature_4_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1739:2: (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1739:4: otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']'
                                    {
                                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSingleAssignmentValue3460); 

                                        	newLeafNode(otherlv_5, grammarAccess.getSingleAssignmentValueAccess().getLeftSquareBracketKeyword_2_1_2_0());
                                        
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1743:1: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1744:1: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1744:1: (lv_refIndex_6_0= RULE_INT )
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1745:3: lv_refIndex_6_0= RULE_INT
                                    {
                                    lv_refIndex_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3477); 

                                    			newLeafNode(lv_refIndex_6_0, grammarAccess.getSingleAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_1_2_1_0()); 
                                    		

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                                    	        }
                                           		setWithLastConsumed(
                                           			current, 
                                           			"refIndex",
                                            		lv_refIndex_6_0, 
                                            		"org.eclipse.xtext.common.Terminals.INT");
                                    	    

                                    }


                                    }

                                    otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSingleAssignmentValue3494); 

                                        	newLeafNode(otherlv_7, grammarAccess.getSingleAssignmentValueAccess().getRightSquareBracketKeyword_2_1_2_2());
                                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1766:6: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1767:1: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1767:1: (lv_newObject_8_0= ruleCreatedObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1768:3: lv_newObject_8_0= ruleCreatedObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getSingleAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3526);
                    lv_newObject_8_0=ruleCreatedObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                           		set(
                           			current, 
                           			"newObject",
                            		lv_newObject_8_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.CreatedObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:6: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:6: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:7: ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1785:7: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1786:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1786:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1787:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3553); 

                    		newLeafNode(otherlv_9, grammarAccess.getSingleAssignmentValueAccess().getImportImportCrossReference_4_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1798:2: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1799:1: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1800:3: lv_impFrag_10_0= RULE_FRAGMENT
                    {
                    lv_impFrag_10_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3570); 

                    			newLeafNode(lv_impFrag_10_0, grammarAccess.getSingleAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSingleAssignmentValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"impFrag",
                            		lv_impFrag_10_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
                    	    

                    }


                    }


                    }


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
    // $ANTLR end "ruleSingleAssignmentValue"


    // $ANTLR start "entryRuleCreatedObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1824:1: entryRuleCreatedObject returns [EObject current=null] : iv_ruleCreatedObject= ruleCreatedObject EOF ;
    public final EObject entryRuleCreatedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreatedObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1825:2: (iv_ruleCreatedObject= ruleCreatedObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1826:2: iv_ruleCreatedObject= ruleCreatedObject EOF
            {
             newCompositeNode(grammarAccess.getCreatedObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3612);
            iv_ruleCreatedObject=ruleCreatedObject();

            state._fsp--;

             current =iv_ruleCreatedObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreatedObject3622); 

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
    // $ANTLR end "entryRuleCreatedObject"


    // $ANTLR start "ruleCreatedObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1833:1: ruleCreatedObject returns [EObject current=null] : ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) ;
    public final EObject ruleCreatedObject() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject this_ObjectNew_0 = null;

        EObject this_ObjectCopy_1 = null;

        EObject lv_assignments_4_0 = null;

        EObject lv_assignments_5_0 = null;

        EObject lv_leftMig_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1836:28: ( ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:1: ( (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1837:2: (this_ObjectNew_0= ruleObjectNew | this_ObjectCopy_1= ruleObjectCopy )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1838:5: this_ObjectNew_0= ruleObjectNew
                    {
                     
                            newCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectNewParserRuleCall_0_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_ruleCreatedObject3670);
                    this_ObjectNew_0=ruleObjectNew();

                    state._fsp--;

                     
                            current = this_ObjectNew_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1848:5: this_ObjectCopy_1= ruleObjectCopy
                    {
                     
                            newCompositeNode(grammarAccess.getCreatedObjectAccess().getObjectCopyParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_ruleCreatedObject3697);
                    this_ObjectCopy_1=ruleObjectCopy();

                    state._fsp--;

                     
                            current = this_ObjectCopy_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1856:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1857:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1857:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1858:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreatedObject3714); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getCreatedObjectAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCreatedObjectRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1874:3: (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1874:5: otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreatedObject3733); 

                        	newLeafNode(otherlv_3, grammarAccess.getCreatedObjectAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:1: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1878:2: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1879:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1879:1: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1880:3: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3755);
                    	    lv_assignments_4_0=ruleMonoSingleAssignment();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCreatedObjectRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"assignments",
                    	            		lv_assignments_4_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.MonoSingleAssignment");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1897:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1897:6: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1898:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1898:1: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1899:3: lv_assignments_5_0= ruleMonoListAssignment
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCreatedObjectAccess().getAssignmentsMonoListAssignmentParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3782);
                    	    lv_assignments_5_0=ruleMonoListAssignment();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCreatedObjectRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"assignments",
                    	            		lv_assignments_5_0, 
                    	            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.MonoListAssignment");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1915:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1916:1: (lv_leftMig_6_0= ruleMigration )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1916:1: (lv_leftMig_6_0= ruleMigration )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1917:3: lv_leftMig_6_0= ruleMigration
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreatedObjectAccess().getLeftMigMigrationParserRuleCall_2_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleCreatedObject3805);
                            lv_leftMig_6_0=ruleMigration();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreatedObjectRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"leftMig",
                                    		lv_leftMig_6_0, 
                                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Migration");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreatedObject3818); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreatedObjectAccess().getRightCurlyBracketKeyword_2_3());
                        

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
    // $ANTLR end "ruleCreatedObject"


    // $ANTLR start "entryRuleObjectNew"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1945:1: entryRuleObjectNew returns [EObject current=null] : iv_ruleObjectNew= ruleObjectNew EOF ;
    public final EObject entryRuleObjectNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectNew = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1946:2: (iv_ruleObjectNew= ruleObjectNew EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1947:2: iv_ruleObjectNew= ruleObjectNew EOF
            {
             newCompositeNode(grammarAccess.getObjectNewRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_entryRuleObjectNew3856);
            iv_ruleObjectNew=ruleObjectNew();

            state._fsp--;

             current =iv_ruleObjectNew; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectNew3866); 

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
    // $ANTLR end "entryRuleObjectNew"


    // $ANTLR start "ruleObjectNew"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1954:1: ruleObjectNew returns [EObject current=null] : (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectNew() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_impFrag_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1957:28: ( (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:1: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:1: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1958:3: otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleObjectNew3903); 

                	newLeafNode(otherlv_0, grammarAccess.getObjectNewAccess().getNewKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1962:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1963:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1963:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1964:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectNewRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectNew3923); 

            		newLeafNode(otherlv_1, grammarAccess.getObjectNewAccess().getImportImportCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1975:2: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1976:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1976:1: (lv_impFrag_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:1977:3: lv_impFrag_2_0= RULE_FRAGMENT
            {
            lv_impFrag_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3940); 

            			newLeafNode(lv_impFrag_2_0, grammarAccess.getObjectNewAccess().getImpFragFRAGMENTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectNewRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"impFrag",
                    		lv_impFrag_2_0, 
                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
            	    

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
    // $ANTLR end "ruleObjectNew"


    // $ANTLR start "entryRuleObjectCopy"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2001:1: entryRuleObjectCopy returns [EObject current=null] : iv_ruleObjectCopy= ruleObjectCopy EOF ;
    public final EObject entryRuleObjectCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectCopy = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2002:2: (iv_ruleObjectCopy= ruleObjectCopy EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2003:2: iv_ruleObjectCopy= ruleObjectCopy EOF
            {
             newCompositeNode(grammarAccess.getObjectCopyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3981);
            iv_ruleObjectCopy=ruleObjectCopy();

            state._fsp--;

             current =iv_ruleObjectCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectCopy3991); 

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
    // $ANTLR end "entryRuleObjectCopy"


    // $ANTLR start "ruleObjectCopy"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2010:1: ruleObjectCopy returns [EObject current=null] : (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final EObject ruleObjectCopy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fragment_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2013:28: ( (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2014:1: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2014:1: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2014:3: otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleObjectCopy4028); 

                	newLeafNode(otherlv_0, grammarAccess.getObjectCopyAccess().getCopyKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2018:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2019:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2019:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2020:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectCopyRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectCopy4048); 

            		newLeafNode(otherlv_1, grammarAccess.getObjectCopyAccess().getResourceNamedResourceCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2031:2: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2032:1: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2032:1: (lv_fragment_2_0= RULE_FRAGMENT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2033:3: lv_fragment_2_0= RULE_FRAGMENT
            {
            lv_fragment_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4065); 

            			newLeafNode(lv_fragment_2_0, grammarAccess.getObjectCopyAccess().getFragmentFRAGMENTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectCopyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fragment",
                    		lv_fragment_2_0, 
                    		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.FRAGMENT");
            	    

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
    // $ANTLR end "ruleObjectCopy"


    // $ANTLR start "entryRuleMigration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2057:1: entryRuleMigration returns [EObject current=null] : iv_ruleMigration= ruleMigration EOF ;
    public final EObject entryRuleMigration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMigration = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2058:2: (iv_ruleMigration= ruleMigration EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2059:2: iv_ruleMigration= ruleMigration EOF
            {
             newCompositeNode(grammarAccess.getMigrationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_entryRuleMigration4106);
            iv_ruleMigration=ruleMigration();

            state._fsp--;

             current =iv_ruleMigration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMigration4116); 

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
    // $ANTLR end "entryRuleMigration"


    // $ANTLR start "ruleMigration"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2066:1: ruleMigration returns [EObject current=null] : ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleMigration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_first_2_0 = null;

        EObject lv_asOp_4_0 = null;

        EObject lv_eachOp_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2069:28: ( ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2070:1: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2070:1: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2070:2: () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2070:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2071:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMigrationAccess().getMigrationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMigration4162); 

                	newLeafNode(otherlv_1, grammarAccess.getMigrationAccess().getMigrateKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2080:1: ( (lv_first_2_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2081:1: (lv_first_2_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2081:1: (lv_first_2_0= ruleExecutable )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2082:3: lv_first_2_0= ruleExecutable
                    {
                     
                    	        newCompositeNode(grammarAccess.getMigrationAccess().getFirstExecutableParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4183);
                    lv_first_2_0=ruleExecutable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMigrationRule());
                    	        }
                           		set(
                           			current, 
                           			"first",
                            		lv_first_2_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Executable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2098:3: ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2098:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2098:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2098:6: otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) )
                    {
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMigration4198); 

                        	newLeafNode(otherlv_3, grammarAccess.getMigrationAccess().getAsKeyword_3_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2102:1: ( (lv_asOp_4_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2103:1: (lv_asOp_4_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2103:1: (lv_asOp_4_0= ruleExecutable )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2104:3: lv_asOp_4_0= ruleExecutable
                    {
                     
                    	        newCompositeNode(grammarAccess.getMigrationAccess().getAsOpExecutableParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4219);
                    lv_asOp_4_0=ruleExecutable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMigrationRule());
                    	        }
                           		set(
                           			current, 
                           			"asOp",
                            		lv_asOp_4_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Executable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2121:6: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2121:6: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2121:8: otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMigration4239); 

                        	newLeafNode(otherlv_5, grammarAccess.getMigrationAccess().getEachKeyword_3_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2125:1: ( (lv_eachOp_6_0= ruleExecutable ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2126:1: (lv_eachOp_6_0= ruleExecutable )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2126:1: (lv_eachOp_6_0= ruleExecutable )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2127:3: lv_eachOp_6_0= ruleExecutable
                    {
                     
                    	        newCompositeNode(grammarAccess.getMigrationAccess().getEachOpExecutableParserRuleCall_3_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration4260);
                    lv_eachOp_6_0=ruleExecutable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMigrationRule());
                    	        }
                           		set(
                           			current, 
                           			"eachOp",
                            		lv_eachOp_6_0, 
                            		"org.eclipse.xtext.parser.epatch.EpatchTestLanguage.Executable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMigration4275); 

                	newLeafNode(otherlv_7, grammarAccess.getMigrationAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleMigration"


    // $ANTLR start "entryRuleExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2155:1: entryRuleExecutable returns [EObject current=null] : iv_ruleExecutable= ruleExecutable EOF ;
    public final EObject entryRuleExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2156:2: (iv_ruleExecutable= ruleExecutable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2157:2: iv_ruleExecutable= ruleExecutable EOF
            {
             newCompositeNode(grammarAccess.getExecutableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_entryRuleExecutable4311);
            iv_ruleExecutable=ruleExecutable();

            state._fsp--;

             current =iv_ruleExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExecutable4321); 

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
    // $ANTLR end "entryRuleExecutable"


    // $ANTLR start "ruleExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2164:1: ruleExecutable returns [EObject current=null] : (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) ;
    public final EObject ruleExecutable() throws RecognitionException {
        EObject current = null;

        EObject this_JavaExecutable_0 = null;

        EObject this_ExpressionExecutable_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2167:28: ( (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2168:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2168:1: (this_JavaExecutable_0= ruleJavaExecutable | this_ExpressionExecutable_1= ruleExpressionExecutable )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2169:5: this_JavaExecutable_0= ruleJavaExecutable
                    {
                     
                            newCompositeNode(grammarAccess.getExecutableAccess().getJavaExecutableParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_ruleExecutable4368);
                    this_JavaExecutable_0=ruleJavaExecutable();

                    state._fsp--;

                     
                            current = this_JavaExecutable_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2179:5: this_ExpressionExecutable_1= ruleExpressionExecutable
                    {
                     
                            newCompositeNode(grammarAccess.getExecutableAccess().getExpressionExecutableParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_ruleExecutable4395);
                    this_ExpressionExecutable_1=ruleExpressionExecutable();

                    state._fsp--;

                     
                            current = this_ExpressionExecutable_1; 
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
    // $ANTLR end "ruleExecutable"


    // $ANTLR start "entryRuleJavaExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2195:1: entryRuleJavaExecutable returns [EObject current=null] : iv_ruleJavaExecutable= ruleJavaExecutable EOF ;
    public final EObject entryRuleJavaExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaExecutable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2196:2: (iv_ruleJavaExecutable= ruleJavaExecutable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2197:2: iv_ruleJavaExecutable= ruleJavaExecutable EOF
            {
             newCompositeNode(grammarAccess.getJavaExecutableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4430);
            iv_ruleJavaExecutable=ruleJavaExecutable();

            state._fsp--;

             current =iv_ruleJavaExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaExecutable4440); 

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
    // $ANTLR end "entryRuleJavaExecutable"


    // $ANTLR start "ruleJavaExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2204:1: ruleJavaExecutable returns [EObject current=null] : (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) ;
    public final EObject ruleJavaExecutable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2207:28: ( (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:1: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:1: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2208:3: otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaExecutable4477); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaExecutableAccess().getJavaKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2212:1: ( (lv_method_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2213:1: (lv_method_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2213:1: (lv_method_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2214:3: lv_method_1_0= RULE_ID
            {
            lv_method_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaExecutable4494); 

            			newLeafNode(lv_method_1_0, grammarAccess.getJavaExecutableAccess().getMethodIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaExecutableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"method",
                    		lv_method_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleJavaExecutable4511); 

                	newLeafNode(otherlv_2, grammarAccess.getJavaExecutableAccess().getLeftParenthesisKeyword_2());
                
            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleJavaExecutable4523); 

                	newLeafNode(otherlv_3, grammarAccess.getJavaExecutableAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleJavaExecutable"


    // $ANTLR start "entryRuleExpressionExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2246:1: entryRuleExpressionExecutable returns [EObject current=null] : iv_ruleExpressionExecutable= ruleExpressionExecutable EOF ;
    public final EObject entryRuleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionExecutable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2247:2: (iv_ruleExpressionExecutable= ruleExpressionExecutable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2248:2: iv_ruleExpressionExecutable= ruleExpressionExecutable EOF
            {
             newCompositeNode(grammarAccess.getExpressionExecutableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4559);
            iv_ruleExpressionExecutable=ruleExpressionExecutable();

            state._fsp--;

             current =iv_ruleExpressionExecutable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpressionExecutable4569); 

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
    // $ANTLR end "entryRuleExpressionExecutable"


    // $ANTLR start "ruleExpressionExecutable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2255:1: ruleExpressionExecutable returns [EObject current=null] : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final EObject ruleExpressionExecutable() throws RecognitionException {
        EObject current = null;

        Token lv_exprstr_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2258:28: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2259:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2259:1: ( (lv_exprstr_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2260:1: (lv_exprstr_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2260:1: (lv_exprstr_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/epatch/parser/antlr/internal/InternalEpatchTestLanguage.g:2261:3: lv_exprstr_0_0= RULE_STRING
            {
            lv_exprstr_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleExpressionExecutable4610); 

            			newLeafNode(lv_exprstr_0_0, grammarAccess.getExpressionExecutableAccess().getExprstrSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExpressionExecutableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"exprstr",
                    		lv_exprstr_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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
    // $ANTLR end "ruleExpressionExecutable"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEPatch_in_entryRuleEPatch75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPatch85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEPatch122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch139 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleEPatch156 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleImport_in_ruleEPatch177 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch199 = new BitSet(new long[]{0x0000000004404000L});
        public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch221 = new BitSet(new long[]{0x0000000004004000L});
        public static final BitSet FOLLOW_14_in_ruleEPatch234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport270 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_ruleImport327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelImport426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleResourceImport582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport599 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleResourceImport616 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport674 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEPackageImport721 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport738 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEPackageImport755 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleJavaImport860 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJavaImport872 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport889 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleJavaImport907 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport924 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleExtensionImport1014 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleExtensionImport1026 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1043 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleExtensionImport1061 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1078 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNamedResource1168 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1185 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleNamedResource1202 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNamedResource1214 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1228 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1245 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1278 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1291 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleNamedResource1303 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1317 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1334 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1367 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1380 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleNamedResource1392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1430 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleObjectRef1477 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1494 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1522 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1539 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef1564 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1584 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1601 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef1618 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1638 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1655 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleObjectRef1675 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef1697 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef1724 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef1739 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1760 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef1775 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef1796 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObjectRef1810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment1850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment1860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment1902 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment1919 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1940 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment1952 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment1973 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment1985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2073 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiListAssignment2090 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleBiListAssignment2102 = new BitSet(new long[]{0x0000000010000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2124 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2137 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2158 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_28_in_ruleBiListAssignment2174 = new BitSet(new long[]{0x0000000080000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2196 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2209 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2230 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleBiListAssignment2246 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiListAssignment2258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2346 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment2363 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment2384 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment2396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment2432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment2442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment2484 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoListAssignment2501 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleMonoListAssignment2513 = new BitSet(new long[]{0x0000000C80010030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2535 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleMonoListAssignment2548 = new BitSet(new long[]{0x0000000C00010030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment2569 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleMonoListAssignment2585 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoListAssignment2597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue2633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue2643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue2685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2717 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAssignmentValue2730 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2747 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAssignmentValue2765 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue2782 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleAssignmentValue2799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue2831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue2858 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue2875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue2917 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue2927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue2969 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleListAssignmentValue2986 = new BitSet(new long[]{0x0000000C20010030L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3000 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3017 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue3058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3090 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleListAssignmentValue3103 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3120 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3138 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3155 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue3204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue3231 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue3248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue3291 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue3301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue3344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue3380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3412 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue3425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3442 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue3460 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue3477 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue3494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue3526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue3553 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue3570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject3612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject3622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject3670 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject3697 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject3714 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCreatedObject3733 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject3755 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject3782 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject3805 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCreatedObject3818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew3856 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew3866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleObjectNew3903 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew3923 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew3940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy3981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy3991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleObjectCopy4028 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy4048 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy4065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration4106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMigration4116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMigration4162 = new BitSet(new long[]{0x0000006001040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4183 = new BitSet(new long[]{0x0000006001000000L});
        public static final BitSet FOLLOW_37_in_ruleMigration4198 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4219 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_38_in_ruleMigration4239 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration4260 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMigration4275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable4311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExecutable4321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable4368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable4395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable4430 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable4440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleJavaExecutable4477 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable4494 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleJavaExecutable4511 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleJavaExecutable4523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable4559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable4569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable4610 = new BitSet(new long[]{0x0000000000000002L});
    }


}
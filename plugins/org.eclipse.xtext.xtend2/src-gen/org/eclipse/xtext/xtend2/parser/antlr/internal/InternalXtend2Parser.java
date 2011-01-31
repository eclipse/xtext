package org.eclipse.xtext.xtend2.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtend2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_RICH_TEXT", "RULE_RICH_TEXT_START", "RULE_RICH_TEXT_INBETWEEN", "RULE_RICH_TEXT_END", "RULE_INT", "RULE_IN_DOUBLE_QUOTE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'.'", "'*'", "'class'", "'<'", "','", "'>'", "'extends'", "'implements'", "'{'", "'}'", "'('", "')'", "';'", "'FOR'", "':'", "'ENDFOR'", "'IF'", "'ELSE'", "'ENDIF'", "'ELSEIF'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'", "'super'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__80=80;
    public static final int T__51=51;
    public static final int RULE_STRING=5;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int T__74=74;
    public static final int T__39=39;
    public static final int RULE_RICH_TEXT_START=7;
    public static final int RULE_RICH_TEXT=6;
    public static final int T__30=30;
    public static final int RULE_RICH_TEXT_INBETWEEN=8;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=10;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_IN_DOUBLE_QUOTE_RICH_STRING=11;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__78=78;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__79=79;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__77=77;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int RULE_WS=14;
    public static final int T__63=63;
    public static final int T__75=75;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int RULE_RICH_TEXT_END=9;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__76=76;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__82=82;
    public static final int T__26=26;
    public static final int T__81=81;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__83=83;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__71=71;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalXtend2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtend2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtend2Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g"; }



     	private Xtend2GrammarAccess grammarAccess;
     	
        public InternalXtend2Parser(TokenStream input, Xtend2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected Xtend2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:67:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:68:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:69:2: iv_ruleFile= ruleFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFileRule()); 
            }
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile75);
            iv_ruleFile=ruleFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile85); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:76:1: ruleFile returns [EObject current=null] : ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_xtendClass_3_0= ruleClass ) )? ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_package_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_xtendClass_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:79:28: ( ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_xtendClass_3_0= ruleClass ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:1: ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_xtendClass_3_0= ruleClass ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:1: ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_xtendClass_3_0= ruleClass ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:2: (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_xtendClass_3_0= ruleClass ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:2: (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:4: otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) )
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleFile123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getFileAccess().getPackageKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:84:1: ( (lv_package_1_0= ruleQualifiedName ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:85:1: (lv_package_1_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:85:1: (lv_package_1_0= ruleQualifiedName )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:86:3: lv_package_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFileAccess().getPackageQualifiedNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleFile144);
                    lv_package_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFileRule());
                      	        }
                             		set(
                             			current, 
                             			"package",
                              		lv_package_1_0, 
                              		"QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:102:4: ( (lv_imports_2_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:103:1: (lv_imports_2_0= ruleImport )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFileAccess().getImportsImportParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile167);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFileRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_2_0, 
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:120:3: ( (lv_xtendClass_3_0= ruleClass ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:121:1: (lv_xtendClass_3_0= ruleClass )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:121:1: (lv_xtendClass_3_0= ruleClass )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:122:3: lv_xtendClass_3_0= ruleClass
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFileAccess().getXtendClassClassParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClass_in_ruleFile189);
                    lv_xtendClass_3_0=ruleClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFileRule());
                      	        }
                             		set(
                             			current, 
                             			"xtendClass",
                              		lv_xtendClass_3_0, 
                              		"Class");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:146:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:147:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:148:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport226);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport236); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:155:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:158:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:159:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleImport273); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:163:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:164:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:164:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:165:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport294);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:189:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:190:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:191:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard331);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard342); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:198:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:201:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:202:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:202:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:203:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard389);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:213:1: (kw= '.' kw= '*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:214:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildCard408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedNameWithWildCard421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleClass"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:233:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:234:2: (iv_ruleClass= ruleClass EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:235:2: iv_ruleClass= ruleClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassRule()); 
            }
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass463);
            iv_ruleClass=ruleClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClass; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass473); if (state.failed) return current;

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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:242:1: ruleClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )? otherlv_13= '{' ( (lv_members_14_0= ruleMember ) )* otherlv_15= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_extends_8_0 = null;

        EObject lv_implements_10_0 = null;

        EObject lv_implements_12_0 = null;

        EObject lv_members_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:245:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )? otherlv_13= '{' ( (lv_members_14_0= ruleMember ) )* otherlv_15= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )? otherlv_13= '{' ( (lv_members_14_0= ruleMember ) )* otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )? otherlv_13= '{' ( (lv_members_14_0= ruleMember ) )* otherlv_15= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )? (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )? otherlv_13= '{' ( (lv_members_14_0= ruleMember ) )* otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleClass510); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassAccess().getClassKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:250:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:251:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:251:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:252:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClass527); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClassRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:268:2: (otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:268:4: otherlv_2= '<' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleClass545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getClassAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:272:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:273:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:273:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:274:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleClass566);
                    lv_typeParameters_3_0=ruleJvmTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassRule());
                      	        }
                             		add(
                             			current, 
                             			"typeParameters",
                              		lv_typeParameters_3_0, 
                              		"JvmTypeParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:290:2: (otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==22) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:290:4: otherlv_4= ',' ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleClass579); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:1: ( (lv_typeParameters_5_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:295:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:295:1: (lv_typeParameters_5_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:296:3: lv_typeParameters_5_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleClass600);
                    	    lv_typeParameters_5_0=ruleJvmTypeParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getClassRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeParameters",
                    	              		lv_typeParameters_5_0, 
                    	              		"JvmTypeParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleClass614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getClassAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:316:3: (otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:316:5: otherlv_7= 'extends' ( (lv_extends_8_0= ruleJvmTypeReference ) )
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleClass629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getClassAccess().getExtendsKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:320:1: ( (lv_extends_8_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:321:1: (lv_extends_8_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:321:1: (lv_extends_8_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:322:3: lv_extends_8_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassAccess().getExtendsJvmTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass650);
                    lv_extends_8_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassRule());
                      	        }
                             		set(
                             			current, 
                             			"extends",
                              		lv_extends_8_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:338:4: (otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:338:6: otherlv_9= 'implements' ( (lv_implements_10_0= ruleJvmTypeReference ) ) (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )*
                    {
                    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleClass665); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getClassAccess().getImplementsKeyword_4_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:342:1: ( (lv_implements_10_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:343:1: (lv_implements_10_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:343:1: (lv_implements_10_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:344:3: lv_implements_10_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassAccess().getImplementsJvmTypeReferenceParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass686);
                    lv_implements_10_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassRule());
                      	        }
                             		add(
                             			current, 
                             			"implements",
                              		lv_implements_10_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:360:2: (otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:360:4: otherlv_11= ',' ( (lv_implements_12_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleClass699); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getClassAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:364:1: ( (lv_implements_12_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:365:1: (lv_implements_12_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:365:1: (lv_implements_12_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:366:3: lv_implements_12_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClassAccess().getImplementsJvmTypeReferenceParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass720);
                    	    lv_implements_12_0=ruleJvmTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getClassRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"implements",
                    	              		lv_implements_12_0, 
                    	              		"JvmTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,26,FOLLOW_26_in_ruleClass736); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:386:1: ( (lv_members_14_0= ruleMember ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==21||LA10_0==28||LA10_0==80) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:387:1: (lv_members_14_0= ruleMember )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:387:1: (lv_members_14_0= ruleMember )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:388:3: lv_members_14_0= ruleMember
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMember_in_ruleClass757);
            	    lv_members_14_0=ruleMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"members",
            	              		lv_members_14_0, 
            	              		"Member");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_15=(Token)match(input,27,FOLLOW_27_in_ruleClass770); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleMember"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:416:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:417:2: (iv_ruleMember= ruleMember EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:418:2: iv_ruleMember= ruleMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMemberRule()); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember806);
            iv_ruleMember=ruleMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMember; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember816); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:425:1: ruleMember returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:428:28: (this_Function_0= ruleFunction )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:430:5: this_Function_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMemberAccess().getFunctionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleMember862);
            this_Function_0=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Function_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleFunction"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:446:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:447:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:448:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction896);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction906); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:455:1: ruleFunction returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeParameters_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_returnType_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_expression_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:458:28: ( ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:4: otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleFunction944); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getLessThanSignKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:463:1: ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:464:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:464:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:465:3: lv_typeParameters_1_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction965);
                    lv_typeParameters_1_0=ruleJvmTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		add(
                             			current, 
                             			"typeParameters",
                              		lv_typeParameters_1_0, 
                              		"JvmTypeParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:481:2: (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==22) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:481:4: otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleFunction978); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:485:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:486:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:486:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:487:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction999);
                    	    lv_typeParameters_3_0=ruleJvmTypeParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeParameters",
                    	              		lv_typeParameters_3_0, 
                    	              		"JvmTypeParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleFunction1013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getGreaterThanSignKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:507:3: ( (lv_returnType_5_0= ruleJvmTypeReference ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_ID||LA13_1==18||LA13_1==21) ) {
                    alt13=1;
                }
            }
            else if ( (LA13_0==28||LA13_0==80) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:508:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:508:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:509:3: lv_returnType_5_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeJvmTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFunction1036);
                    lv_returnType_5_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		set(
                             			current, 
                             			"returnType",
                              		lv_returnType_5_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:525:3: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:526:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:526:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:527:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction1054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_6_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_6_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleFunction1071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:547:1: ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||LA15_0==28||LA15_0==80) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:547:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:547:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:548:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:548:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:549:3: lv_parameters_8_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1093);
                    lv_parameters_8_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		add(
                             			current, 
                             			"parameters",
                              		lv_parameters_8_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:565:2: (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==22) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:565:4: otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleFunction1106); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:569:1: ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:570:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:570:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:571:3: lv_parameters_10_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1127);
                    	    lv_parameters_10_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"parameters",
                    	              		lv_parameters_10_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,29,FOLLOW_29_in_ruleFunction1143); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:591:1: ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_RICH_TEXT_START)||LA16_0==RULE_INT||LA16_0==21||LA16_0==26||LA16_0==28||(LA16_0>=49 && LA16_0<=50)||LA16_0==54||LA16_0==58||LA16_0==61||LA16_0==63||(LA16_0>=66 && LA16_0<=68)||(LA16_0>=71 && LA16_0<=77)) ) {
                alt16=1;
            }
            else if ( (LA16_0==30) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:591:2: ( (lv_expression_12_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:591:2: ( (lv_expression_12_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:592:1: (lv_expression_12_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:592:1: (lv_expression_12_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:593:3: lv_expression_12_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getExpressionXExpressionParserRuleCall_6_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleFunction1165);
                    lv_expression_12_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_12_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:610:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,30,FOLLOW_30_in_ruleFunction1183); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getFunctionAccess().getSemicolonKeyword_6_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:622:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:623:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:624:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral1220);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral1230); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:631:1: ruleXStringLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject this_RichString_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:634:28: ( ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=RULE_RICH_TEXT && LA17_0<=RULE_RICH_TEXT_START)) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:3: () ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:635:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:636:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:641:2: ( (lv_value_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:642:1: (lv_value_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:642:1: (lv_value_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:643:3: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral1282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXStringLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:661:5: this_RichString_2= ruleRichString
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXStringLiteralAccess().getRichStringParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichString_in_ruleXStringLiteral1316);
                    this_RichString_2=ruleRichString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RichString_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleRichString"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:677:1: entryRuleRichString returns [EObject current=null] : iv_ruleRichString= ruleRichString EOF ;
    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichString = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:678:2: (iv_ruleRichString= ruleRichString EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:679:2: iv_ruleRichString= ruleRichString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringRule()); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString1351);
            iv_ruleRichString=ruleRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString1361); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichString"


    // $ANTLR start "ruleRichString"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:686:1: ruleRichString returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) ) ) ;
    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:689:28: ( ( () ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:690:1: ( () ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:690:1: ( () ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:690:2: () ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:690:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:691:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringAccess().getRichStringAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:2: ( ( (lv_elements_1_0= ruleRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_RICH_TEXT) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_RICH_TEXT_START) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:3: ( (lv_elements_1_0= ruleRichStringLiteral ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:3: ( (lv_elements_1_0= ruleRichStringLiteral ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:697:1: (lv_elements_1_0= ruleRichStringLiteral )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:697:1: (lv_elements_1_0= ruleRichStringLiteral )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:698:3: lv_elements_1_0= ruleRichStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString1417);
                    lv_elements_1_0=ruleRichStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_1_0, 
                              		"RichStringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:715:6: ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:715:6: ( ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:715:7: ( (lv_elements_2_0= ruleRichStringLiteralStart ) ) ( (lv_elements_3_0= ruleRichStringPart ) ) ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )* ( (lv_elements_6_0= ruleRichStringLiteralEnd ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:715:7: ( (lv_elements_2_0= ruleRichStringLiteralStart ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:716:1: (lv_elements_2_0= ruleRichStringLiteralStart )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:716:1: (lv_elements_2_0= ruleRichStringLiteralStart )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:717:3: lv_elements_2_0= ruleRichStringLiteralStart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralStartParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralStart_in_ruleRichString1445);
                    lv_elements_2_0=ruleRichStringLiteralStart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_2_0, 
                              		"RichStringLiteralStart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:733:2: ( (lv_elements_3_0= ruleRichStringPart ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:734:1: (lv_elements_3_0= ruleRichStringPart )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:734:1: (lv_elements_3_0= ruleRichStringPart )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:735:3: lv_elements_3_0= ruleRichStringPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringPartParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringPart_in_ruleRichString1466);
                    lv_elements_3_0=ruleRichStringPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_3_0, 
                              		"RichStringPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:751:2: ( ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_RICH_TEXT_INBETWEEN) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:751:3: ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_5_0= ruleRichStringPart ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:751:3: ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:752:1: (lv_elements_4_0= ruleRichStringLiteralInbetween )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:752:1: (lv_elements_4_0= ruleRichStringLiteralInbetween )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:753:3: lv_elements_4_0= ruleRichStringLiteralInbetween
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString1488);
                    	    lv_elements_4_0=ruleRichStringLiteralInbetween();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_4_0, 
                    	              		"RichStringLiteralInbetween");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:769:2: ( (lv_elements_5_0= ruleRichStringPart ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:770:1: (lv_elements_5_0= ruleRichStringPart )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:770:1: (lv_elements_5_0= ruleRichStringPart )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:771:3: lv_elements_5_0= ruleRichStringPart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringPartParserRuleCall_1_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringPart_in_ruleRichString1509);
                    	    lv_elements_5_0=ruleRichStringPart();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_5_0, 
                    	              		"RichStringPart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:787:4: ( (lv_elements_6_0= ruleRichStringLiteralEnd ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:788:1: (lv_elements_6_0= ruleRichStringLiteralEnd )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:788:1: (lv_elements_6_0= ruleRichStringLiteralEnd )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:789:3: lv_elements_6_0= ruleRichStringLiteralEnd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralEndParserRuleCall_1_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString1532);
                    lv_elements_6_0=ruleRichStringLiteralEnd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_6_0, 
                              		"RichStringLiteralEnd");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichString"


    // $ANTLR start "entryRuleRichStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:813:1: entryRuleRichStringLiteral returns [EObject current=null] : iv_ruleRichStringLiteral= ruleRichStringLiteral EOF ;
    public final EObject entryRuleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:814:2: (iv_ruleRichStringLiteral= ruleRichStringLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:815:2: iv_ruleRichStringLiteral= ruleRichStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral1570);
            iv_ruleRichStringLiteral=ruleRichStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteral1580); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringLiteral"


    // $ANTLR start "ruleRichStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:822:1: ruleRichStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) ;
    public final EObject ruleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:825:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:826:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:826:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:826:2: () ( (lv_value_1_0= RULE_RICH_TEXT ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:826:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:827:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:832:2: ( (lv_value_1_0= RULE_RICH_TEXT ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:833:1: (lv_value_1_0= RULE_RICH_TEXT )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:833:1: (lv_value_1_0= RULE_RICH_TEXT )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:834:3: lv_value_1_0= RULE_RICH_TEXT
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT,FOLLOW_RULE_RICH_TEXT_in_ruleRichStringLiteral1631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRichStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"RICH_TEXT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringLiteral"


    // $ANTLR start "entryRuleRichStringLiteralStart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:858:1: entryRuleRichStringLiteralStart returns [EObject current=null] : iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF ;
    public final EObject entryRuleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralStart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:859:2: (iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:860:2: iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralStartRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart1672);
            iv_ruleRichStringLiteralStart=ruleRichStringLiteralStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralStart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralStart1682); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringLiteralStart"


    // $ANTLR start "ruleRichStringLiteralStart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:867:1: ruleRichStringLiteralStart returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) ) ;
    public final EObject ruleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:870:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:871:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:871:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:871:2: () ( (lv_value_1_0= RULE_RICH_TEXT_START ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:871:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:872:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralStartAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:877:2: ( (lv_value_1_0= RULE_RICH_TEXT_START ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:878:1: (lv_value_1_0= RULE_RICH_TEXT_START )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:878:1: (lv_value_1_0= RULE_RICH_TEXT_START )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:879:3: lv_value_1_0= RULE_RICH_TEXT_START
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_START,FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart1733); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRichStringLiteralStartRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"RICH_TEXT_START");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringLiteralStart"


    // $ANTLR start "entryRuleRichStringLiteralInbetween"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:903:1: entryRuleRichStringLiteralInbetween returns [EObject current=null] : iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF ;
    public final EObject entryRuleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralInbetween = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:904:2: (iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:905:2: iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralInbetweenRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween1774);
            iv_ruleRichStringLiteralInbetween=ruleRichStringLiteralInbetween();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralInbetween; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween1784); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringLiteralInbetween"


    // $ANTLR start "ruleRichStringLiteralInbetween"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:912:1: ruleRichStringLiteralInbetween returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) ;
    public final EObject ruleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:915:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:916:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:916:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:916:2: () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:916:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:917:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralInbetweenAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:922:2: ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:923:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:923:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:924:3: lv_value_1_0= RULE_RICH_TEXT_INBETWEEN
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_INBETWEEN,FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween1835); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralInbetweenAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRichStringLiteralInbetweenRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"RICH_TEXT_INBETWEEN");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringLiteralInbetween"


    // $ANTLR start "entryRuleRichStringLiteralEnd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:948:1: entryRuleRichStringLiteralEnd returns [EObject current=null] : iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF ;
    public final EObject entryRuleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralEnd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:949:2: (iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:950:2: iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralEndRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd1876);
            iv_ruleRichStringLiteralEnd=ruleRichStringLiteralEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralEnd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralEnd1886); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringLiteralEnd"


    // $ANTLR start "ruleRichStringLiteralEnd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:957:1: ruleRichStringLiteralEnd returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) ) ;
    public final EObject ruleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:960:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:961:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:961:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:961:2: () ( (lv_value_1_0= RULE_RICH_TEXT_END ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:961:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:962:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralEndAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:967:2: ( (lv_value_1_0= RULE_RICH_TEXT_END ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:968:1: (lv_value_1_0= RULE_RICH_TEXT_END )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:968:1: (lv_value_1_0= RULE_RICH_TEXT_END )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:969:3: lv_value_1_0= RULE_RICH_TEXT_END
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_END,FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd1937); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRichStringLiteralEndAccess().getValueRICH_TEXT_ENDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRichStringLiteralEndRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"RICH_TEXT_END");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringLiteralEnd"


    // $ANTLR start "entryRuleInternalRichString"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:993:1: entryRuleInternalRichString returns [EObject current=null] : iv_ruleInternalRichString= ruleInternalRichString EOF ;
    public final EObject entryRuleInternalRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalRichString = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:2: (iv_ruleInternalRichString= ruleInternalRichString EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:2: iv_ruleInternalRichString= ruleInternalRichString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalRichStringRule()); 
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString1978);
            iv_ruleInternalRichString=ruleInternalRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalRichString1988); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInternalRichString"


    // $ANTLR start "ruleInternalRichString"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1002:1: ruleInternalRichString returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) ) ) ;
    public final EObject ruleInternalRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1005:28: ( ( () ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1006:1: ( () ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1006:1: ( () ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1006:2: () ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1006:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1007:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInternalRichStringAccess().getRichStringAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1012:2: ( ( (lv_elements_1_0= ruleInternalRichStringLiteral ) ) | ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_RICH_TEXT_INBETWEEN) ) {
                int LA21_1 = input.LA(2);

                if ( ((LA21_1>=RULE_ID && LA21_1<=RULE_RICH_TEXT_START)||LA21_1==RULE_INT||LA21_1==21||LA21_1==26||LA21_1==28||LA21_1==31||LA21_1==34||(LA21_1>=49 && LA21_1<=50)||LA21_1==54||LA21_1==58||LA21_1==61||LA21_1==63||(LA21_1>=66 && LA21_1<=68)||(LA21_1>=71 && LA21_1<=77)) ) {
                    alt21=2;
                }
                else if ( (LA21_1==EOF||LA21_1==33||(LA21_1>=35 && LA21_1<=37)) ) {
                    alt21=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1012:3: ( (lv_elements_1_0= ruleInternalRichStringLiteral ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1012:3: ( (lv_elements_1_0= ruleInternalRichStringLiteral ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1013:1: (lv_elements_1_0= ruleInternalRichStringLiteral )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1013:1: (lv_elements_1_0= ruleInternalRichStringLiteral )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1014:3: lv_elements_1_0= ruleInternalRichStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsInternalRichStringLiteralParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInternalRichStringLiteral_in_ruleInternalRichString2044);
                    lv_elements_1_0=ruleInternalRichStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_1_0, 
                              		"InternalRichStringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1031:6: ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1031:6: ( ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+ )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1031:7: ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1031:7: ( (lv_elements_2_0= ruleRichStringLiteralInbetween ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1032:1: (lv_elements_2_0= ruleRichStringLiteralInbetween )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1032:1: (lv_elements_2_0= ruleRichStringLiteralInbetween )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1033:3: lv_elements_2_0= ruleRichStringLiteralInbetween
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString2072);
                    lv_elements_2_0=ruleRichStringLiteralInbetween();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_2_0, 
                              		"RichStringLiteralInbetween");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1049:2: ( ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_RICH_TEXT_START)||LA20_0==RULE_INT||LA20_0==21||LA20_0==26||LA20_0==28||LA20_0==31||LA20_0==34||(LA20_0>=49 && LA20_0<=50)||LA20_0==54||LA20_0==58||LA20_0==61||LA20_0==63||(LA20_0>=66 && LA20_0<=68)||(LA20_0>=71 && LA20_0<=77)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1049:3: ( (lv_elements_3_0= ruleRichStringPart ) ) ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1049:3: ( (lv_elements_3_0= ruleRichStringPart ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1050:1: (lv_elements_3_0= ruleRichStringPart )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1050:1: (lv_elements_3_0= ruleRichStringPart )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1051:3: lv_elements_3_0= ruleRichStringPart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringPartParserRuleCall_1_1_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringPart_in_ruleInternalRichString2094);
                    	    lv_elements_3_0=ruleRichStringPart();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_3_0, 
                    	              		"RichStringPart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1067:2: ( (lv_elements_4_0= ruleRichStringLiteralInbetween ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1068:1: (lv_elements_4_0= ruleRichStringLiteralInbetween )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1068:1: (lv_elements_4_0= ruleRichStringLiteralInbetween )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1069:3: lv_elements_4_0= ruleRichStringLiteralInbetween
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString2115);
                    	    lv_elements_4_0=ruleRichStringLiteralInbetween();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_4_0, 
                    	              		"RichStringLiteralInbetween");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleInternalRichString"


    // $ANTLR start "entryRuleInternalRichStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1093:1: entryRuleInternalRichStringLiteral returns [EObject current=null] : iv_ruleInternalRichStringLiteral= ruleInternalRichStringLiteral EOF ;
    public final EObject entryRuleInternalRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1094:2: (iv_ruleInternalRichStringLiteral= ruleInternalRichStringLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1095:2: iv_ruleInternalRichStringLiteral= ruleInternalRichStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalRichStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleInternalRichStringLiteral_in_entryRuleInternalRichStringLiteral2155);
            iv_ruleInternalRichStringLiteral=ruleInternalRichStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalRichStringLiteral2165); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInternalRichStringLiteral"


    // $ANTLR start "ruleInternalRichStringLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:1: ruleInternalRichStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) ;
    public final EObject ruleInternalRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1105:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1106:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1106:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1106:2: () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1106:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1107:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInternalRichStringLiteralAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1112:2: ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1113:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1113:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1114:3: lv_value_1_0= RULE_RICH_TEXT_INBETWEEN
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_INBETWEEN,FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleInternalRichStringLiteral2216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getInternalRichStringLiteralAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getInternalRichStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"RICH_TEXT_INBETWEEN");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleInternalRichStringLiteral"


    // $ANTLR start "entryRuleRichStringPart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1138:1: entryRuleRichStringPart returns [EObject current=null] : iv_ruleRichStringPart= ruleRichStringPart EOF ;
    public final EObject entryRuleRichStringPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringPart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1139:2: (iv_ruleRichStringPart= ruleRichStringPart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1140:2: iv_ruleRichStringPart= ruleRichStringPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringPartRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart2257);
            iv_ruleRichStringPart=ruleRichStringPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringPart2267); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringPart"


    // $ANTLR start "ruleRichStringPart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1147:1: ruleRichStringPart returns [EObject current=null] : (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf ) ;
    public final EObject ruleRichStringPart() throws RecognitionException {
        EObject current = null;

        EObject this_XExpression_0 = null;

        EObject this_RichStringForLoop_1 = null;

        EObject this_RichStringIf_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1150:28: ( (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1151:1: (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1151:1: (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
            case RULE_INT:
            case 21:
            case 26:
            case 28:
            case 49:
            case 50:
            case 54:
            case 58:
            case 61:
            case 63:
            case 66:
            case 67:
            case 68:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                {
                alt22=1;
                }
                break;
            case 31:
                {
                alt22=2;
                }
                break;
            case 34:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1152:5: this_XExpression_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getXExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringPart2314);
                    this_XExpression_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1162:5: this_RichStringForLoop_1= ruleRichStringForLoop
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringForLoopParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart2341);
                    this_RichStringForLoop_1=ruleRichStringForLoop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RichStringForLoop_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1172:5: this_RichStringIf_2= ruleRichStringIf
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringIfParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichStringIf_in_ruleRichStringPart2368);
                    this_RichStringIf_2=ruleRichStringIf();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RichStringIf_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringPart"


    // $ANTLR start "entryRuleRichStringForLoop"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1188:1: entryRuleRichStringForLoop returns [EObject current=null] : iv_ruleRichStringForLoop= ruleRichStringForLoop EOF ;
    public final EObject entryRuleRichStringForLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringForLoop = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1189:2: (iv_ruleRichStringForLoop= ruleRichStringForLoop EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1190:2: iv_ruleRichStringForLoop= ruleRichStringForLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringForLoopRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop2403);
            iv_ruleRichStringForLoop=ruleRichStringForLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringForLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringForLoop2413); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringForLoop"


    // $ANTLR start "ruleRichStringForLoop"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1197:1: ruleRichStringForLoop returns [EObject current=null] : ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' ) ;
    public final EObject ruleRichStringForLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_forExpression_4_0 = null;

        EObject lv_eachExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1200:28: ( ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1201:1: ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1201:1: ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1201:2: () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1201:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1202:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringForLoopAccess().getRichStringForLoopAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleRichStringForLoop2459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRichStringForLoopAccess().getFORKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1211:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1212:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1212:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1213:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop2480);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleRichStringForLoop2492); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRichStringForLoopAccess().getColonKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1233:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1234:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1234:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1235:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getForExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringForLoop2513);
            lv_forExpression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1251:2: ( (lv_eachExpression_5_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1252:1: (lv_eachExpression_5_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1252:1: (lv_eachExpression_5_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1253:3: lv_eachExpression_5_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getEachExpressionInternalRichStringParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop2534);
            lv_eachExpression_5_0=ruleInternalRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringForLoopRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_5_0, 
                      		"InternalRichString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleRichStringForLoop2546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRichStringForLoopAccess().getENDFORKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringForLoop"


    // $ANTLR start "entryRuleRichStringIf"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1281:1: entryRuleRichStringIf returns [EObject current=null] : iv_ruleRichStringIf= ruleRichStringIf EOF ;
    public final EObject entryRuleRichStringIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringIf = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1282:2: (iv_ruleRichStringIf= ruleRichStringIf EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1283:2: iv_ruleRichStringIf= ruleRichStringIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringIfRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf2582);
            iv_ruleRichStringIf=ruleRichStringIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringIf2592); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringIf"


    // $ANTLR start "ruleRichStringIf"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1290:1: ruleRichStringIf returns [EObject current=null] : ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' ) ;
    public final EObject ruleRichStringIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_3_0 = null;

        EObject lv_elseIfs_4_0 = null;

        EObject lv_else_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1293:28: ( ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:1: ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:1: ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:2: () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1295:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringIfAccess().getRichStringIfAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleRichStringIf2638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRichStringIfAccess().getIFKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1304:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1305:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1305:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1306:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringIfAccess().getIfXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringIf2659);
            lv_if_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringIfRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1322:2: ( (lv_then_3_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1323:1: (lv_then_3_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1323:1: (lv_then_3_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1324:3: lv_then_3_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringIfAccess().getThenInternalRichStringParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringIf2680);
            lv_then_3_0=ruleInternalRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringIfRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_3_0, 
                      		"InternalRichString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1340:2: ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==37) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:1: (lv_elseIfs_4_0= ruleRichStringElseIf )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:1: (lv_elseIfs_4_0= ruleRichStringElseIf )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1342:3: lv_elseIfs_4_0= ruleRichStringElseIf
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRichStringIfAccess().getElseIfsRichStringElseIfParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf2701);
            	    lv_elseIfs_4_0=ruleRichStringElseIf();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRichStringIfRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elseIfs",
            	              		lv_elseIfs_4_0, 
            	              		"RichStringElseIf");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1358:3: (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1358:5: otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) )
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleRichStringIf2715); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRichStringIfAccess().getELSEKeyword_5_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1362:1: ( (lv_else_6_0= ruleInternalRichString ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1363:1: (lv_else_6_0= ruleInternalRichString )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1363:1: (lv_else_6_0= ruleInternalRichString )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1364:3: lv_else_6_0= ruleInternalRichString
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringIfAccess().getElseInternalRichStringParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringIf2736);
                    lv_else_6_0=ruleInternalRichString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringIfRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_6_0, 
                              		"InternalRichString");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,36,FOLLOW_36_in_ruleRichStringIf2750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getRichStringIfAccess().getENDIFKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringIf"


    // $ANTLR start "entryRuleRichStringElseIf"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1392:1: entryRuleRichStringElseIf returns [EObject current=null] : iv_ruleRichStringElseIf= ruleRichStringElseIf EOF ;
    public final EObject entryRuleRichStringElseIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringElseIf = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1393:2: (iv_ruleRichStringElseIf= ruleRichStringElseIf EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1394:2: iv_ruleRichStringElseIf= ruleRichStringElseIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringElseIfRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf2786);
            iv_ruleRichStringElseIf=ruleRichStringElseIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringElseIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringElseIf2796); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRichStringElseIf"


    // $ANTLR start "ruleRichStringElseIf"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1401:1: ruleRichStringElseIf returns [EObject current=null] : (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) ) ;
    public final EObject ruleRichStringElseIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_if_1_0 = null;

        EObject lv_then_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:28: ( (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1405:1: (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1405:1: (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1405:3: otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleRichStringElseIf2833); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRichStringElseIfAccess().getELSEIFKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1409:1: ( (lv_if_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1410:1: (lv_if_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1410:1: (lv_if_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1411:3: lv_if_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringElseIf2854);
            lv_if_1_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringElseIfRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_1_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1427:2: ( (lv_then_2_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1428:1: (lv_then_2_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1428:1: (lv_then_2_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1429:3: lv_then_2_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf2875);
            lv_then_2_0=ruleInternalRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRichStringElseIfRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_2_0, 
                      		"InternalRichString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleRichStringElseIf"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1453:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1454:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1455:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression2911);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression2921); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1462:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1465:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1467:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression2967);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1483:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1484:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1485:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment3001);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment3011); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1492:1: ruleXAssignment returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1495:28: ( ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:1: ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:1: ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==EOF||(LA26_1>=RULE_ID && LA26_1<=RULE_INT)||(LA26_1>=18 && LA26_1<=19)||(LA26_1>=21 && LA26_1<=23)||(LA26_1>=26 && LA26_1<=30)||LA26_1==32||(LA26_1>=39 && LA26_1<=58)||(LA26_1>=60 && LA26_1<=80)) ) {
                    alt26=2;
                }
                else if ( (LA26_1==38) ) {
                    alt26=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_RICH_TEXT_START)||LA26_0==RULE_INT||LA26_0==21||LA26_0==26||LA26_0==28||(LA26_0>=49 && LA26_0<=50)||LA26_0==54||LA26_0==58||LA26_0==61||LA26_0==63||(LA26_0>=66 && LA26_0<=68)||(LA26_0>=71 && LA26_0<=77)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:2: ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:2: ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:3: () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1496:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1497:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1502:2: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1503:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1503:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1504:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXAssignment3066); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment3082);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1523:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1524:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1524:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1525:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment3102);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1542:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1542:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1543:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment3132);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==39) ) {
                        int LA25_1 = input.LA(2);

                        if ( (synpred1_InternalXtend2()) ) {
                            alt25=1;
                        }
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1556:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1556:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1556:7: ()
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1557:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1562:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1563:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1563:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1564:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment3185);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1577:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1578:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1578:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment3208);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"XAssignment");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1603:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1604:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1605:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign3248);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign3259); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1612:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1615:28: (kw= '=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1617:2: kw= '='
            {
            kw=(Token)match(input,38,FOLLOW_38_in_ruleOpSingleAssign3296); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1630:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1631:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1632:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign3336);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign3347); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1639:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1642:28: (kw= '+=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1644:2: kw= '+='
            {
            kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMultiAssign3384); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1657:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1658:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1659:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3423);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression3433); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1666:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1669:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1670:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1670:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1671:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3480);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==40) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred2_InternalXtend2()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1690:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1691:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1691:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1692:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression3533);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1705:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1706:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1706:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1707:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3556);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1731:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1732:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1733:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3595);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3606); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1740:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1743:28: (kw= '||' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1745:2: kw= '||'
            {
            kw=(Token)match(input,40,FOLLOW_40_in_ruleOpOr3643); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1758:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1759:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1760:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3682);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression3692); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1767:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1770:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1771:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1771:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1772:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3739);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==41) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred3_InternalXtend2()) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1785:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1785:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1785:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1786:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1791:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1792:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1792:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1793:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression3792);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1806:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1807:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1807:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1808:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3815);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1832:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1833:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1834:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3854);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3865); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1841:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1844:28: (kw= '&&' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1846:2: kw= '&&'
            {
            kw=(Token)match(input,41,FOLLOW_41_in_ruleOpAnd3902); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1859:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1860:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1861:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3941);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression3951); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1868:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1871:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1872:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1872:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1873:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3998);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==42) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred4_InternalXtend2()) ) {
                        alt29=1;
                    }


                }
                else if ( (LA29_0==43) ) {
                    int LA29_3 = input.LA(2);

                    if ( (synpred4_InternalXtend2()) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1886:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1886:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1886:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1887:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1892:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1893:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1893:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1894:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression4051);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1907:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1908:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1908:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1909:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression4074);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XRelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1933:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1934:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1935:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality4113);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality4124); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1942:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1945:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1946:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1946:1: (kw= '==' | kw= '!=' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==42) ) {
                alt30=1;
            }
            else if ( (LA30_0==43) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1947:2: kw= '=='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpEquality4162); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1954:2: kw= '!='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpEquality4181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1967:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1968:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1969:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4221);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression4231); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1976:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1979:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1980:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1980:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1981:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4278);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop31:
            do {
                int alt31=3;
                switch ( input.LA(1) ) {
                case 21:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 44:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (synpred5_InternalXtend2()) ) {
                        alt31=1;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA31_5 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA31_6 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt31=2;
                    }


                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1991:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1991:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1991:6: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1992:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXRelationalExpression4314); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2001:3: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2002:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2002:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2003:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4339);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2022:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2022:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2022:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2023:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2028:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2029:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2029:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2030:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4400);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2043:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2044:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2044:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2045:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4423);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2069:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2070:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2071:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4463);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4474); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2078:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2081:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2082:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2082:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt32=1;
                }
                break;
            case 46:
                {
                alt32=2;
                }
                break;
            case 23:
                {
                alt32=3;
                }
                break;
            case 21:
                {
                alt32=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2083:2: kw= '>='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpCompare4512); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2090:2: kw= '<='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpCompare4531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2097:2: kw= '>'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpCompare4550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:2: kw= '<'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleOpCompare4569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2117:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2118:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2119:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4609);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4619); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2126:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2129:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2130:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2130:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2131:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4666);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==47) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred7_InternalXtend2()) ) {
                        alt33=1;
                    }


                }
                else if ( (LA33_0==48) ) {
                    int LA33_3 = input.LA(2);

                    if ( (synpred7_InternalXtend2()) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2144:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2144:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2144:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2145:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2150:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2151:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2151:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4719);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2165:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2166:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2166:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2167:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4742);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2191:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2192:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2193:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther4781);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther4792); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2200:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2203:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2204:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2204:1: (kw= '->' | kw= '..' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            else if ( (LA34_0==48) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2205:2: kw= '->'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther4830); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2212:2: kw= '..'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther4849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2225:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2226:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2227:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4889);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression4899); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2234:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2237:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2238:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2238:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2239:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4946);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==49) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred8_InternalXtend2()) ) {
                        alt35=1;
                    }


                }
                else if ( (LA35_0==50) ) {
                    int LA35_3 = input.LA(2);

                    if ( (synpred8_InternalXtend2()) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2252:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2252:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2252:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2253:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2258:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2259:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2259:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2260:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4999);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2273:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2274:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2274:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2275:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression5022);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2299:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2300:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2301:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd5061);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd5072); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2308:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2311:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2312:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2312:1: (kw= '+' | kw= '-' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==49) ) {
                alt36=1;
            }
            else if ( (LA36_0==50) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2313:2: kw= '+'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpAdd5110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2320:2: kw= '-'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpAdd5129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2333:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2334:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2335:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression5169);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression5179); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2342:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2345:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2346:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2346:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2347:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5226);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop37:
            do {
                int alt37=2;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    int LA37_2 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt37=1;
                    }


                    }
                    break;
                case 51:
                    {
                    int LA37_3 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt37=1;
                    }


                    }
                    break;
                case 52:
                    {
                    int LA37_4 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt37=1;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA37_5 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt37=1;
                    }


                    }
                    break;

                }

                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2360:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2360:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2360:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2361:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2366:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2367:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2367:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5279);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2381:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2382:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2382:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2383:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5302);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2407:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2408:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2409:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti5341);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti5352); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2416:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2419:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2420:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2420:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt38=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt38=1;
                }
                break;
            case 51:
                {
                alt38=2;
                }
                break;
            case 52:
                {
                alt38=3;
                }
                break;
            case 53:
                {
                alt38=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2421:2: kw= '*'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleOpMulti5390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2428:2: kw= '**'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpMulti5409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2435:2: kw= '/'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpMulti5428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2442:2: kw= '%'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpMulti5447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2455:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2456:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2457:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5487);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation5497); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2464:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2467:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=49 && LA39_0<=50)||LA39_0==54) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_RICH_TEXT_START)||LA39_0==RULE_INT||LA39_0==21||LA39_0==26||LA39_0==28||LA39_0==58||LA39_0==61||LA39_0==63||(LA39_0>=66 && LA39_0<=68)||(LA39_0>=71 && LA39_0<=77)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2469:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2474:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2475:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2475:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2476:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5555);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2489:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2491:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5576);
                    lv_operand_2_0=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"XCastedExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2509:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5605);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2525:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2526:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2527:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5641);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5652); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2534:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2537:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2538:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2538:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt40=1;
                }
                break;
            case 50:
                {
                alt40=2;
                }
                break;
            case 49:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2539:2: kw= '!'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpUnary5690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2546:2: kw= '-'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpUnary5709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2553:2: kw= '+'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpUnary5728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2566:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2567:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2568:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5768);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression5778); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2575:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2578:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2579:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2579:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2580:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression5825);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==55) ) {
                    int LA41_2 = input.LA(2);

                    if ( (synpred10_InternalXtend2()) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2590:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2590:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2590:6: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2591:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleXCastedExpression5860); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2600:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2601:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2601:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2602:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5883);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2626:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2627:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2628:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5921);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall5931); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2635:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_16_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_typeArguments_11_0 = null;

        EObject lv_typeArguments_13_0 = null;

        EObject lv_memberCallArguments_17_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2638:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2639:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2639:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2640:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5978);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:1: ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            loop48:
            do {
                int alt48=3;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    int LA48_2 = input.LA(2);

                    if ( (synpred11_InternalXtend2()) ) {
                        alt48=1;
                    }
                    else if ( (synpred12_InternalXtend2()) ) {
                        alt48=2;
                    }


                    }
                    break;
                case 56:
                    {
                    int LA48_3 = input.LA(2);

                    if ( (synpred12_InternalXtend2()) ) {
                        alt48=2;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA48_4 = input.LA(2);

                    if ( (synpred12_InternalXtend2()) ) {
                        alt48=2;
                    }


                    }
                    break;

                }

                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:2: ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:2: ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:3: ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:3: ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:4: ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2655:25: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2655:26: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2655:26: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2656:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleXMemberFeatureCall6027); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2665:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2666:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2666:1: (otherlv_3= RULE_ID )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2667:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6047); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall6063);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2686:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2687:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2687:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2688:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall6085);
            	    lv_value_5_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_5_0, 
            	              		"XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2721:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2721:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2721:8: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2722:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2727:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt42=3;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt42=1;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt42=2;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt42=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt42) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2727:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleXMemberFeatureCall6171); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2732:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2732:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2733:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2733:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2734:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,56,FOLLOW_56_in_ruleXMemberFeatureCall6195); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_8_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2748:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2748:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2749:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2749:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,57,FOLLOW_57_in_ruleXMemberFeatureCall6232); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_spreading_9_0, grammarAccess.getXMemberFeatureCallAccess().getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "spreading", true, "*.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2763:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==21) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2763:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall6261); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2767:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2769:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6282);
            	            lv_typeArguments_11_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_11_0, 
            	                      		"JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2785:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop43:
            	            do {
            	                int alt43=2;
            	                int LA43_0 = input.LA(1);

            	                if ( (LA43_0==22) ) {
            	                    alt43=1;
            	                }


            	                switch (alt43) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2785:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall6295); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2789:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2790:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2790:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2791:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6316);
            	            	    lv_typeArguments_13_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_13_0, 
            	            	              		"JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop43;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,23,FOLLOW_23_in_ruleXMemberFeatureCall6330); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2811:3: ( (otherlv_15= RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2812:1: (otherlv_15= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2812:1: (otherlv_15= RULE_ID )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2813:3: otherlv_15= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6352); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2824:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt47=2;
            	    alt47 = dfa47.predict(input);
            	    switch (alt47) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2824:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2824:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2824:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2831:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2832:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,28,FOLLOW_28_in_ruleXMemberFeatureCall6386); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_16_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2845:2: ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt46=3;
            	            alt46 = dfa46.predict(input);
            	            switch (alt46) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2845:3: ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2845:3: ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2845:4: ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2850:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2851:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall6431);
            	                    lv_memberCallArguments_17_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_17_0, 
            	                              		"XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2868:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2868:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2868:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2868:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2869:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2869:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2870:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6459);
            	                    lv_memberCallArguments_18_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2886:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop45:
            	                    do {
            	                        int alt45=2;
            	                        int LA45_0 = input.LA(1);

            	                        if ( (LA45_0==22) ) {
            	                            alt45=1;
            	                        }


            	                        switch (alt45) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2886:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall6472); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2890:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2891:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2891:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2892:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6493);
            	                    	    lv_memberCallArguments_20_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_20_0, 
            	                    	              		"XExpression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop45;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall6510); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2920:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2921:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2922:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression6551);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression6561); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2929:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XFeatureCall_3 = null;

        EObject this_XLiteral_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XThrowExpression_9 = null;

        EObject this_XTryCatchFinallyExpression_10 = null;

        EObject this_XParenthesizedExpression_11 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2932:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2933:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2933:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression )
            int alt49=12;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt49=1;
                }
                break;
            case 26:
                {
                alt49=2;
                }
                break;
            case 63:
                {
                alt49=3;
                }
                break;
            case RULE_ID:
            case 21:
                {
                alt49=4;
                }
                break;
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
            case RULE_INT:
            case 58:
            case 72:
            case 73:
            case 74:
            case 75:
                {
                alt49=5;
                }
                break;
            case 61:
                {
                alt49=6;
                }
                break;
            case 66:
                {
                alt49=7;
                }
                break;
            case 67:
                {
                alt49=8;
                }
                break;
            case 68:
                {
                alt49=9;
                }
                break;
            case 76:
                {
                alt49=10;
                }
                break;
            case 77:
                {
                alt49=11;
                }
                break;
            case 28:
                {
                alt49=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2934:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression6608);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2944:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression6635);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2954:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression6662);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2964:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression6689);
                    this_XFeatureCall_3=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2974:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression6716);
                    this_XLiteral_4=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2984:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression6743);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2994:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression6770);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3004:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression6797);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3014:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression6824);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3024:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression6851);
                    this_XThrowExpression_9=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3034:5: this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression6878);
                    this_XTryCatchFinallyExpression_10=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3044:5: this_XParenthesizedExpression_11= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression6905);
                    this_XParenthesizedExpression_11=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3060:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3061:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3062:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral6940);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral6950); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3069:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3072:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3073:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3073:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt50=6;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt50=1;
                }
                break;
            case 72:
            case 73:
                {
                alt50=2;
                }
                break;
            case RULE_INT:
                {
                alt50=3;
                }
                break;
            case 74:
                {
                alt50=4;
                }
                break;
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
                {
                alt50=5;
                }
                break;
            case 75:
                {
                alt50=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3074:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral6997);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3084:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral7024);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3094:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral7051);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3104:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral7078);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3114:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral7105);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3124:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral7132);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3140:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3141:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3142:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure7167);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure7177); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3149:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_formalParameters_2_0 = null;

        EObject lv_formalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3152:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3153:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3153:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3153:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3153:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3154:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXClosure7223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3163:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID||LA52_0==28||LA52_0==80) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3163:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3163:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3164:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3164:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3165:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7245);
                    lv_formalParameters_2_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_2_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3181:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==22) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3181:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleXClosure7258); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3185:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3186:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3186:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3187:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7279);
                    	    lv_formalParameters_4_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_4_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,59,FOLLOW_59_in_ruleXClosure7295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3207:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3208:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3208:1: (lv_expression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3209:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure7316);
            lv_expression_6_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,60,FOLLOW_60_in_ruleXClosure7328); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3237:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3238:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3239:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure7364);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure7374); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3246:1: ruleXShortClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3249:28: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3250:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3250:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3250:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3250:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3251:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3256:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID||LA54_0==28||LA54_0==80) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3256:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3256:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3257:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3257:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3258:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7430);
                    lv_formalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3274:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==22) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3274:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXShortClosure7443); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3278:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3279:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3279:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3280:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7464);
                    	    lv_formalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,59,FOLLOW_59_in_ruleXShortClosure7480); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3300:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3301:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3301:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3302:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure7501);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3326:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3327:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3328:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression7537);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression7547); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3335:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3338:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3339:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3339:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3339:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleXParenthesizedExpression7584); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression7606);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleXParenthesizedExpression7617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3364:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3365:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3366:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression7653);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression7663); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3373:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3376:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3377:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3377:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3377:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3377:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3378:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXIfExpression7709); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXIfExpression7721); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3391:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3392:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3392:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3393:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7742);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXIfExpression7754); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3413:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3414:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3414:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3415:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7775);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==62) ) {
                int LA55_1 = input.LA(2);

                if ( (synpred15_InternalXtend2()) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,62,FOLLOW_62_in_ruleXIfExpression7796); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3436:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3437:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3437:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3438:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7818);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3462:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3463:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3464:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression7856);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression7866); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3471:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_localVarName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3474:28: ( ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3475:1: ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3475:1: ( () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3475:2: () otherlv_1= 'switch' ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3475:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3476:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXSwitchExpression7912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3485:1: ( ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==32) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3485:2: ( (lv_localVarName_2_0= RULE_ID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3485:2: ( (lv_localVarName_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3486:1: (lv_localVarName_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3486:1: (lv_localVarName_2_0= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3487:3: lv_localVarName_2_0= RULE_ID
                    {
                    lv_localVarName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXSwitchExpression7930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_localVarName_2_0, grammarAccess.getXSwitchExpressionAccess().getLocalVarNameIDTerminalRuleCall_2_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleXSwitchExpression7947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3507:3: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3508:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3508:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3509:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression7970);
            lv_switch_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"switch",
                      		lv_switch_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleXSwitchExpression7982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3529:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID||LA57_0==28||LA57_0==32||LA57_0==65||LA57_0==80) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3530:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3530:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3531:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression8003);
            	    lv_cases_6_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_6_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3547:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3547:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,64,FOLLOW_64_in_ruleXSwitchExpression8017); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,32,FOLLOW_32_in_ruleXSwitchExpression8029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3555:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3556:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3556:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3557:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression8050);
                    lv_default_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_9_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleXSwitchExpression8064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3585:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3586:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3587:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart8100);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart8110); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3594:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3597:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3598:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3598:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3598:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3598:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID||LA59_0==28||LA59_0==80) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3599:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3599:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3600:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart8156);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3616:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==65) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3616:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXCasePart8170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3620:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3621:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3621:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3622:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart8191);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleXCasePart8205); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3642:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3643:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3643:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3644:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart8226);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3668:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3669:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3670:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression8262);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression8272); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3677:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3680:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3681:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3681:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3681:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3681:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3682:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXForLoopExpression8318); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXForLoopExpression8330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3695:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3696:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3696:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3697:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression8351);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleXForLoopExpression8363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3717:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3718:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3718:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3719:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression8384);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXForLoopExpression8396); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3740:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3740:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3741:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression8417);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3765:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3766:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3767:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression8453);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression8463); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3774:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3777:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3778:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3778:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3778:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3778:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3779:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXWhileExpression8509); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXWhileExpression8521); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3792:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3793:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3793:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3794:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression8542);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXWhileExpression8554); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3814:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3815:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3815:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3816:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression8575);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3840:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3841:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3842:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression8611);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression8621); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3849:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3852:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3853:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3853:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3853:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3853:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3854:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXDoWhileExpression8667); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3863:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3864:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3864:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3865:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8688);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,67,FOLLOW_67_in_ruleXDoWhileExpression8700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleXDoWhileExpression8712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3889:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3890:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3890:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3891:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8733);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXDoWhileExpression8745); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3919:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3920:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3921:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression8781);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression8791); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3928:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3931:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3932:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3932:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3932:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3932:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleXBlockExpression8837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=RULE_ID && LA62_0<=RULE_RICH_TEXT_START)||LA62_0==RULE_INT||LA62_0==21||LA62_0==26||LA62_0==28||(LA62_0>=49 && LA62_0<=50)||LA62_0==54||LA62_0==58||LA62_0==61||LA62_0==63||(LA62_0>=66 && LA62_0<=77)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3943:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3943:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3944:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression8859);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3960:2: (otherlv_3= ';' )?
            	    int alt61=2;
            	    int LA61_0 = input.LA(1);

            	    if ( (LA61_0==30) ) {
            	        alt61=1;
            	    }
            	    switch (alt61) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3960:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleXBlockExpression8872); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleXBlockExpression8888); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3976:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3977:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3978:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock8924);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock8934); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3985:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3988:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3989:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3989:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=69 && LA63_0<=70)) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_RICH_TEXT_START)||LA63_0==RULE_INT||LA63_0==21||LA63_0==26||LA63_0==28||(LA63_0>=49 && LA63_0<=50)||LA63_0==54||LA63_0==58||LA63_0==61||LA63_0==63||(LA63_0>=66 && LA63_0<=68)||(LA63_0>=71 && LA63_0<=77)) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3990:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock8981);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4000:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock9008);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4016:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4017:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4018:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration9043);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration9053); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4025:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4028:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4029:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4029:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4029:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4029:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4030:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4035:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==69) ) {
                alt64=1;
            }
            else if ( (LA64_0==70) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4035:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4035:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4036:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4036:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4037:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,69,FOLLOW_69_in_ruleXVariableDeclaration9106); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4051:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleXVariableDeclaration9137); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred16_InternalXtend2()) ) {
                    alt65=1;
                }
                else if ( (true) ) {
                    alt65=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA65_0==28) && (synpred16_InternalXtend2())) {
                alt65=1;
            }
            else if ( (LA65_0==80) && (synpred16_InternalXtend2())) {
                alt65=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4064:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4064:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4064:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4065:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4065:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4066:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration9186);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4082:2: ( (lv_name_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4083:1: (lv_name_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4083:1: (lv_name_4_0= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4084:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration9203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getXVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4101:6: ( (lv_name_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4101:6: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4102:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4102:1: (lv_name_5_0= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4103:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration9233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_5_0, grammarAccess.getXVariableDeclarationAccess().getNameIDTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4119:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==38) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4119:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleXVariableDeclaration9252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4123:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4124:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4124:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4125:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration9273);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4149:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4150:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4151:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter9311);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter9321); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4158:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4161:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4162:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4162:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4162:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4162:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==RULE_ID||LA67_1==18||LA67_1==21) ) {
                    alt67=1;
                }
            }
            else if ( (LA67_0==28||LA67_0==80) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4163:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4163:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter9367);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4180:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4181:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4181:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4182:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter9385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getJvmFormalParameterAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4206:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4207:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4208:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall9426);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall9436); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4215:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_featureCallArguments_8_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4218:28: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4219:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4219:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4219:2: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4219:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4220:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4225:2: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==21) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4225:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall9483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4229:1: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4230:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4230:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4231:3: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9504);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4247:2: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==22) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4247:4: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleXFeatureCall9517); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4251:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4252:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4252:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4253:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9538);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleXFeatureCall9552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4273:3: ( (otherlv_6= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4274:1: (otherlv_6= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4274:1: (otherlv_6= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4275:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall9574); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0()); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4286:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4286:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4286:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4286:4: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4293:1: (lv_explicitOperationCall_7_0= '(' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4294:3: lv_explicitOperationCall_7_0= '('
                    {
                    lv_explicitOperationCall_7_0=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall9608); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4307:2: ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt71=3;
                    alt71 = dfa71.predict(input);
                    switch (alt71) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4307:3: ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4307:3: ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4307:4: ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4312:1: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4313:3: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall9653);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_8_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4330:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4330:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4330:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4330:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4331:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4331:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4332:3: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall9681);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4348:2: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop70:
                            do {
                                int alt70=2;
                                int LA70_0 = input.LA(1);

                                if ( (LA70_0==22) ) {
                                    alt70=1;
                                }


                                switch (alt70) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4348:4: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleXFeatureCall9694); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4352:1: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4353:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4353:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4354:3: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall9715);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_11_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop70;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall9732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4382:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4383:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4384:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9770);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall9780); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4391:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4394:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4395:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4395:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4395:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4395:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4396:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleXConstructorCall9826); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4405:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4406:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4406:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4407:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9849);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4420:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==21) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4420:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall9862); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4424:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4425:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4425:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4426:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9883);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4442:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==22) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4442:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleXConstructorCall9896); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4446:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4447:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4447:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4448:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9917);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleXConstructorCall9931); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleXConstructorCall9945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:1: ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt76=3;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:2: ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:2: ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:3: ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4477:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4478:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9977);
                    lv_arguments_9_0=ruleXShortClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_9_0, 
                              		"XShortClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4495:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4495:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4495:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4495:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4496:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4496:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4497:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall10005);
                    lv_arguments_10_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_10_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4513:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==22) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4513:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleXConstructorCall10018); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4517:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4518:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4518:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4519:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall10039);
                    	    lv_arguments_12_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_12_0, 
                    	              		"XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall10056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4547:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4548:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4549:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral10092);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral10102); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4556:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4559:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4560:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4560:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4560:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4560:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4561:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4566:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==72) ) {
                alt77=1;
            }
            else if ( (LA77_0==73) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4566:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXBooleanLiteral10149); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4571:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4571:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4572:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4572:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4573:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,73,FOLLOW_73_in_ruleXBooleanLiteral10173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4594:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4595:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4596:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral10223);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral10233); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4603:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4606:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4607:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4607:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4607:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4607:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4608:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleXNullLiteral10279); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4625:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4626:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4627:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral10315);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral10325); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4634:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4637:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4638:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4638:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4638:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4638:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4639:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4644:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4645:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4645:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4646:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral10376); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4670:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4671:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4672:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral10417);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral10427); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4679:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4682:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4683:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4683:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4683:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4683:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4684:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleXTypeLiteral10473); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXTypeLiteral10485); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4697:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4698:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4698:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4699:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral10508);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXTypeLiteral10520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4724:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4725:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4726:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10556);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression10566); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4733:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4736:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4737:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4737:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4737:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4737:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4738:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleXThrowExpression10612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4747:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4748:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4748:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4749:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression10633);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4773:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4774:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4775:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10669);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10679); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4782:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4785:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4786:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4786:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4786:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4786:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4787:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,77,FOLLOW_77_in_ruleXTryCatchFinallyExpression10725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4796:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4797:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4797:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4798:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10746);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:2: ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==79) ) {
                alt80=1;
            }
            else if ( (LA80_0==78) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:3: ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:3: ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:4: ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:4: ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==79) ) {
                            int LA78_2 = input.LA(2);

                            if ( (synpred20_InternalXtend2()) ) {
                                alt78=1;
                            }


                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:5: ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4819:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4820:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10779);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt78 >= 1 ) break loop78;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
                    } while (true);

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==78) ) {
                        int LA79_1 = input.LA(2);

                        if ( (synpred21_InternalXtend2()) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,78,FOLLOW_78_in_ruleXTryCatchFinallyExpression10801); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4841:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4842:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4842:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4843:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10823);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4860:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4860:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4860:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,78,FOLLOW_78_in_ruleXTryCatchFinallyExpression10845); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4864:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4865:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4865:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4866:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10866);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4890:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4891:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4892:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10904);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10914); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4899:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4902:28: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4903:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4903:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4903:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,79,FOLLOW_79_in_ruleXCatchClause10951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleXCatchClause10963); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4911:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4912:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4912:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4913:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10984);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleXCatchClause10996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4934:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4934:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4935:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause11017);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4959:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4960:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4961:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName11054);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName11065); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4968:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4971:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4972:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4972:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4972:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName11105); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4979:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==18) ) {
                    int LA81_2 = input.LA(2);

                    if ( (LA81_2==RULE_ID) ) {
                        int LA81_3 = input.LA(3);

                        if ( (synpred22_InternalXtend2()) ) {
                            alt81=1;
                        }


                    }


                }


                switch (alt81) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4979:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4979:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4979:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName11133); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName11149); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5002:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5003:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5004:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference11196);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference11206); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5011:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5014:28: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5015:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5015:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            else if ( (LA82_0==28||LA82_0==80) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5016:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference11253);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5026:5: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11280);
                    this_XFunctionTypeRef_1=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5042:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5043:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5044:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11315);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef11325); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5051:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5054:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5055:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5055:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5055:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5055:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==28) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5055:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleXFunctionTypeRef11363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5059:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5060:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5060:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5061:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11384);
                    lv_paramTypes_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                      	        }
                             		add(
                             			current, 
                             			"paramTypes",
                              		lv_paramTypes_1_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5077:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==22) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5077:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXFunctionTypeRef11397); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5081:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5082:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5082:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5083:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11418);
                    	    lv_paramTypes_3_0=ruleJvmTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"paramTypes",
                    	              		lv_paramTypes_3_0, 
                    	              		"JvmTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXFunctionTypeRef11432); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,80,FOLLOW_80_in_ruleXFunctionTypeRef11446); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5107:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5108:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5108:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5109:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11467);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5133:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5134:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5135:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11503);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11513); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5142:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5145:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5146:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5146:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5146:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5146:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5147:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5147:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5148:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11561);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleJvmParameterizedTypeReference11582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5166:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5167:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5167:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5168:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11604);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5184:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==22) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5184:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleJvmParameterizedTypeReference11617); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5188:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5189:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5189:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5190:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11638);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop85;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleJvmParameterizedTypeReference11652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5218:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5219:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5220:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11690);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11700); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5227:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5230:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5231:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5231:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID||LA87_0==28||LA87_0==80) ) {
                alt87=1;
            }
            else if ( (LA87_0==81) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5232:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11747);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5242:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11774);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5258:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5259:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5260:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11809);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11819); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5267:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5270:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5271:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5271:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5271:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5271:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5272:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,81,FOLLOW_81_in_ruleJvmWildcardTypeReference11865); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5281:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt88=3;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==24) ) {
                alt88=1;
            }
            else if ( (LA88_0==83) ) {
                alt88=2;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5281:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5281:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5282:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5282:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5283:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11887);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5300:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5300:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5301:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5301:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5302:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11914);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5326:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5327:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5328:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11952);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11962); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5335:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5338:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5339:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5339:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5339:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleJvmUpperBound11999); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5343:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5344:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5344:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5345:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound12020);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5369:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5370:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5371:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded12056);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded12066); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5378:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5381:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5382:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5382:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5382:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleJvmUpperBoundAnded12103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5386:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5387:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5387:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5388:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded12124);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5412:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5413:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5414:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound12160);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound12170); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5421:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5424:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5425:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5425:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5425:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleJvmLowerBound12207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5429:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5430:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5430:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5431:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound12228);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmTypeParameter"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5455:1: entryRuleJvmTypeParameter returns [EObject current=null] : iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF ;
    public final EObject entryRuleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5456:2: (iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5457:2: iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter12264);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter12274); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeParameter"


    // $ANTLR start "ruleJvmTypeParameter"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5464:1: ruleJvmTypeParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_constraints_1_0 = null;

        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5467:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5468:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5468:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5468:2: ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5468:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5469:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5469:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5470:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmTypeParameter12316); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getJvmTypeParameterAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmTypeParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5486:2: ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt90=3;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==24) ) {
                alt90=1;
            }
            else if ( (LA90_0==83) ) {
                alt90=2;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5486:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5486:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5486:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5486:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5487:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5487:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5488:3: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter12344);
                    lv_constraints_1_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_1_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5504:2: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==82) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5505:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5505:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5506:3: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter12365);
                    	    lv_constraints_2_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_2_0, 
                    	              		"JvmUpperBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5523:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5523:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5524:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5525:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmLowerBoundParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter12394);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmTypeParameterRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmTypeParameter"

    // $ANTLR start synpred1_InternalXtend2
    public final void synpred1_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1552:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1552:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1553:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1553:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1554:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalXtend23153);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalXtend2

    // $ANTLR start synpred2_InternalXtend2
    public final void synpred2_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1679:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1681:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1681:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1682:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalXtend23501);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalXtend2

    // $ANTLR start synpred3_InternalXtend2
    public final void synpred3_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1780:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1782:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1782:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1783:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalXtend23760);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalXtend2

    // $ANTLR start synpred4_InternalXtend2
    public final void synpred4_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1882:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1882:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1883:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1883:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1884:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalXtend24019);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalXtend2

    // $ANTLR start synpred5_InternalXtend2
    public final void synpred5_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1989:6: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1990:1: 
        {
        }

        match(input,44,FOLLOW_44_in_synpred5_InternalXtend24295); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalXtend2

    // $ANTLR start synpred6_InternalXtend2
    public final void synpred6_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:10: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2018:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2018:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2019:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2019:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2020:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalXtend24368);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalXtend2

    // $ANTLR start synpred7_InternalXtend2
    public final void synpred7_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2140:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2140:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2141:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2141:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2142:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalXtend24687);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalXtend2

    // $ANTLR start synpred8_InternalXtend2
    public final void synpred8_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2248:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2248:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2249:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2249:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2250:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalXtend24967);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalXtend2

    // $ANTLR start synpred9_InternalXtend2
    public final void synpred9_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2356:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2356:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2357:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2357:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2358:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalXtend25247);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalXtend2

    // $ANTLR start synpred10_InternalXtend2
    public final void synpred10_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:4: ( () 'as' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:5: () 'as'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2589:1: 
        {
        }

        match(input,55,FOLLOW_55_in_synpred10_InternalXtend25841); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalXtend2

    // $ANTLR start synpred11_InternalXtend2
    public final void synpred11_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:4: ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:5: ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:5: ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:6: () '.' ( ( RULE_ID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:6: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2649:1: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred11_InternalXtend25995); if (state.failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2650:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2651:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2651:1: ( RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2652:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred11_InternalXtend26003); if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalXtend26010);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalXtend2

    // $ANTLR start synpred12_InternalXtend2
    public final void synpred12_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2705:10: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2706:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2706:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt91=3;
        switch ( input.LA(1) ) {
        case 18:
            {
            alt91=1;
            }
            break;
        case 56:
            {
            alt91=2;
            }
            break;
        case 57:
            {
            alt91=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 91, 0, input);

            throw nvae;
        }

        switch (alt91) {
            case 1 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2706:4: '.'
                {
                match(input,18,FOLLOW_18_in_synpred12_InternalXtend26110); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2708:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2708:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2709:1: ( '?.' )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2709:1: ( '?.' )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2710:2: '?.'
                {
                match(input,56,FOLLOW_56_in_synpred12_InternalXtend26124); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2715:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2715:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2716:1: ( '*.' )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2716:1: ( '*.' )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2717:2: '*.'
                {
                match(input,57,FOLLOW_57_in_synpred12_InternalXtend26144); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalXtend2

    // $ANTLR start synpred13_InternalXtend2
    public final void synpred13_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2824:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2825:1: ( '(' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2825:1: ( '(' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2826:2: '('
        {
        match(input,28,FOLLOW_28_in_synpred13_InternalXtend26368); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalXtend2

    // $ANTLR start synpred14_InternalXtend2
    public final void synpred14_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2845:4: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2846:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2846:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2847:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred14_InternalXtend26414);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalXtend2

    // $ANTLR start synpred15_InternalXtend2
    public final void synpred15_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:4: ( 'else' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3431:6: 'else'
        {
        match(input,62,FOLLOW_62_in_synpred15_InternalXtend27788); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalXtend2

    // $ANTLR start synpred16_InternalXtend2
    public final void synpred16_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:5: ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:5: ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:6: ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4055:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4056:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4056:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4057:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred16_InternalXtend29155);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4059:2: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4060:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4060:1: ( RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4061:1: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred16_InternalXtend29164); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalXtend2

    // $ANTLR start synpred17_InternalXtend2
    public final void synpred17_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4286:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4287:1: ( '(' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4287:1: ( '(' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4288:2: '('
        {
        match(input,28,FOLLOW_28_in_synpred17_InternalXtend29590); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalXtend2

    // $ANTLR start synpred18_InternalXtend2
    public final void synpred18_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4307:4: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4308:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4308:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4309:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred18_InternalXtend29636);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalXtend2

    // $ANTLR start synpred19_InternalXtend2
    public final void synpred19_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:3: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4473:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4473:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4474:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred19_InternalXtend29960);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalXtend2

    // $ANTLR start synpred20_InternalXtend2
    public final void synpred20_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4814:5: ( ( ruleXCatchClause ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4815:1: ( ruleXCatchClause )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4815:1: ( ruleXCatchClause )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4816:1: ruleXCatchClause
        {
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred20_InternalXtend210762);
        ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalXtend2

    // $ANTLR start synpred21_InternalXtend2
    public final void synpred21_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:5: ( 'finally' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4836:7: 'finally'
        {
        match(input,78,FOLLOW_78_in_synpred21_InternalXtend210793); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalXtend2

    // $ANTLR start synpred22_InternalXtend2
    public final void synpred22_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4979:3: ( '.' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4980:2: '.'
        {
        match(input,18,FOLLOW_18_in_synpred22_InternalXtend211124); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalXtend2

    // $ANTLR start synpred23_InternalXtend2
    public final void synpred23_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:4: ( '<' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:6: '<'
        {
        match(input,21,FOLLOW_21_in_synpred23_InternalXtend211574); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalXtend2

    // Delegated rules

    public final boolean synpred5_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalXtend2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalXtend2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA47 dfa47 = new DFA47(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA86 dfa86 = new DFA86(this);
    static final String DFA47_eotS =
        "\76\uffff";
    static final String DFA47_eofS =
        "\1\2\75\uffff";
    static final String DFA47_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA47_maxS =
        "\1\120\1\0\74\uffff";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA47_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA47_transitionS = {
            "\7\2\7\uffff\2\2\1\uffff\3\2\2\uffff\2\2\1\1\2\2\1\uffff\1\2"+
            "\6\uffff\24\2\1\uffff\25\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "2824:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_1 = input.LA(1);

                         
                        int index47_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend2()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index47_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\34\uffff";
    static final String DFA46_eofS =
        "\34\uffff";
    static final String DFA46_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA46_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA46_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA46_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\3\5\2\uffff\1\5\12\uffff\1\5\4\uffff\1\5\1\uffff\1\2\1"+
            "\33\23\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1\5\1\uffff"+
            "\1\5\2\uffff\3\5\2\uffff\7\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "2845:2: ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_0 = input.LA(1);

                         
                        int index46_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_0==RULE_ID) ) {s = 1;}

                        else if ( (LA46_0==28) ) {s = 2;}

                        else if ( (LA46_0==80) && (synpred14_InternalXtend2())) {s = 3;}

                        else if ( (LA46_0==59) && (synpred14_InternalXtend2())) {s = 4;}

                        else if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_RICH_TEXT_START)||LA46_0==RULE_INT||LA46_0==21||LA46_0==26||(LA46_0>=49 && LA46_0<=50)||LA46_0==54||LA46_0==58||LA46_0==61||LA46_0==63||(LA46_0>=66 && LA46_0<=68)||(LA46_0>=71 && LA46_0<=77)) ) {s = 5;}

                        else if ( (LA46_0==29) ) {s = 27;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_2 = input.LA(1);

                         
                        int index46_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index46_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA72_eotS =
        "\76\uffff";
    static final String DFA72_eofS =
        "\1\2\75\uffff";
    static final String DFA72_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA72_maxS =
        "\1\120\1\0\74\uffff";
    static final String DFA72_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA72_transitionS = {
            "\7\2\7\uffff\2\2\1\uffff\3\2\2\uffff\2\2\1\1\2\2\1\uffff\1\2"+
            "\6\uffff\24\2\1\uffff\25\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "4286:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_1 = input.LA(1);

                         
                        int index72_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend2()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA71_eotS =
        "\34\uffff";
    static final String DFA71_eofS =
        "\34\uffff";
    static final String DFA71_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA71_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA71_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA71_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA71_transitionS = {
            "\1\1\3\5\2\uffff\1\5\12\uffff\1\5\4\uffff\1\5\1\uffff\1\2\1"+
            "\33\23\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1\5\1\uffff"+
            "\1\5\2\uffff\3\5\2\uffff\7\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "4307:2: ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA71_0 = input.LA(1);

                         
                        int index71_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA71_0==RULE_ID) ) {s = 1;}

                        else if ( (LA71_0==28) ) {s = 2;}

                        else if ( (LA71_0==80) && (synpred18_InternalXtend2())) {s = 3;}

                        else if ( (LA71_0==59) && (synpred18_InternalXtend2())) {s = 4;}

                        else if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_RICH_TEXT_START)||LA71_0==RULE_INT||LA71_0==21||LA71_0==26||(LA71_0>=49 && LA71_0<=50)||LA71_0==54||LA71_0==58||LA71_0==61||LA71_0==63||(LA71_0>=66 && LA71_0<=68)||(LA71_0>=71 && LA71_0<=77)) ) {s = 5;}

                        else if ( (LA71_0==29) ) {s = 27;}

                         
                        input.seek(index71_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA71_1 = input.LA(1);

                         
                        int index71_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index71_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA71_2 = input.LA(1);

                         
                        int index71_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index71_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 71, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA76_eotS =
        "\34\uffff";
    static final String DFA76_eofS =
        "\34\uffff";
    static final String DFA76_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA76_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA76_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA76_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA76_transitionS = {
            "\1\1\3\5\2\uffff\1\5\12\uffff\1\5\4\uffff\1\5\1\uffff\1\2\1"+
            "\33\23\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1\5\1\uffff"+
            "\1\5\2\uffff\3\5\2\uffff\7\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
    static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
    static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
    static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
    static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
    static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
    static final short[][] DFA76_transition;

    static {
        int numStates = DFA76_transitionS.length;
        DFA76_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
        }
    }

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = DFA76_eot;
            this.eof = DFA76_eof;
            this.min = DFA76_min;
            this.max = DFA76_max;
            this.accept = DFA76_accept;
            this.special = DFA76_special;
            this.transition = DFA76_transition;
        }
        public String getDescription() {
            return "4472:1: ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_0 = input.LA(1);

                         
                        int index76_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA76_0==RULE_ID) ) {s = 1;}

                        else if ( (LA76_0==28) ) {s = 2;}

                        else if ( (LA76_0==80) && (synpred19_InternalXtend2())) {s = 3;}

                        else if ( (LA76_0==59) && (synpred19_InternalXtend2())) {s = 4;}

                        else if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_RICH_TEXT_START)||LA76_0==RULE_INT||LA76_0==21||LA76_0==26||(LA76_0>=49 && LA76_0<=50)||LA76_0==54||LA76_0==58||LA76_0==61||LA76_0==63||(LA76_0>=66 && LA76_0<=68)||(LA76_0>=71 && LA76_0<=77)) ) {s = 5;}

                        else if ( (LA76_0==29) ) {s = 27;}

                         
                        input.seek(index76_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA76_1 = input.LA(1);

                         
                        int index76_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index76_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA76_2 = input.LA(1);

                         
                        int index76_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index76_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA86_eotS =
        "\100\uffff";
    static final String DFA86_eofS =
        "\1\2\77\uffff";
    static final String DFA86_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA86_maxS =
        "\1\122\1\0\76\uffff";
    static final String DFA86_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA86_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA86_transitionS = {
            "\7\2\7\uffff\2\2\1\uffff\1\1\2\2\1\uffff\6\2\1\uffff\1\2\6\uffff"+
            "\24\2\1\uffff\25\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA86_eot = DFA.unpackEncodedString(DFA86_eotS);
    static final short[] DFA86_eof = DFA.unpackEncodedString(DFA86_eofS);
    static final char[] DFA86_min = DFA.unpackEncodedStringToUnsignedChars(DFA86_minS);
    static final char[] DFA86_max = DFA.unpackEncodedStringToUnsignedChars(DFA86_maxS);
    static final short[] DFA86_accept = DFA.unpackEncodedString(DFA86_acceptS);
    static final short[] DFA86_special = DFA.unpackEncodedString(DFA86_specialS);
    static final short[][] DFA86_transition;

    static {
        int numStates = DFA86_transitionS.length;
        DFA86_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA86_transition[i] = DFA.unpackEncodedString(DFA86_transitionS[i]);
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = DFA86_eot;
            this.eof = DFA86_eof;
            this.min = DFA86_min;
            this.max = DFA86_max;
            this.accept = DFA86_accept;
            this.special = DFA86_special;
            this.transition = DFA86_transition;
        }
        public String getDescription() {
            return "5161:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_1 = input.LA(1);

                         
                        int index86_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXtend2()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index86_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 86, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleFile123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFile144 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile167 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleFile189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleImport273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard389 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildCard408 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedNameWithWildCard421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleClass510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClass527 = new BitSet(new long[]{0x0000000007200000L});
    public static final BitSet FOLLOW_21_in_ruleClass545 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass566 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleClass579 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass600 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleClass614 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_24_in_ruleClass629 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass650 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleClass665 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass686 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_22_in_ruleClass699 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass720 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_26_in_ruleClass736 = new BitSet(new long[]{0x0000000018200010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleMember_in_ruleClass757 = new BitSet(new long[]{0x0000000018200010L,0x0000000000010000L});
    public static final BitSet FOLLOW_27_in_ruleClass770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMember862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFunction944 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction965 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleFunction978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction999 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleFunction1013 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFunction1036 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction1054 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFunction1071 = new BitSet(new long[]{0x0000000030000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1093 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_22_in_ruleFunction1106 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1127 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_ruleFunction1143 = new BitSet(new long[]{0xA4460000542004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFunction1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleFunction1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral1220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_ruleXStringLiteral1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString1351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_ruleRichString1445 = new BitSet(new long[]{0xA4460004942004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString1466 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString1488 = new BitSet(new long[]{0xA4460004942004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString1509 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteral1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_in_ruleRichStringLiteral1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart1672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralStart1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween1774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd1876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralEnd1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString1978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalRichString1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalRichStringLiteral_in_ruleInternalRichString2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString2072 = new BitSet(new long[]{0xA4460004942004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleInternalRichString2094 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString2115 = new BitSet(new long[]{0xA4460004942004F2L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleInternalRichStringLiteral_in_entryRuleInternalRichStringLiteral2155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalRichStringLiteral2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleInternalRichStringLiteral2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringPart2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringPart2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_ruleRichStringPart2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop2403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringForLoop2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleRichStringForLoop2459 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop2480 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleRichStringForLoop2492 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop2513 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop2534 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleRichStringForLoop2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf2582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringIf2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleRichStringIf2638 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringIf2659 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf2680 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf2701 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_35_in_ruleRichStringIf2715 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf2736 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleRichStringIf2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf2786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringElseIf2796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleRichStringElseIf2833 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringElseIf2854 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression2911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment3001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXAssignment3066 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment3082 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment3132 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment3185 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign3248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpSingleAssign3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign3336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMultiAssign3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3480 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression3533 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3556 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpOr3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3739 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression3792 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3815 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpAnd3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression3951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3998 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression4051 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression4074 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality4113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality4124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpEquality4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpEquality4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4278 = new BitSet(new long[]{0x0000700000A00002L});
    public static final BitSet FOLLOW_44_in_ruleXRelationalExpression4314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4339 = new BitSet(new long[]{0x0000700000A00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4400 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4423 = new BitSet(new long[]{0x0000700000A00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpCompare4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpCompare4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpCompare4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpCompare4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4666 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4719 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4742 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther4781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpOther4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4946 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4999 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression5022 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd5061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd5072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpAdd5110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpAdd5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression5169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5226 = new BitSet(new long[]{0x0038000000080002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5279 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5302 = new BitSet(new long[]{0x0038000000080002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti5341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti5352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpMulti5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpMulti5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpMulti5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpMulti5447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5555 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpUnary5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpUnary5709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpUnary5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression5825 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXCastedExpression5860 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5883 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall5931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5978 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_18_in_ruleXMemberFeatureCall6027 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6047 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall6063 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall6085 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_18_in_ruleXMemberFeatureCall6171 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_56_in_ruleXMemberFeatureCall6195 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_57_in_ruleXMemberFeatureCall6232 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall6261 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6282 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall6295 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6316 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleXMemberFeatureCall6330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6352 = new BitSet(new long[]{0x0300000010040002L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall6386 = new BitSet(new long[]{0xAC460000342004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall6431 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6459 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall6472 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6493 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall6510 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression6551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression6561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression6662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression6689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression6716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression6743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression6770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression6851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression6878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral6940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral7024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral7051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral7078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral7105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral7132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure7167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure7177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXClosure7223 = new BitSet(new long[]{0x0800000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7245 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXClosure7258 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7279 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_59_in_ruleXClosure7295 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure7316 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleXClosure7328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure7364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure7374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7430 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXShortClosure7443 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7464 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_59_in_ruleXShortClosure7480 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression7537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXParenthesizedExpression7584 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression7606 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXParenthesizedExpression7617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression7653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression7663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXIfExpression7709 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXIfExpression7721 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7742 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXIfExpression7754 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7775 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXIfExpression7796 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression7856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression7866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXSwitchExpression7912 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXSwitchExpression7930 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXSwitchExpression7947 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression7970 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXSwitchExpression7982 = new BitSet(new long[]{0x0000000110000010L,0x0000000000010002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression8003 = new BitSet(new long[]{0x0000000118000010L,0x0000000000010003L});
    public static final BitSet FOLLOW_64_in_ruleXSwitchExpression8017 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXSwitchExpression8029 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression8050 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleXSwitchExpression8064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart8100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart8110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart8156 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXCasePart8170 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart8191 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXCasePart8205 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression8262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXForLoopExpression8318 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXForLoopExpression8330 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression8351 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXForLoopExpression8363 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression8384 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXForLoopExpression8396 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression8417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression8453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression8463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXWhileExpression8509 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXWhileExpression8521 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression8542 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXWhileExpression8554 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression8611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression8621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXDoWhileExpression8667 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleXDoWhileExpression8700 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXDoWhileExpression8712 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8733 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXDoWhileExpression8745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression8781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXBlockExpression8837 = new BitSet(new long[]{0xA44600001C2004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression8859 = new BitSet(new long[]{0xA44600005C2004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_30_in_ruleXBlockExpression8872 = new BitSet(new long[]{0xA44600001C2004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_27_in_ruleXBlockExpression8888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock8924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock8934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock8981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock9008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration9043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration9053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXVariableDeclaration9106 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_70_in_ruleXVariableDeclaration9137 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration9186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration9203 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration9233 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleXVariableDeclaration9252 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration9273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter9311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter9321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter9367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter9385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall9426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall9436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall9483 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9504 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleXFeatureCall9517 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9538 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleXFeatureCall9552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall9574 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall9608 = new BitSet(new long[]{0xAC460000342004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall9653 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall9681 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_22_in_ruleXFeatureCall9694 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall9715 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall9732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall9780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXConstructorCall9826 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9849 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall9862 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9883 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleXConstructorCall9896 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9917 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleXConstructorCall9931 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall9945 = new BitSet(new long[]{0xAC460000342004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9977 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall10005 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_22_in_ruleXConstructorCall10018 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall10039 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall10056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral10092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral10102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXBooleanLiteral10149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleXBooleanLiteral10173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral10223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral10233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleXNullLiteral10279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral10315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral10325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral10376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral10417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral10427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleXTypeLiteral10473 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXTypeLiteral10485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral10508 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXTypeLiteral10520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression10566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleXThrowExpression10612 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression10633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleXTryCatchFinallyExpression10725 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10746 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10779 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_78_in_ruleXTryCatchFinallyExpression10801 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleXTryCatchFinallyExpression10845 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleXCatchClause10951 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXCatchClause10963 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10984 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXCatchClause10996 = new BitSet(new long[]{0xA4460000142004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause11017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName11054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName11065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName11105 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName11133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName11149 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference11196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference11206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference11253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef11325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXFunctionTypeRef11363 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11384 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_22_in_ruleXFunctionTypeRef11397 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11418 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_ruleXFunctionTypeRef11432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleXFunctionTypeRef11446 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11561 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleJvmParameterizedTypeReference11582 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11604 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleJvmParameterizedTypeReference11617 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11638 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleJvmParameterizedTypeReference11652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11809 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleJvmWildcardTypeReference11865 = new BitSet(new long[]{0x0000000001000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleJvmUpperBound11999 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound12020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded12056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded12066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleJvmUpperBoundAnded12103 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded12124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound12160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound12170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleJvmLowerBound12207 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound12228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter12264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter12274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmTypeParameter12316 = new BitSet(new long[]{0x0000000001000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter12344 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter12365 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter12394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalXtend23153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalXtend23501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalXtend23760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalXtend24019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred5_InternalXtend24295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalXtend24368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalXtend24687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalXtend24967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalXtend25247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred10_InternalXtend25841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred11_InternalXtend25995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred11_InternalXtend26003 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalXtend26010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred12_InternalXtend26110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred12_InternalXtend26124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred12_InternalXtend26144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred13_InternalXtend26368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred14_InternalXtend26414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred15_InternalXtend27788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred16_InternalXtend29155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred16_InternalXtend29164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred17_InternalXtend29590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred18_InternalXtend29636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred19_InternalXtend29960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred20_InternalXtend210762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_synpred21_InternalXtend210793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred22_InternalXtend211124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_synpred23_InternalXtend211574 = new BitSet(new long[]{0x0000000000000002L});

}
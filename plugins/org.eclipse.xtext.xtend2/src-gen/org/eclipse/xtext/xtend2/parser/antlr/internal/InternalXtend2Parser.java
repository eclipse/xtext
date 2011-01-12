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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_RICH_TEXT", "RULE_RICH_TEXT_START", "RULE_RICH_TEXT_INBETWEEN", "RULE_RICH_TEXT_END", "RULE_INT", "RULE_IN_DOUBLE_QUOTE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'.'", "'*'", "'<'", "','", "'>'", "'class'", "'extends'", "'implements'", "'{'", "'}'", "'('", "')'", "';'", "'FOR'", "':'", "'ENDFOR'", "'IF'", "'ELSE'", "'ENDIF'", "'ELSEIF'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'", "'super'"
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:76:1: ruleFile returns [EObject current=null] : ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_package_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_classes_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:79:28: ( ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:1: ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:1: ( (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:80:2: (otherlv_0= 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )*
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:120:3: ( (lv_classes_3_0= ruleClass ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20||LA3_0==23) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:121:1: (lv_classes_3_0= ruleClass )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:121:1: (lv_classes_3_0= ruleClass )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:122:3: lv_classes_3_0= ruleClass
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFileAccess().getClassesClassParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleClass_in_ruleFile189);
            	    lv_classes_3_0=ruleClass();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFileRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"classes",
            	              		lv_classes_3_0, 
            	              		"Class");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:242:1: ruleClass returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? otherlv_5= 'class' ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* otherlv_11= '{' ( (lv_members_12_0= ruleMember ) )* otherlv_13= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeParameters_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_superTypes_8_0 = null;

        EObject lv_superTypes_10_0 = null;

        EObject lv_members_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:245:28: ( ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? otherlv_5= 'class' ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* otherlv_11= '{' ( (lv_members_12_0= ruleMember ) )* otherlv_13= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? otherlv_5= 'class' ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* otherlv_11= '{' ( (lv_members_12_0= ruleMember ) )* otherlv_13= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? otherlv_5= 'class' ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* otherlv_11= '{' ( (lv_members_12_0= ruleMember ) )* otherlv_13= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? otherlv_5= 'class' ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* otherlv_11= '{' ( (lv_members_12_0= ruleMember ) )* otherlv_13= '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:246:4: otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleClass511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getClassAccess().getLessThanSignKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:250:1: ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:251:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:251:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:252:3: lv_typeParameters_1_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleClass532);
                    lv_typeParameters_1_0=ruleJvmTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassRule());
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:268:2: (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:268:4: otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleClass545); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getClassAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:272:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:273:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:273:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:274:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_2_1_0()); 
                    	      	    
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


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleClass580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getGreaterThanSignKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleClass594); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getClassAccess().getClassKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:298:1: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:299:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:299:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:300:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClass611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_6_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClassRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_6_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:316:2: (otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:316:4: otherlv_7= 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) )
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleClass629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getClassAccess().getExtendsKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:320:1: ( (lv_superTypes_8_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:321:1: (lv_superTypes_8_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:321:1: (lv_superTypes_8_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:322:3: lv_superTypes_8_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassAccess().getSuperTypesJvmTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass650);
                    lv_superTypes_8_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassRule());
                      	        }
                             		add(
                             			current, 
                             			"superTypes",
                              		lv_superTypes_8_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:338:4: (otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:338:6: otherlv_9= 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) )
            	    {
            	    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleClass665); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getClassAccess().getImplementsKeyword_4_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:342:1: ( (lv_superTypes_10_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:343:1: (lv_superTypes_10_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:343:1: (lv_superTypes_10_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:344:3: lv_superTypes_10_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassAccess().getSuperTypesJvmTypeReferenceParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass686);
            	    lv_superTypes_10_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"superTypes",
            	              		lv_superTypes_10_0, 
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

            otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleClass700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:364:1: ( (lv_members_12_0= ruleMember ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==20||LA9_0==28||LA9_0==80) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:365:1: (lv_members_12_0= ruleMember )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:365:1: (lv_members_12_0= ruleMember )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:366:3: lv_members_12_0= ruleMember
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMember_in_ruleClass721);
            	    lv_members_12_0=ruleMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"members",
            	              		lv_members_12_0, 
            	              		"Member");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_13=(Token)match(input,27,FOLLOW_27_in_ruleClass734); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_7());
                  
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:394:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:395:2: (iv_ruleMember= ruleMember EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:396:2: iv_ruleMember= ruleMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMemberRule()); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember770);
            iv_ruleMember=ruleMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMember; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember780); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:403:1: ruleMember returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:406:28: (this_Function_0= ruleFunction )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:408:5: this_Function_0= ruleFunction
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMemberAccess().getFunctionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleMember826);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:424:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:425:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:426:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction860);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction870); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:433:1: ruleFunction returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:436:28: ( ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:437:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:437:1: ( (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:437:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? otherlv_11= ')' ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:437:2: (otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:437:4: otherlv_0= '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleFunction908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getLessThanSignKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:441:1: ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:442:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:442:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:443:3: lv_typeParameters_1_0= ruleJvmTypeParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction929);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:2: (otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==21) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:459:4: otherlv_2= ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleFunction942); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:463:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:464:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:464:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:465:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction963);
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
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleFunction977); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getGreaterThanSignKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:485:3: ( (lv_returnType_5_0= ruleJvmTypeReference ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_ID||LA12_1==18||LA12_1==20) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==28||LA12_0==80) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:486:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:486:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:487:3: lv_returnType_5_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeJvmTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFunction1000);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:503:3: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:504:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:504:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:505:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction1018); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleFunction1035); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:525:1: ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||LA14_0==28||LA14_0==80) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:525:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:525:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:526:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:526:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:527:3: lv_parameters_8_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1057);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:543:2: (otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:543:4: otherlv_9= ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleFunction1070); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:547:1: ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:548:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:548:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:549:3: lv_parameters_10_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1091);
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
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,29,FOLLOW_29_in_ruleFunction1107); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:569:1: ( ( (lv_expression_12_0= ruleXExpression ) ) | otherlv_13= ';' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_RICH_TEXT_START)||LA15_0==RULE_INT||LA15_0==20||LA15_0==26||LA15_0==28||(LA15_0>=49 && LA15_0<=50)||LA15_0==54||LA15_0==58||LA15_0==61||LA15_0==63||(LA15_0>=66 && LA15_0<=68)||(LA15_0>=71 && LA15_0<=77)) ) {
                alt15=1;
            }
            else if ( (LA15_0==30) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:569:2: ( (lv_expression_12_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:569:2: ( (lv_expression_12_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:570:1: (lv_expression_12_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:570:1: (lv_expression_12_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:571:3: lv_expression_12_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getExpressionXExpressionParserRuleCall_6_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleFunction1129);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:588:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,30,FOLLOW_30_in_ruleFunction1147); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:600:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:601:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:602:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral1184);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral1194); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:609:1: ruleXStringLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject this_RichString_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:612:28: ( ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | this_RichString_2= ruleRichString )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=RULE_RICH_TEXT && LA16_0<=RULE_RICH_TEXT_START)) ) {
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:3: () ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:614:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:619:2: ( (lv_value_1_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:620:1: (lv_value_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:620:1: (lv_value_1_0= RULE_STRING )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:621:3: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral1246); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:639:5: this_RichString_2= ruleRichString
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXStringLiteralAccess().getRichStringParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichString_in_ruleXStringLiteral1280);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:655:1: entryRuleRichString returns [EObject current=null] : iv_ruleRichString= ruleRichString EOF ;
    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichString = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:656:2: (iv_ruleRichString= ruleRichString EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:657:2: iv_ruleRichString= ruleRichString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringRule()); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString1315);
            iv_ruleRichString=ruleRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString1325); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:664:1: ruleRichString returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) ) ) ;
    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:667:28: ( ( ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:1: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:1: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_RICH_TEXT) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_RICH_TEXT_START) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:2: ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:2: ( () ( (lv_value_1_0= RULE_RICH_TEXT ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:3: () ( (lv_value_1_0= RULE_RICH_TEXT ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:669:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getRichStringAccess().getRichStringLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:674:2: ( (lv_value_1_0= RULE_RICH_TEXT ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:675:1: (lv_value_1_0= RULE_RICH_TEXT )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:675:1: (lv_value_1_0= RULE_RICH_TEXT )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:676:3: lv_value_1_0= RULE_RICH_TEXT
                    {
                    lv_value_1_0=(Token)match(input,RULE_RICH_TEXT,FOLLOW_RULE_RICH_TEXT_in_ruleRichString1377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getRichStringAccess().getValueRICH_TEXTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRichStringRule());
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:693:6: ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:693:6: ( () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:693:7: () ( (lv_elements_3_0= ruleRichStringLiteralStart ) ) ( (lv_elements_4_0= ruleRichStringPart ) ) ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )* ( (lv_elements_7_0= ruleRichStringLiteralEnd ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:693:7: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:694:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getRichStringAccess().getRichStringAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:699:2: ( (lv_elements_3_0= ruleRichStringLiteralStart ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:700:1: (lv_elements_3_0= ruleRichStringLiteralStart )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:700:1: (lv_elements_3_0= ruleRichStringLiteralStart )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:701:3: lv_elements_3_0= ruleRichStringLiteralStart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralStartParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralStart_in_ruleRichString1420);
                    lv_elements_3_0=ruleRichStringLiteralStart();

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
                              		"RichStringLiteralStart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:717:2: ( (lv_elements_4_0= ruleRichStringPart ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:718:1: (lv_elements_4_0= ruleRichStringPart )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:718:1: (lv_elements_4_0= ruleRichStringPart )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:719:3: lv_elements_4_0= ruleRichStringPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringPartParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringPart_in_ruleRichString1441);
                    lv_elements_4_0=ruleRichStringPart();

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
                              		"RichStringPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:735:2: ( ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_RICH_TEXT_INBETWEEN) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:735:3: ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) ( (lv_elements_6_0= ruleRichStringPart ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:735:3: ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:736:1: (lv_elements_5_0= ruleRichStringLiteralInbetween )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:736:1: (lv_elements_5_0= ruleRichStringLiteralInbetween )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:737:3: lv_elements_5_0= ruleRichStringLiteralInbetween
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString1463);
                    	    lv_elements_5_0=ruleRichStringLiteralInbetween();

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
                    	              		"RichStringLiteralInbetween");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:753:2: ( (lv_elements_6_0= ruleRichStringPart ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:754:1: (lv_elements_6_0= ruleRichStringPart )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:754:1: (lv_elements_6_0= ruleRichStringPart )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:755:3: lv_elements_6_0= ruleRichStringPart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringPartParserRuleCall_1_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringPart_in_ruleRichString1484);
                    	    lv_elements_6_0=ruleRichStringPart();

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
                    	              		"RichStringPart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:771:4: ( (lv_elements_7_0= ruleRichStringLiteralEnd ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:772:1: (lv_elements_7_0= ruleRichStringLiteralEnd )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:772:1: (lv_elements_7_0= ruleRichStringLiteralEnd )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:773:3: lv_elements_7_0= ruleRichStringLiteralEnd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringAccess().getElementsRichStringLiteralEndParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString1507);
                    lv_elements_7_0=ruleRichStringLiteralEnd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRichStringRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_7_0, 
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


    // $ANTLR start "entryRuleRichStringLiteralStart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:797:1: entryRuleRichStringLiteralStart returns [EObject current=null] : iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF ;
    public final EObject entryRuleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralStart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:798:2: (iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:799:2: iv_ruleRichStringLiteralStart= ruleRichStringLiteralStart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralStartRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart1544);
            iv_ruleRichStringLiteralStart=ruleRichStringLiteralStart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralStart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralStart1554); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:806:1: ruleRichStringLiteralStart returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) ) ;
    public final EObject ruleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:809:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:810:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:810:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_START ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:810:2: () ( (lv_value_1_0= RULE_RICH_TEXT_START ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:810:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:811:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralStartAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:816:2: ( (lv_value_1_0= RULE_RICH_TEXT_START ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:817:1: (lv_value_1_0= RULE_RICH_TEXT_START )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:817:1: (lv_value_1_0= RULE_RICH_TEXT_START )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:818:3: lv_value_1_0= RULE_RICH_TEXT_START
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_START,FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart1605); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:842:1: entryRuleRichStringLiteralInbetween returns [EObject current=null] : iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF ;
    public final EObject entryRuleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralInbetween = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:843:2: (iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:844:2: iv_ruleRichStringLiteralInbetween= ruleRichStringLiteralInbetween EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralInbetweenRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween1646);
            iv_ruleRichStringLiteralInbetween=ruleRichStringLiteralInbetween();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralInbetween; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween1656); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:851:1: ruleRichStringLiteralInbetween returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) ;
    public final EObject ruleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:854:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:855:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:855:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:855:2: () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:855:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:856:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralInbetweenAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:861:2: ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:863:3: lv_value_1_0= RULE_RICH_TEXT_INBETWEEN
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_INBETWEEN,FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween1707); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:887:1: entryRuleRichStringLiteralEnd returns [EObject current=null] : iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF ;
    public final EObject entryRuleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteralEnd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:888:2: (iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:889:2: iv_ruleRichStringLiteralEnd= ruleRichStringLiteralEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringLiteralEndRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd1748);
            iv_ruleRichStringLiteralEnd=ruleRichStringLiteralEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralEnd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralEnd1758); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:896:1: ruleRichStringLiteralEnd returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) ) ;
    public final EObject ruleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:899:28: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:900:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:900:1: ( () ( (lv_value_1_0= RULE_RICH_TEXT_END ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:900:2: () ( (lv_value_1_0= RULE_RICH_TEXT_END ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:900:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:901:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringLiteralEndAccess().getRichStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:906:2: ( (lv_value_1_0= RULE_RICH_TEXT_END ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:907:1: (lv_value_1_0= RULE_RICH_TEXT_END )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:907:1: (lv_value_1_0= RULE_RICH_TEXT_END )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:908:3: lv_value_1_0= RULE_RICH_TEXT_END
            {
            lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_END,FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd1809); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:932:1: entryRuleInternalRichString returns [EObject current=null] : iv_ruleInternalRichString= ruleInternalRichString EOF ;
    public final EObject entryRuleInternalRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalRichString = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:933:2: (iv_ruleInternalRichString= ruleInternalRichString EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:934:2: iv_ruleInternalRichString= ruleInternalRichString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalRichStringRule()); 
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString1850);
            iv_ruleInternalRichString=ruleInternalRichString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalRichString1860); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:941:1: ruleInternalRichString returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ ) ) ;
    public final EObject ruleInternalRichString() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:944:28: ( ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:1: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:1: ( ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) ) | ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_RICH_TEXT_INBETWEEN) ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1>=RULE_ID && LA20_1<=RULE_RICH_TEXT_START)||LA20_1==RULE_INT||LA20_1==20||LA20_1==26||LA20_1==28||LA20_1==31||LA20_1==34||(LA20_1>=49 && LA20_1<=50)||LA20_1==54||LA20_1==58||LA20_1==61||LA20_1==63||(LA20_1>=66 && LA20_1<=68)||(LA20_1>=71 && LA20_1<=77)) ) {
                    alt20=2;
                }
                else if ( (LA20_1==EOF||LA20_1==33||(LA20_1>=35 && LA20_1<=37)) ) {
                    alt20=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:2: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:2: ( () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:3: () ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:946:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getInternalRichStringAccess().getRichStringLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:951:2: ( (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:952:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:952:1: (lv_value_1_0= RULE_RICH_TEXT_INBETWEEN )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:953:3: lv_value_1_0= RULE_RICH_TEXT_INBETWEEN
                    {
                    lv_value_1_0=(Token)match(input,RULE_RICH_TEXT_INBETWEEN,FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleInternalRichString1912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getInternalRichStringAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInternalRichStringRule());
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:970:6: ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:970:6: ( () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+ )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:970:7: () ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) ) ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:970:7: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:971:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getInternalRichStringAccess().getRichStringAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:976:2: ( (lv_elements_3_0= ruleRichStringLiteralInbetween ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:977:1: (lv_elements_3_0= ruleRichStringLiteralInbetween )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:977:1: (lv_elements_3_0= ruleRichStringLiteralInbetween )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:978:3: lv_elements_3_0= ruleRichStringLiteralInbetween
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString1955);
                    lv_elements_3_0=ruleRichStringLiteralInbetween();

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
                              		"RichStringLiteralInbetween");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:2: ( ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_RICH_TEXT_START)||LA19_0==RULE_INT||LA19_0==20||LA19_0==26||LA19_0==28||LA19_0==31||LA19_0==34||(LA19_0>=49 && LA19_0<=50)||LA19_0==54||LA19_0==58||LA19_0==61||LA19_0==63||(LA19_0>=66 && LA19_0<=68)||(LA19_0>=71 && LA19_0<=77)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:3: ( (lv_elements_4_0= ruleRichStringPart ) ) ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:3: ( (lv_elements_4_0= ruleRichStringPart ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: (lv_elements_4_0= ruleRichStringPart )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: (lv_elements_4_0= ruleRichStringPart )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:996:3: lv_elements_4_0= ruleRichStringPart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringPartParserRuleCall_1_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringPart_in_ruleInternalRichString1977);
                    	    lv_elements_4_0=ruleRichStringPart();

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
                    	              		"RichStringPart");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1012:2: ( (lv_elements_5_0= ruleRichStringLiteralInbetween ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1013:1: (lv_elements_5_0= ruleRichStringLiteralInbetween )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1013:1: (lv_elements_5_0= ruleRichStringLiteralInbetween )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1014:3: lv_elements_5_0= ruleRichStringLiteralInbetween
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInternalRichStringAccess().getElementsRichStringLiteralInbetweenParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString1998);
                    	    lv_elements_5_0=ruleRichStringLiteralInbetween();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInternalRichStringRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_5_0, 
                    	              		"RichStringLiteralInbetween");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


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
    // $ANTLR end "ruleInternalRichString"


    // $ANTLR start "entryRuleRichStringPart"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1038:1: entryRuleRichStringPart returns [EObject current=null] : iv_ruleRichStringPart= ruleRichStringPart EOF ;
    public final EObject entryRuleRichStringPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringPart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1039:2: (iv_ruleRichStringPart= ruleRichStringPart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1040:2: iv_ruleRichStringPart= ruleRichStringPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringPartRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart2037);
            iv_ruleRichStringPart=ruleRichStringPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringPart2047); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1047:1: ruleRichStringPart returns [EObject current=null] : (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf ) ;
    public final EObject ruleRichStringPart() throws RecognitionException {
        EObject current = null;

        EObject this_XExpression_0 = null;

        EObject this_RichStringForLoop_1 = null;

        EObject this_RichStringIf_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1050:28: ( (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1051:1: (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1051:1: (this_XExpression_0= ruleXExpression | this_RichStringForLoop_1= ruleRichStringForLoop | this_RichStringIf_2= ruleRichStringIf )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
            case RULE_INT:
            case 20:
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
                alt21=1;
                }
                break;
            case 31:
                {
                alt21=2;
                }
                break;
            case 34:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1052:5: this_XExpression_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getXExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringPart2094);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1062:5: this_RichStringForLoop_1= ruleRichStringForLoop
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringForLoopParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart2121);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1072:5: this_RichStringIf_2= ruleRichStringIf
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRichStringPartAccess().getRichStringIfParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichStringIf_in_ruleRichStringPart2148);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1088:1: entryRuleRichStringForLoop returns [EObject current=null] : iv_ruleRichStringForLoop= ruleRichStringForLoop EOF ;
    public final EObject entryRuleRichStringForLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringForLoop = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1089:2: (iv_ruleRichStringForLoop= ruleRichStringForLoop EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1090:2: iv_ruleRichStringForLoop= ruleRichStringForLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringForLoopRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop2183);
            iv_ruleRichStringForLoop=ruleRichStringForLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringForLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringForLoop2193); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1097:1: ruleRichStringForLoop returns [EObject current=null] : ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1100:28: ( ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:1: ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:1: ( () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:2: () otherlv_1= 'FOR' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) ( (lv_eachExpression_5_0= ruleInternalRichString ) ) otherlv_6= 'ENDFOR'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringForLoopAccess().getRichStringForLoopAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleRichStringForLoop2239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRichStringForLoopAccess().getFORKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1111:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1112:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1112:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1113:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop2260);
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

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleRichStringForLoop2272); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRichStringForLoopAccess().getColonKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1133:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1134:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1134:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1135:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getForExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringForLoop2293);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1151:2: ( (lv_eachExpression_5_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1152:1: (lv_eachExpression_5_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1152:1: (lv_eachExpression_5_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1153:3: lv_eachExpression_5_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringForLoopAccess().getEachExpressionInternalRichStringParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop2314);
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

            otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleRichStringForLoop2326); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1181:1: entryRuleRichStringIf returns [EObject current=null] : iv_ruleRichStringIf= ruleRichStringIf EOF ;
    public final EObject entryRuleRichStringIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringIf = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1182:2: (iv_ruleRichStringIf= ruleRichStringIf EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1183:2: iv_ruleRichStringIf= ruleRichStringIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringIfRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf2362);
            iv_ruleRichStringIf=ruleRichStringIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringIf2372); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1190:1: ruleRichStringIf returns [EObject current=null] : ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1193:28: ( ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1194:1: ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1194:1: ( () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1194:2: () otherlv_1= 'IF' ( (lv_if_2_0= ruleXExpression ) ) ( (lv_then_3_0= ruleInternalRichString ) ) ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )* (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )? otherlv_7= 'ENDIF'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1194:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1195:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRichStringIfAccess().getRichStringIfAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleRichStringIf2418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRichStringIfAccess().getIFKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1204:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1205:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1205:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1206:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringIfAccess().getIfXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringIf2439);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1222:2: ( (lv_then_3_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1223:1: (lv_then_3_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1223:1: (lv_then_3_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1224:3: lv_then_3_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringIfAccess().getThenInternalRichStringParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringIf2460);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1240:2: ( (lv_elseIfs_4_0= ruleRichStringElseIf ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==37) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1241:1: (lv_elseIfs_4_0= ruleRichStringElseIf )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1241:1: (lv_elseIfs_4_0= ruleRichStringElseIf )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1242:3: lv_elseIfs_4_0= ruleRichStringElseIf
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRichStringIfAccess().getElseIfsRichStringElseIfParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf2481);
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
            	    break loop22;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1258:3: (otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1258:5: otherlv_5= 'ELSE' ( (lv_else_6_0= ruleInternalRichString ) )
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleRichStringIf2495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRichStringIfAccess().getELSEKeyword_5_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1262:1: ( (lv_else_6_0= ruleInternalRichString ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1263:1: (lv_else_6_0= ruleInternalRichString )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1263:1: (lv_else_6_0= ruleInternalRichString )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1264:3: lv_else_6_0= ruleInternalRichString
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRichStringIfAccess().getElseInternalRichStringParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringIf2516);
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

            otherlv_7=(Token)match(input,36,FOLLOW_36_in_ruleRichStringIf2530); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1292:1: entryRuleRichStringElseIf returns [EObject current=null] : iv_ruleRichStringElseIf= ruleRichStringElseIf EOF ;
    public final EObject entryRuleRichStringElseIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringElseIf = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1293:2: (iv_ruleRichStringElseIf= ruleRichStringElseIf EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:2: iv_ruleRichStringElseIf= ruleRichStringElseIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRichStringElseIfRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf2566);
            iv_ruleRichStringElseIf=ruleRichStringElseIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringElseIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringElseIf2576); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1301:1: ruleRichStringElseIf returns [EObject current=null] : (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) ) ;
    public final EObject ruleRichStringElseIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_if_1_0 = null;

        EObject lv_then_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1304:28: ( (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1305:1: (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1305:1: (otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1305:3: otherlv_0= 'ELSEIF' ( (lv_if_1_0= ruleXExpression ) ) ( (lv_then_2_0= ruleInternalRichString ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleRichStringElseIf2613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRichStringElseIfAccess().getELSEIFKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1309:1: ( (lv_if_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1310:1: (lv_if_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1310:1: (lv_if_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1311:3: lv_if_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleRichStringElseIf2634);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1327:2: ( (lv_then_2_0= ruleInternalRichString ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1328:1: (lv_then_2_0= ruleInternalRichString )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1328:1: (lv_then_2_0= ruleInternalRichString )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1329:3: lv_then_2_0= ruleInternalRichString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf2655);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1353:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1354:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1355:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression2691);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression2701); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1362:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1365:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1367:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression2747);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1383:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1385:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment2781);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment2791); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1392:1: ruleXAssignment returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1395:28: ( ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:1: ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:1: ( ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==38) ) {
                    alt25=1;
                }
                else if ( (LA25_1==EOF||(LA25_1>=RULE_ID && LA25_1<=RULE_INT)||(LA25_1>=18 && LA25_1<=22)||(LA25_1>=26 && LA25_1<=30)||LA25_1==32||(LA25_1>=39 && LA25_1<=58)||(LA25_1>=60 && LA25_1<=80)) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_RICH_TEXT_START)||LA25_0==RULE_INT||LA25_0==20||LA25_0==26||LA25_0==28||(LA25_0>=49 && LA25_0<=50)||LA25_0==54||LA25_0==58||LA25_0==61||LA25_0==63||(LA25_0>=66 && LA25_0<=68)||(LA25_0>=71 && LA25_0<=77)) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:2: ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:2: ( () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:3: () ( (otherlv_1= RULE_ID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1396:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1397:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1402:2: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1403:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1403:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXAssignment2846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifyableElementCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment2862);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1423:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1424:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1424:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1425:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment2882);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1442:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1442:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1443:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment2912);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==39) ) {
                        int LA24_1 = input.LA(2);

                        if ( (synpred1_InternalXtend2()) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1456:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1456:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1456:7: ()
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1457:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1462:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1463:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1463:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1464:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment2965);
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

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1477:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1478:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1478:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1479:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment2988);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1503:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1504:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1505:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign3028);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign3039); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1512:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1515:28: (kw= '=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1517:2: kw= '='
            {
            kw=(Token)match(input,38,FOLLOW_38_in_ruleOpSingleAssign3076); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1530:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1532:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign3116);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign3127); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1539:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1542:28: (kw= '+=' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1544:2: kw= '+='
            {
            kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMultiAssign3164); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1557:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1558:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1559:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3203);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression3213); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1566:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1569:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1571:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3260);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred2_InternalXtend2()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1584:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1584:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1584:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1585:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1590:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1591:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1591:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1592:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression3313);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1605:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1606:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1607:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression3336);
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
            	    break loop26;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1631:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1632:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1633:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3375);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3386); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1640:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1643:28: (kw= '||' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1645:2: kw= '||'
            {
            kw=(Token)match(input,40,FOLLOW_40_in_ruleOpOr3423); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1658:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1659:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1660:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3462);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression3472); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1667:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1670:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1671:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1671:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1672:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3519);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred3_InternalXtend2()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1686:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1691:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1692:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1692:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1693:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression3572);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1706:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1707:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1707:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1708:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3595);
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1732:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1733:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1734:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3634);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3645); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1741:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1744:28: (kw= '&&' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1746:2: kw= '&&'
            {
            kw=(Token)match(input,41,FOLLOW_41_in_ruleOpAnd3682); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1759:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1760:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1761:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3721);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression3731); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1768:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1771:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1772:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1772:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1773:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3778);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred4_InternalXtend2()) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==43) ) {
                    int LA28_3 = input.LA(2);

                    if ( (synpred4_InternalXtend2()) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1786:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1786:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1786:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1787:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1792:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1793:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1793:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1794:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3831);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1807:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1808:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1808:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1809:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3854);
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1833:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1834:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1835:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3893);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3904); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1842:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1845:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1846:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1846:1: (kw= '==' | kw= '!=' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==42) ) {
                alt29=1;
            }
            else if ( (LA29_0==43) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1847:2: kw= '=='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpEquality3942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1854:2: kw= '!='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpEquality3961); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1867:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1868:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1869:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4001);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression4011); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1876:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1879:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1880:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1880:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4058);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop30:
            do {
                int alt30=3;
                switch ( input.LA(1) ) {
                case 20:
                    {
                    int LA30_2 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 44:
                    {
                    int LA30_3 = input.LA(2);

                    if ( (synpred5_InternalXtend2()) ) {
                        alt30=1;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA30_4 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA30_5 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA30_6 = input.LA(2);

                    if ( (synpred6_InternalXtend2()) ) {
                        alt30=2;
                    }


                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1891:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1891:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1891:6: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1892:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXRelationalExpression4094); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1901:3: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1902:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1902:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1903:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4119);
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
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1922:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1922:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1922:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1923:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1928:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1929:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1929:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1930:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4180);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1943:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1944:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1944:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1945:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4203);
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
            	    break loop30;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1969:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1970:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1971:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4243);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4254); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1978:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1981:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1982:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1982:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt31=1;
                }
                break;
            case 46:
                {
                alt31=2;
                }
                break;
            case 22:
                {
                alt31=3;
                }
                break;
            case 20:
                {
                alt31=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1983:2: kw= '>='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpCompare4292); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1990:2: kw= '<='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpCompare4311); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1997:2: kw= '>'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpCompare4330); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2004:2: kw= '<'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleOpCompare4349); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2017:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2018:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2019:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4389);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4399); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2026:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2029:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2030:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2030:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2031:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4446);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==47) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred7_InternalXtend2()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==48) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred7_InternalXtend2()) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2044:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2044:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2044:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2045:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2050:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2051:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2051:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2052:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4499);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2065:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2066:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2066:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2067:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4522);
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
            	    break loop32;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2091:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2092:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2093:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther4561);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther4572); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2100:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2103:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: (kw= '->' | kw= '..' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            else if ( (LA33_0==48) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2105:2: kw= '->'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther4610); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2112:2: kw= '..'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther4629); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2125:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2126:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2127:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4669);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression4679); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2134:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2137:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2138:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2138:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2139:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4726);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==49) ) {
                    int LA34_2 = input.LA(2);

                    if ( (synpred8_InternalXtend2()) ) {
                        alt34=1;
                    }


                }
                else if ( (LA34_0==50) ) {
                    int LA34_3 = input.LA(2);

                    if ( (synpred8_InternalXtend2()) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2153:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2158:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2159:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2159:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2160:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4779);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2173:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2174:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2174:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2175:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4802);
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
            	    break loop34;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2199:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2200:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2201:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4841);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4852); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2208:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2211:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2212:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2212:1: (kw= '+' | kw= '-' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            else if ( (LA35_0==50) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2213:2: kw= '+'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpAdd4890); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2220:2: kw= '-'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpAdd4909); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2233:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2234:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2235:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4949);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4959); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2242:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2245:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2246:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2246:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2247:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5006);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop36:
            do {
                int alt36=2;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 51:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 52:
                    {
                    int LA36_4 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA36_5 = input.LA(2);

                    if ( (synpred9_InternalXtend2()) ) {
                        alt36=1;
                    }


                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2260:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2260:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2260:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2261:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2266:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2267:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2267:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2268:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5059);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2281:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2282:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2282:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2283:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5082);
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
            	    break loop36;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2307:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2308:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2309:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti5121);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti5132); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2316:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2319:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2320:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2320:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt37=1;
                }
                break;
            case 51:
                {
                alt37=2;
                }
                break;
            case 52:
                {
                alt37=3;
                }
                break;
            case 53:
                {
                alt37=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2321:2: kw= '*'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleOpMulti5170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2328:2: kw= '**'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpMulti5189); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2335:2: kw= '/'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpMulti5208); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2342:2: kw= '%'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpMulti5227); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2355:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2356:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2357:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5267);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation5277); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2364:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2367:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=49 && LA38_0<=50)||LA38_0==54) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_RICH_TEXT_START)||LA38_0==RULE_INT||LA38_0==20||LA38_0==26||LA38_0==28||LA38_0==58||LA38_0==61||LA38_0==63||(LA38_0>=66 && LA38_0<=68)||(LA38_0>=71 && LA38_0<=77)) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2368:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2369:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2374:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2375:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2375:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2376:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifyableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5335);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2389:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2390:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2390:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2391:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5356);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2409:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5385);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2425:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2426:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2427:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5421);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5432); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2434:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2437:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2438:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2438:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt39=1;
                }
                break;
            case 50:
                {
                alt39=2;
                }
                break;
            case 49:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2439:2: kw= '!'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpUnary5470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2446:2: kw= '-'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpUnary5489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2453:2: kw= '+'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpUnary5508); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2466:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2467:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2468:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5548);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression5558); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2475:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2478:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2479:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2479:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2480:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression5605);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==55) ) {
                    int LA40_2 = input.LA(2);

                    if ( (synpred10_InternalXtend2()) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:6: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2491:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleXCastedExpression5640); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2500:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2501:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2501:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2502:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5663);
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
            	    break loop40;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2526:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2527:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2528:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5701);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall5711); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2535:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2538:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2539:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2539:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2540:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5758);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:1: ( ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            loop47:
            do {
                int alt47=3;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    int LA47_2 = input.LA(2);

                    if ( (synpred11_InternalXtend2()) ) {
                        alt47=1;
                    }
                    else if ( (synpred12_InternalXtend2()) ) {
                        alt47=2;
                    }


                    }
                    break;
                case 56:
                    {
                    int LA47_3 = input.LA(2);

                    if ( (synpred12_InternalXtend2()) ) {
                        alt47=2;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA47_4 = input.LA(2);

                    if ( (synpred12_InternalXtend2()) ) {
                        alt47=2;
                    }


                    }
                    break;

                }

                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:2: ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:2: ( ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:3: ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:3: ( ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:4: ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2555:25: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2555:26: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2555:26: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2556:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleXMemberFeatureCall5807); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2565:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2566:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2566:1: (otherlv_3= RULE_ID )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2567:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5827); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_0_0_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall5843);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2586:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2587:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2587:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2588:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall5865);
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
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( (otherlv_15= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2621:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2621:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2621:8: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2622:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2627:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt41=3;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt41=1;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt41=2;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt41=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt41) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2627:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleXMemberFeatureCall5951); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2632:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2632:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2633:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2633:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2634:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,56,FOLLOW_56_in_ruleXMemberFeatureCall5975); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2648:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2649:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2649:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2650:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,57,FOLLOW_57_in_ruleXMemberFeatureCall6012); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2663:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==20) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2663:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall6041); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2667:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2668:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2668:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2669:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6062);
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

            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2685:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop42:
            	            do {
            	                int alt42=2;
            	                int LA42_0 = input.LA(1);

            	                if ( (LA42_0==21) ) {
            	                    alt42=1;
            	                }


            	                switch (alt42) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2685:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall6075); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2689:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2690:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2690:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2691:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6096);
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
            	            	    break loop42;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall6110); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2711:3: ( (otherlv_15= RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2712:1: (otherlv_15= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2712:1: (otherlv_15= RULE_ID )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2713:3: otherlv_15= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6132); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2724:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt46=2;
            	    alt46 = dfa46.predict(input);
            	    switch (alt46) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2724:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2724:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2724:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2731:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2732:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,28,FOLLOW_28_in_ruleXMemberFeatureCall6166); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:2: ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt45=3;
            	            alt45 = dfa45.predict(input);
            	            switch (alt45) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:3: ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:3: ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:4: ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2751:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall6211);
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
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2768:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2769:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2769:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2770:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6239);
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

            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2786:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop44:
            	                    do {
            	                        int alt44=2;
            	                        int LA44_0 = input.LA(1);

            	                        if ( (LA44_0==21) ) {
            	                            alt44=1;
            	                        }


            	                        switch (alt44) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2786:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall6252); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2790:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2791:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2791:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2792:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6273);
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
            	                    	    break loop44;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall6290); if (state.failed) return current;
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
            	    break loop47;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2820:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2821:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2822:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression6331);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression6341); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2829:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2832:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2833:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2833:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_11= ruleXParenthesizedExpression )
            int alt48=12;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt48=1;
                }
                break;
            case 26:
                {
                alt48=2;
                }
                break;
            case 63:
                {
                alt48=3;
                }
                break;
            case RULE_ID:
            case 20:
                {
                alt48=4;
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
                alt48=5;
                }
                break;
            case 61:
                {
                alt48=6;
                }
                break;
            case 66:
                {
                alt48=7;
                }
                break;
            case 67:
                {
                alt48=8;
                }
                break;
            case 68:
                {
                alt48=9;
                }
                break;
            case 76:
                {
                alt48=10;
                }
                break;
            case 77:
                {
                alt48=11;
                }
                break;
            case 28:
                {
                alt48=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2834:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression6388);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2844:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression6415);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2854:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression6442);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2864:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression6469);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2874:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression6496);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2884:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression6523);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2894:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression6550);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2904:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression6577);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2914:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression6604);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2924:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression6631);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2934:5: this_XTryCatchFinallyExpression_10= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression6658);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2944:5: this_XParenthesizedExpression_11= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression6685);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2960:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2961:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2962:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral6720);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral6730); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2969:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2972:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2973:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2973:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt49=1;
                }
                break;
            case 72:
            case 73:
                {
                alt49=2;
                }
                break;
            case RULE_INT:
                {
                alt49=3;
                }
                break;
            case 74:
                {
                alt49=4;
                }
                break;
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
                {
                alt49=5;
                }
                break;
            case 75:
                {
                alt49=6;
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2974:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral6777);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2984:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral6804);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2994:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral6831);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3004:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral6858);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3014:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral6885);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3024:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral6912);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3040:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3041:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3042:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure6947);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure6957); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3049:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3052:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3053:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3053:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3053:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3053:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3054:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXClosure7003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3063:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID||LA51_0==28||LA51_0==80) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3063:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3063:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3064:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3064:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3065:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7025);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3081:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==21) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3081:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXClosure7038); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3085:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3086:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3086:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3087:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7059);
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
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,59,FOLLOW_59_in_ruleXClosure7075); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3107:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3108:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3108:1: (lv_expression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3109:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure7096);
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

            otherlv_7=(Token)match(input,60,FOLLOW_60_in_ruleXClosure7108); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3137:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3138:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3139:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure7144);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure7154); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3146:1: ruleXShortClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3149:28: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3150:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3150:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3150:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3150:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3151:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3156:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==28||LA53_0==80) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3156:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3156:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3157:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3157:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3158:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7210);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3174:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==21) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3174:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXShortClosure7223); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3178:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3179:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3179:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3180:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7244);
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
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,59,FOLLOW_59_in_ruleXShortClosure7260); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3200:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3201:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3201:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3202:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure7281);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3226:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3227:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3228:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression7317);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression7327); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3235:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3238:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3239:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3239:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3239:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleXParenthesizedExpression7364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression7386);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleXParenthesizedExpression7397); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3264:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3265:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3266:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression7433);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression7443); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3273:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3276:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3277:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3277:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3277:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3277:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3278:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXIfExpression7489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXIfExpression7501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3291:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3292:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3292:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3293:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7522);
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

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXIfExpression7534); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3313:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3314:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3314:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3315:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7555);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                int LA54_1 = input.LA(2);

                if ( (synpred15_InternalXtend2()) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,62,FOLLOW_62_in_ruleXIfExpression7576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3336:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3337:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3337:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3338:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression7598);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3362:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3363:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3364:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression7636);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression7646); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3371:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( (lv_switch_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= '{' ( (lv_cases_4_0= ruleXCasePart ) )+ (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_switch_2_0 = null;

        EObject lv_cases_4_0 = null;

        EObject lv_default_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3374:28: ( ( () otherlv_1= 'switch' ( (lv_switch_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= '{' ( (lv_cases_4_0= ruleXCasePart ) )+ (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )? otherlv_8= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3375:1: ( () otherlv_1= 'switch' ( (lv_switch_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= '{' ( (lv_cases_4_0= ruleXCasePart ) )+ (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )? otherlv_8= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3375:1: ( () otherlv_1= 'switch' ( (lv_switch_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= '{' ( (lv_cases_4_0= ruleXCasePart ) )+ (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )? otherlv_8= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3375:2: () otherlv_1= 'switch' ( (lv_switch_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= '{' ( (lv_cases_4_0= ruleXCasePart ) )+ (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )? otherlv_8= '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3375:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3376:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXSwitchExpression7692); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3385:1: ( (lv_switch_2_0= ruleXExpressionInsideBlock ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3386:1: (lv_switch_2_0= ruleXExpressionInsideBlock )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3386:1: (lv_switch_2_0= ruleXExpressionInsideBlock )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3387:3: lv_switch_2_0= ruleXExpressionInsideBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionInsideBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression7713);
            lv_switch_2_0=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"switch",
                      		lv_switch_2_0, 
                      		"XExpressionInsideBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleXSwitchExpression7725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3407:1: ( (lv_cases_4_0= ruleXCasePart ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID||LA55_0==28||LA55_0==32||LA55_0==65||LA55_0==80) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3408:1: (lv_cases_4_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3408:1: (lv_cases_4_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3409:3: lv_cases_4_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression7746);
            	    lv_cases_4_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_4_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3425:3: (otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==64) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3425:5: otherlv_5= 'default' otherlv_6= ':' ( (lv_default_7_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,64,FOLLOW_64_in_ruleXSwitchExpression7760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleXSwitchExpression7772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3433:1: ( (lv_default_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3434:1: (lv_default_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3434:1: (lv_default_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3435:3: lv_default_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression7793);
                    lv_default_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXSwitchExpression7807); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
                  
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3463:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3464:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3465:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart7843);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart7853); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3472:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3475:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3476:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3476:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3476:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3476:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID||LA57_0==28||LA57_0==80) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3477:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3477:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3478:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart7899);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3494:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==65) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3494:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXCasePart7913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3498:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3499:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3499:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3500:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7934);
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

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleXCasePart7948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3520:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3521:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3521:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3522:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7969);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3546:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3547:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3548:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression8005);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression8015); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3555:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3558:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3559:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3559:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3559:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3559:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3560:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXForLoopExpression8061); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXForLoopExpression8073); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3573:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3574:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3574:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3575:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression8094);
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

            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleXForLoopExpression8106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3595:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3596:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3596:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3597:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression8127);
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

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXForLoopExpression8139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3617:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3618:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3618:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3619:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression8160);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3643:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3644:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3645:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression8196);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression8206); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3652:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3655:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3656:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3656:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3656:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3656:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3657:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXWhileExpression8252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXWhileExpression8264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3670:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3671:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3671:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3672:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression8285);
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

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXWhileExpression8297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3692:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3693:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3693:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3694:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression8318);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3718:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3719:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3720:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression8354);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression8364); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3727:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3730:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3731:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3731:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3731:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3731:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3732:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXDoWhileExpression8410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3741:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3742:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3742:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3743:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8431);
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

            otherlv_3=(Token)match(input,67,FOLLOW_67_in_ruleXDoWhileExpression8443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleXDoWhileExpression8455); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3767:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3768:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3768:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3769:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8476);
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

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXDoWhileExpression8488); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3797:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3798:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3799:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression8524);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression8534); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3806:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3809:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3810:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3810:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3810:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3810:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3811:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleXBlockExpression8580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3820:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=RULE_ID && LA60_0<=RULE_RICH_TEXT_START)||LA60_0==RULE_INT||LA60_0==20||LA60_0==26||LA60_0==28||(LA60_0>=49 && LA60_0<=50)||LA60_0==54||LA60_0==58||LA60_0==61||LA60_0==63||(LA60_0>=66 && LA60_0<=77)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3820:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3820:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3821:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3821:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3822:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression8602);
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

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3838:2: (otherlv_3= ';' )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==30) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3838:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleXBlockExpression8615); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleXBlockExpression8631); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3854:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3855:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3856:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock8667);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock8677); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3863:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3866:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3867:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3867:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=69 && LA61_0<=70)) ) {
                alt61=1;
            }
            else if ( ((LA61_0>=RULE_ID && LA61_0<=RULE_RICH_TEXT_START)||LA61_0==RULE_INT||LA61_0==20||LA61_0==26||LA61_0==28||(LA61_0>=49 && LA61_0<=50)||LA61_0==54||LA61_0==58||LA61_0==61||LA61_0==63||(LA61_0>=66 && LA61_0<=68)||(LA61_0>=71 && LA61_0<=77)) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3868:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock8724);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3878:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock8751);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3894:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3895:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3896:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration8786);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration8796); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3903:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3906:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3907:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3907:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3907:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3907:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3908:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3913:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==69) ) {
                alt62=1;
            }
            else if ( (LA62_0==70) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3913:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3913:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3914:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3914:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3915:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,69,FOLLOW_69_in_ruleXVariableDeclaration8849); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3929:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleXVariableDeclaration8880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                int LA63_1 = input.LA(2);

                if ( (synpred16_InternalXtend2()) ) {
                    alt63=1;
                }
                else if ( (true) ) {
                    alt63=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA63_0==28) && (synpred16_InternalXtend2())) {
                alt63=1;
            }
            else if ( (LA63_0==80) && (synpred16_InternalXtend2())) {
                alt63=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3942:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3943:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3943:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3944:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8929);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3960:2: ( (lv_name_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3961:1: (lv_name_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3961:1: (lv_name_4_0= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3962:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration8946); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3979:6: ( (lv_name_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3979:6: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3980:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3980:1: (lv_name_5_0= RULE_ID )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3981:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration8976); if (state.failed) return current;
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3997:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==38) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3997:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleXVariableDeclaration8995); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4001:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4002:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4002:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4003:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration9016);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4027:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4028:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4029:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter9054);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter9064); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4036:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4039:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4040:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4040:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4040:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4040:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==RULE_ID||LA65_1==18||LA65_1==20) ) {
                    alt65=1;
                }
            }
            else if ( (LA65_0==28||LA65_0==80) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4041:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4041:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4042:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter9110);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4058:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4059:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4059:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4060:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter9128); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4084:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4085:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4086:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall9169);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall9179); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4093:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4096:28: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4097:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4097:1: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4097:2: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( (otherlv_6= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4097:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4098:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4103:2: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==20) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4103:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall9226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4107:1: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4108:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4108:1: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4109:3: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9247);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4125:2: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==21) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4125:4: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall9260); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4129:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4130:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4130:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4131:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9281);
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
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleXFeatureCall9295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4151:3: ( (otherlv_6= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4152:1: (otherlv_6= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4152:1: (otherlv_6= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4153:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall9317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_2_0()); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:4: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4171:1: (lv_explicitOperationCall_7_0= '(' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4172:3: lv_explicitOperationCall_7_0= '('
                    {
                    lv_explicitOperationCall_7_0=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall9351); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4185:2: ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt69=3;
                    alt69 = dfa69.predict(input);
                    switch (alt69) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4185:3: ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4185:3: ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4185:4: ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4190:1: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4191:3: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall9396);
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
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4208:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4208:6: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4208:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4208:7: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4209:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4209:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4210:3: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall9424);
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

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4226:2: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop68:
                            do {
                                int alt68=2;
                                int LA68_0 = input.LA(1);

                                if ( (LA68_0==21) ) {
                                    alt68=1;
                                }


                                switch (alt68) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4226:4: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall9437); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4230:1: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4231:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4231:1: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4232:3: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall9458);
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
                            	    break loop68;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall9475); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4260:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4261:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4262:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9513);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall9523); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4269:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4273:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4273:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4273:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4273:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4274:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleXConstructorCall9569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4283:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4284:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4284:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4285:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9592);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4298:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==20) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4298:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall9605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4302:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4303:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4303:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4304:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9626);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4320:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==21) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4320:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall9639); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4324:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4325:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4325:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4326:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9660);
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
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleXConstructorCall9674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleXConstructorCall9688); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4350:1: ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt74=3;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4350:2: ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4350:2: ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4350:3: ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4355:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4356:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9720);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4373:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4373:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4373:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4373:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4374:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4374:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4375:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9748);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4391:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==21) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4391:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall9761); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4395:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4396:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4396:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4397:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9782);
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
                    	    break loop73;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall9799); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4425:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4426:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4427:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9835);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9845); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4434:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4437:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4438:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4438:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4438:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4438:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4439:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4444:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==72) ) {
                alt75=1;
            }
            else if ( (LA75_0==73) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4444:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXBooleanLiteral9892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4449:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4449:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4450:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4450:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4451:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,73,FOLLOW_73_in_ruleXBooleanLiteral9916); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4473:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4474:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9966);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9976); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4481:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4484:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4486:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleXNullLiteral10022); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4503:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4504:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4505:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral10058);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral10068); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4512:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4515:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4516:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4516:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4516:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4516:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4517:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4522:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4523:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4523:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4524:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral10119); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4548:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4549:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4550:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral10160);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral10170); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4557:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4560:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4561:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4561:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4561:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4561:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4562:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleXTypeLiteral10216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXTypeLiteral10228); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4575:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4576:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4576:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4577:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral10251);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXTypeLiteral10263); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4602:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4603:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4604:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10299);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression10309); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4611:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4614:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4615:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4615:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4615:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4615:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4616:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleXThrowExpression10355); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4625:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4626:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4626:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4627:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression10376);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4651:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4652:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4653:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10412);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10422); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4660:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4663:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4664:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4664:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4664:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4664:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4665:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,77,FOLLOW_77_in_ruleXTryCatchFinallyExpression10468); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4674:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4675:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4675:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4676:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10489);
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:2: ( ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==79) ) {
                alt78=1;
            }
            else if ( (LA78_0==78) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:3: ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:3: ( ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:4: ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:4: ( ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==79) ) {
                            int LA76_2 = input.LA(2);

                            if ( (synpred20_InternalXtend2()) ) {
                                alt76=1;
                            }


                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:5: ( ( ruleXCatchClause ) )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4697:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4698:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10522);
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
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==78) ) {
                        int LA77_1 = input.LA(2);

                        if ( (synpred21_InternalXtend2()) ) {
                            alt77=1;
                        }
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,78,FOLLOW_78_in_ruleXTryCatchFinallyExpression10544); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4719:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4720:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4720:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4721:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10566);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4738:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4738:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4738:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,78,FOLLOW_78_in_ruleXTryCatchFinallyExpression10588); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4742:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4743:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4743:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4744:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10609);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4768:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4769:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4770:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10647);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10657); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4777:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4780:28: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4781:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4781:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4781:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,79,FOLLOW_79_in_ruleXCatchClause10694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleXCatchClause10706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4789:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4790:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4790:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4791:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10727);
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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleXCatchClause10739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4811:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4812:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4812:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4813:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10760);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4837:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4838:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4839:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10797);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10808); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4846:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4849:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4850:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4850:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4850:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10848); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4857:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==18) ) {
                    int LA79_2 = input.LA(2);

                    if ( (LA79_2==RULE_ID) ) {
                        int LA79_3 = input.LA(3);

                        if ( (synpred22_InternalXtend2()) ) {
                            alt79=1;
                        }


                    }


                }


                switch (alt79) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4857:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4857:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4857:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName10876); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10892); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop79;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4880:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4881:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4882:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10939);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10949); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4889:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4892:28: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4893:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4893:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            else if ( (LA80_0==28||LA80_0==80) ) {
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4894:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10996);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4904:5: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11023);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4920:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4921:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4922:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11058);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef11068); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4929:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4932:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==28) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4933:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleXFunctionTypeRef11106); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4937:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4938:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4938:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4939:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11127);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4955:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==21) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4955:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXFunctionTypeRef11140); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4959:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4960:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4960:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4961:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11161);
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
                    	    break loop81;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleXFunctionTypeRef11175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,80,FOLLOW_80_in_ruleXFunctionTypeRef11189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4985:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4986:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4986:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4987:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11210);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5011:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5012:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5013:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11246);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11256); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5020:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5023:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5024:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5024:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5024:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5024:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5025:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5025:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5026:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11304);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt84=2;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleJvmParameterizedTypeReference11325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5044:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5045:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5045:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5046:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11347);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5062:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==21) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5062:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleJvmParameterizedTypeReference11360); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5066:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5067:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5067:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5068:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11381);
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
                    	    break loop83;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleJvmParameterizedTypeReference11395); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5096:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5097:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5098:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11433);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11443); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5105:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5108:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5109:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5109:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_ID||LA85_0==28||LA85_0==80) ) {
                alt85=1;
            }
            else if ( (LA85_0==81) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5110:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11490);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5120:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11517);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5136:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5137:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5138:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11552);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11562); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5145:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5148:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5149:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5149:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5149:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5149:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5150:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,81,FOLLOW_81_in_ruleJvmWildcardTypeReference11608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5159:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt86=3;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==24) ) {
                alt86=1;
            }
            else if ( (LA86_0==83) ) {
                alt86=2;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5159:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5159:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5160:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5160:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5161:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11630);
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5178:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5178:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5179:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5179:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5180:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11657);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5204:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5205:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5206:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11695);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11705); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5213:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5216:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5217:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5217:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5217:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleJvmUpperBound11742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5221:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5222:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5222:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5223:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11763);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5247:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5248:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5249:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11799);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11809); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5256:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5259:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5260:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5260:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5260:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleJvmUpperBoundAnded11846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5264:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5265:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5265:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5266:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11867);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5290:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5291:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5292:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11903);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11913); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5299:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5302:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5303:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5303:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5303:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleJvmLowerBound11950); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5307:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5308:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5308:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5309:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11971);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5333:1: entryRuleJvmTypeParameter returns [EObject current=null] : iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF ;
    public final EObject entryRuleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5334:2: (iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5335:2: iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter12007);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter12017); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5342:1: ruleJvmTypeParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_constraints_1_0 = null;

        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5345:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5346:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5346:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5346:2: ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5346:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5347:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5347:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5348:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmTypeParameter12059); if (state.failed) return current;
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5364:2: ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5364:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5364:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5364:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5364:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5365:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5365:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5366:3: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter12087);
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

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5382:2: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==82) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5383:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5383:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5384:3: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter12108);
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
                    	    break loop87;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5401:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5401:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5402:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5402:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5403:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmLowerBoundParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter12137);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1451:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1452:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1452:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1453:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1453:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1454:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalXtend22933);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1579:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1580:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1580:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1581:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1581:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1582:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalXtend23281);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1680:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1681:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1681:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1682:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1682:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1683:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalXtend23540);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1781:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1782:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1782:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1783:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1783:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1784:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalXtend23799);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1889:6: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1890:1: 
        {
        }

        match(input,44,FOLLOW_44_in_synpred5_InternalXtend24075); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalXtend2

    // $ANTLR start synpred6_InternalXtend2
    public final void synpred6_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:10: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1918:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1918:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1919:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1919:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1920:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalXtend24148);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2039:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2040:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2040:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2041:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2041:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2042:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalXtend24467);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2147:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2149:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2149:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2150:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalXtend24747);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2255:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2256:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2256:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2257:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2257:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2258:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalXtend25027);
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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:4: ( () 'as' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:5: () 'as'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:5: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2489:1: 
        {
        }

        match(input,55,FOLLOW_55_in_synpred10_InternalXtend25621); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalXtend2

    // $ANTLR start synpred11_InternalXtend2
    public final void synpred11_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:4: ( ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:5: ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:5: ( () '.' ( ( RULE_ID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:6: () '.' ( ( RULE_ID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:6: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2549:1: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred11_InternalXtend25775); if (state.failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2550:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2551:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2551:1: ( RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2552:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred11_InternalXtend25783); if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalXtend25790);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalXtend2

    // $ANTLR start synpred12_InternalXtend2
    public final void synpred12_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2605:10: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2606:1: 
        {
        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2606:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt89=3;
        switch ( input.LA(1) ) {
        case 18:
            {
            alt89=1;
            }
            break;
        case 56:
            {
            alt89=2;
            }
            break;
        case 57:
            {
            alt89=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 89, 0, input);

            throw nvae;
        }

        switch (alt89) {
            case 1 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2606:4: '.'
                {
                match(input,18,FOLLOW_18_in_synpred12_InternalXtend25890); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2608:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2608:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2609:1: ( '?.' )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2609:1: ( '?.' )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2610:2: '?.'
                {
                match(input,56,FOLLOW_56_in_synpred12_InternalXtend25904); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2615:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2615:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2616:1: ( '*.' )
                {
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2616:1: ( '*.' )
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2617:2: '*.'
                {
                match(input,57,FOLLOW_57_in_synpred12_InternalXtend25924); if (state.failed) return ;

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
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2724:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2725:1: ( '(' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2725:1: ( '(' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2726:2: '('
        {
        match(input,28,FOLLOW_28_in_synpred13_InternalXtend26148); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalXtend2

    // $ANTLR start synpred14_InternalXtend2
    public final void synpred14_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:4: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2746:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2746:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2747:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred14_InternalXtend26194);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalXtend2

    // $ANTLR start synpred15_InternalXtend2
    public final void synpred15_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:4: ( 'else' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3331:6: 'else'
        {
        match(input,62,FOLLOW_62_in_synpred15_InternalXtend27568); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalXtend2

    // $ANTLR start synpred16_InternalXtend2
    public final void synpred16_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:5: ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:5: ( ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:6: ( ( ruleJvmTypeReference ) ) ( ( RULE_ID ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3933:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3934:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3934:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3935:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred16_InternalXtend28898);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3937:2: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3938:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3938:1: ( RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3939:1: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred16_InternalXtend28907); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalXtend2

    // $ANTLR start synpred17_InternalXtend2
    public final void synpred17_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4164:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4165:1: ( '(' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4165:1: ( '(' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4166:2: '('
        {
        match(input,28,FOLLOW_28_in_synpred17_InternalXtend29333); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalXtend2

    // $ANTLR start synpred18_InternalXtend2
    public final void synpred18_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4185:4: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4186:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4186:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4187:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred18_InternalXtend29379);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalXtend2

    // $ANTLR start synpred19_InternalXtend2
    public final void synpred19_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4350:3: ( ( ruleXShortClosure ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4351:1: ( ruleXShortClosure )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4351:1: ( ruleXShortClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4352:1: ruleXShortClosure
        {
        pushFollow(FOLLOW_ruleXShortClosure_in_synpred19_InternalXtend29703);
        ruleXShortClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalXtend2

    // $ANTLR start synpred20_InternalXtend2
    public final void synpred20_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4692:5: ( ( ruleXCatchClause ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4693:1: ( ruleXCatchClause )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4693:1: ( ruleXCatchClause )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4694:1: ruleXCatchClause
        {
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred20_InternalXtend210505);
        ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalXtend2

    // $ANTLR start synpred21_InternalXtend2
    public final void synpred21_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:5: ( 'finally' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4714:7: 'finally'
        {
        match(input,78,FOLLOW_78_in_synpred21_InternalXtend210536); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalXtend2

    // $ANTLR start synpred22_InternalXtend2
    public final void synpred22_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4857:3: ( '.' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4858:2: '.'
        {
        match(input,18,FOLLOW_18_in_synpred22_InternalXtend210867); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalXtend2

    // $ANTLR start synpred23_InternalXtend2
    public final void synpred23_InternalXtend2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:4: ( '<' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:5039:6: '<'
        {
        match(input,20,FOLLOW_20_in_synpred23_InternalXtend211317); if (state.failed) return ;

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


    protected DFA46 dfa46 = new DFA46(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA84 dfa84 = new DFA84(this);
    static final String DFA46_eotS =
        "\76\uffff";
    static final String DFA46_eofS =
        "\1\2\75\uffff";
    static final String DFA46_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA46_maxS =
        "\1\120\1\0\74\uffff";
    static final String DFA46_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA46_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA46_transitionS = {
            "\7\2\7\uffff\5\2\3\uffff\2\2\1\1\2\2\1\uffff\1\2\6\uffff\24"+
            "\2\1\uffff\25\2",
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
            return "2724:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend2()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_1);
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
    static final String DFA45_eotS =
        "\34\uffff";
    static final String DFA45_eofS =
        "\34\uffff";
    static final String DFA45_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA45_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA45_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA45_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\3\5\2\uffff\1\5\11\uffff\1\5\5\uffff\1\5\1\uffff\1\2\1"+
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "2745:2: ( ( ( ( ruleXShortClosure ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_0 = input.LA(1);

                         
                        int index45_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA45_0==RULE_ID) ) {s = 1;}

                        else if ( (LA45_0==28) ) {s = 2;}

                        else if ( (LA45_0==80) && (synpred14_InternalXtend2())) {s = 3;}

                        else if ( (LA45_0==59) && (synpred14_InternalXtend2())) {s = 4;}

                        else if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_RICH_TEXT_START)||LA45_0==RULE_INT||LA45_0==20||LA45_0==26||(LA45_0>=49 && LA45_0<=50)||LA45_0==54||LA45_0==58||LA45_0==61||LA45_0==63||(LA45_0>=66 && LA45_0<=68)||(LA45_0>=71 && LA45_0<=77)) ) {s = 5;}

                        else if ( (LA45_0==29) ) {s = 27;}

                         
                        input.seek(index45_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_2 = input.LA(1);

                         
                        int index45_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index45_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA70_eotS =
        "\76\uffff";
    static final String DFA70_eofS =
        "\1\2\75\uffff";
    static final String DFA70_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA70_maxS =
        "\1\120\1\0\74\uffff";
    static final String DFA70_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA70_transitionS = {
            "\7\2\7\uffff\5\2\3\uffff\2\2\1\1\2\2\1\uffff\1\2\6\uffff\24"+
            "\2\1\uffff\25\2",
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

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "4164:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA70_1 = input.LA(1);

                         
                        int index70_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend2()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 70, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\34\uffff";
    static final String DFA69_eofS =
        "\34\uffff";
    static final String DFA69_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA69_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA69_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA69_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\1\3\5\2\uffff\1\5\11\uffff\1\5\5\uffff\1\5\1\uffff\1\2\1"+
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

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "4185:2: ( ( ( ( ruleXShortClosure ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_0 = input.LA(1);

                         
                        int index69_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA69_0==RULE_ID) ) {s = 1;}

                        else if ( (LA69_0==28) ) {s = 2;}

                        else if ( (LA69_0==80) && (synpred18_InternalXtend2())) {s = 3;}

                        else if ( (LA69_0==59) && (synpred18_InternalXtend2())) {s = 4;}

                        else if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_RICH_TEXT_START)||LA69_0==RULE_INT||LA69_0==20||LA69_0==26||(LA69_0>=49 && LA69_0<=50)||LA69_0==54||LA69_0==58||LA69_0==61||LA69_0==63||(LA69_0>=66 && LA69_0<=68)||(LA69_0>=71 && LA69_0<=77)) ) {s = 5;}

                        else if ( (LA69_0==29) ) {s = 27;}

                         
                        input.seek(index69_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA69_2 = input.LA(1);

                         
                        int index69_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index69_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA74_eotS =
        "\34\uffff";
    static final String DFA74_eofS =
        "\34\uffff";
    static final String DFA74_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA74_maxS =
        "\1\120\2\0\31\uffff";
    static final String DFA74_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA74_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA74_transitionS = {
            "\1\1\3\5\2\uffff\1\5\11\uffff\1\5\5\uffff\1\5\1\uffff\1\2\1"+
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

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "4350:1: ( ( ( ( ruleXShortClosure ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_0 = input.LA(1);

                         
                        int index74_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA74_0==RULE_ID) ) {s = 1;}

                        else if ( (LA74_0==28) ) {s = 2;}

                        else if ( (LA74_0==80) && (synpred19_InternalXtend2())) {s = 3;}

                        else if ( (LA74_0==59) && (synpred19_InternalXtend2())) {s = 4;}

                        else if ( ((LA74_0>=RULE_STRING && LA74_0<=RULE_RICH_TEXT_START)||LA74_0==RULE_INT||LA74_0==20||LA74_0==26||(LA74_0>=49 && LA74_0<=50)||LA74_0==54||LA74_0==58||LA74_0==61||LA74_0==63||(LA74_0>=66 && LA74_0<=68)||(LA74_0>=71 && LA74_0<=77)) ) {s = 5;}

                        else if ( (LA74_0==29) ) {s = 27;}

                         
                        input.seek(index74_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA74_1 = input.LA(1);

                         
                        int index74_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index74_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA74_2 = input.LA(1);

                         
                        int index74_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalXtend2()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index74_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA84_eotS =
        "\100\uffff";
    static final String DFA84_eofS =
        "\1\2\77\uffff";
    static final String DFA84_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA84_maxS =
        "\1\122\1\0\76\uffff";
    static final String DFA84_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA84_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA84_transitionS = {
            "\7\2\7\uffff\2\2\1\1\2\2\2\uffff\6\2\1\uffff\1\2\6\uffff\24"+
            "\2\1\uffff\25\2\1\uffff\1\2",
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

    static final short[] DFA84_eot = DFA.unpackEncodedString(DFA84_eotS);
    static final short[] DFA84_eof = DFA.unpackEncodedString(DFA84_eofS);
    static final char[] DFA84_min = DFA.unpackEncodedStringToUnsignedChars(DFA84_minS);
    static final char[] DFA84_max = DFA.unpackEncodedStringToUnsignedChars(DFA84_maxS);
    static final short[] DFA84_accept = DFA.unpackEncodedString(DFA84_acceptS);
    static final short[] DFA84_special = DFA.unpackEncodedString(DFA84_specialS);
    static final short[][] DFA84_transition;

    static {
        int numStates = DFA84_transitionS.length;
        DFA84_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA84_transition[i] = DFA.unpackEncodedString(DFA84_transitionS[i]);
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = DFA84_eot;
            this.eof = DFA84_eof;
            this.min = DFA84_min;
            this.max = DFA84_max;
            this.accept = DFA84_accept;
            this.special = DFA84_special;
            this.transition = DFA84_transition;
        }
        public String getDescription() {
            return "5039:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXtend2()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleFile123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFile144 = new BitSet(new long[]{0x0000000000920002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile167 = new BitSet(new long[]{0x0000000000920002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleFile189 = new BitSet(new long[]{0x0000000000900002L});
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
    public static final BitSet FOLLOW_20_in_ruleClass511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass532 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleClass545 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass566 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleClass580 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleClass594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClass611 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_24_in_ruleClass629 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass650 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleClass665 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass686 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleClass700 = new BitSet(new long[]{0x0000000018100010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleMember_in_ruleClass721 = new BitSet(new long[]{0x0000000018100010L,0x0000000000010000L});
    public static final BitSet FOLLOW_27_in_ruleClass734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMember826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFunction908 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction929 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleFunction942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction963 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleFunction977 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFunction1000 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction1018 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFunction1035 = new BitSet(new long[]{0x0000000030000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1057 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_21_in_ruleFunction1070 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1091 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29_in_ruleFunction1107 = new BitSet(new long[]{0xA4460000541004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFunction1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleFunction1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral1184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_ruleXStringLiteral1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString1315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_in_ruleRichString1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_ruleRichString1420 = new BitSet(new long[]{0xA4460004941004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString1441 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString1463 = new BitSet(new long[]{0xA4460004941004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString1484 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart1544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralStart1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd1748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralEnd1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalRichString1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleInternalRichString1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString1955 = new BitSet(new long[]{0xA4460004941004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleInternalRichString1977 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString1998 = new BitSet(new long[]{0xA4460004941004F2L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart2037 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringPart2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringPart2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_ruleRichStringPart2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop2183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringForLoop2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleRichStringForLoop2239 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop2260 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleRichStringForLoop2272 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop2293 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop2314 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleRichStringForLoop2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf2362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringIf2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleRichStringIf2418 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringIf2439 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf2460 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf2481 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_35_in_ruleRichStringIf2495 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf2516 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleRichStringIf2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf2566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringElseIf2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleRichStringElseIf2613 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringElseIf2634 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression2691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment2781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXAssignment2846 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment2862 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment2912 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment2965 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign3028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpSingleAssign3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign3116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign3127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMultiAssign3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression3203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3260 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression3313 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression3336 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpOr3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression3462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3519 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression3572 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression3595 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpAnd3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression3721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3778 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression3831 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression3854 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpEquality3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpEquality3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression4001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4058 = new BitSet(new long[]{0x0000700000500002L});
    public static final BitSet FOLLOW_44_in_ruleXRelationalExpression4094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression4119 = new BitSet(new long[]{0x0000700000500002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression4180 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression4203 = new BitSet(new long[]{0x0000700000500002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpCompare4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpCompare4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpCompare4330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpCompare4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression4389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression4399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4446 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression4499 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression4522 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther4561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther4572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpOther4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther4629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression4669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4726 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression4779 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression4802 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpAdd4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpAdd4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression4949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5006 = new BitSet(new long[]{0x0038000000080002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression5059 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression5082 = new BitSet(new long[]{0x0038000000080002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti5121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpMulti5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpMulti5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpMulti5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpMulti5227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation5267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation5277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation5335 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation5385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpUnary5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpUnary5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpUnary5508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression5548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression5605 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXCastedExpression5640 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression5663 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall5701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall5758 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_18_in_ruleXMemberFeatureCall5807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall5827 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall5843 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall5865 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_18_in_ruleXMemberFeatureCall5951 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_56_in_ruleXMemberFeatureCall5975 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_57_in_ruleXMemberFeatureCall6012 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall6041 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6062 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall6075 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall6096 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall6110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall6132 = new BitSet(new long[]{0x0300000010040002L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall6166 = new BitSet(new long[]{0xAC460000341004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall6211 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6239 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall6252 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall6273 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall6290 = new BitSet(new long[]{0x0300000000040002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression6331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression6442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression6469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression6496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression6550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression6577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression6604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression6631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression6685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral6720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral6730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral6777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral6831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral6912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure6947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure6957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXClosure7003 = new BitSet(new long[]{0x0800000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7025 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXClosure7038 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure7059 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_59_in_ruleXClosure7075 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure7096 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleXClosure7108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure7144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure7154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7210 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXShortClosure7223 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure7244 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_59_in_ruleXShortClosure7260 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure7281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression7317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression7327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXParenthesizedExpression7364 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression7386 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXParenthesizedExpression7397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression7433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXIfExpression7489 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXIfExpression7501 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7522 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXIfExpression7534 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7555 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXIfExpression7576 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression7598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression7636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression7646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXSwitchExpression7692 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXSwitchExpression7713 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXSwitchExpression7725 = new BitSet(new long[]{0x0000000110000010L,0x0000000000010002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression7746 = new BitSet(new long[]{0x0000000118000010L,0x0000000000010003L});
    public static final BitSet FOLLOW_64_in_ruleXSwitchExpression7760 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXSwitchExpression7772 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression7793 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleXSwitchExpression7807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart7843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart7853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart7899 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXCasePart7913 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7934 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXCasePart7948 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression8005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression8015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXForLoopExpression8061 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXForLoopExpression8073 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression8094 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXForLoopExpression8106 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression8127 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXForLoopExpression8139 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression8160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression8196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression8206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXWhileExpression8252 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXWhileExpression8264 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression8285 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXWhileExpression8297 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression8318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression8354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression8364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXDoWhileExpression8410 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleXDoWhileExpression8443 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXDoWhileExpression8455 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression8476 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXDoWhileExpression8488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression8524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression8534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXBlockExpression8580 = new BitSet(new long[]{0xA44600001C1004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression8602 = new BitSet(new long[]{0xA44600005C1004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_30_in_ruleXBlockExpression8615 = new BitSet(new long[]{0xA44600001C1004F0L,0x0000000000003FFCL});
    public static final BitSet FOLLOW_27_in_ruleXBlockExpression8631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock8667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock8677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock8724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock8751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration8786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration8796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXVariableDeclaration8849 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_70_in_ruleXVariableDeclaration8880 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8929 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration8946 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration8976 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleXVariableDeclaration8995 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration9016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter9054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter9064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter9110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter9128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall9169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall9179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall9226 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9247 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall9260 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall9281 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXFeatureCall9295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall9317 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall9351 = new BitSet(new long[]{0xAC460000341004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall9396 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall9424 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall9437 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall9458 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall9475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall9523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXConstructorCall9569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9592 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall9605 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9626 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall9639 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9660 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleXConstructorCall9674 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall9688 = new BitSet(new long[]{0xAC460000341004F0L,0x0000000000013F9CL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9720 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9748 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall9761 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9782 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall9799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXBooleanLiteral9892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleXBooleanLiteral9916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleXNullLiteral10022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral10058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral10068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral10160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral10170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleXTypeLiteral10216 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXTypeLiteral10228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral10251 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXTypeLiteral10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression10309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleXThrowExpression10355 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression10376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleXTryCatchFinallyExpression10468 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10489 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10522 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_78_in_ruleXTryCatchFinallyExpression10544 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleXTryCatchFinallyExpression10588 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleXCatchClause10694 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXCatchClause10706 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10727 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXCatchClause10739 = new BitSet(new long[]{0xA4460000141004F0L,0x0000000000003F9CL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10848 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName10876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10892 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef11068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXFunctionTypeRef11106 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11127 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_21_in_ruleXFunctionTypeRef11140 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11161 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_29_in_ruleXFunctionTypeRef11175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleXFunctionTypeRef11189 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11304 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleJvmParameterizedTypeReference11325 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11347 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleJvmParameterizedTypeReference11360 = new BitSet(new long[]{0x0000000010000010L,0x0000000000030000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11381 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleJvmParameterizedTypeReference11395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleJvmWildcardTypeReference11608 = new BitSet(new long[]{0x0000000001000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleJvmUpperBound11742 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleJvmUpperBoundAnded11846 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleJvmLowerBound11950 = new BitSet(new long[]{0x0000000010000010L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter12007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter12017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmTypeParameter12059 = new BitSet(new long[]{0x0000000001000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter12087 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter12108 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter12137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalXtend22933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalXtend23281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalXtend23540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalXtend23799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred5_InternalXtend24075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalXtend24148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalXtend24467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalXtend24747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalXtend25027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred10_InternalXtend25621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred11_InternalXtend25775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred11_InternalXtend25783 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalXtend25790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred12_InternalXtend25890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred12_InternalXtend25904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred12_InternalXtend25924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred13_InternalXtend26148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred14_InternalXtend26194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred15_InternalXtend27568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred16_InternalXtend28898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred16_InternalXtend28907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred17_InternalXtend29333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred18_InternalXtend29379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_synpred19_InternalXtend29703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred20_InternalXtend210505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_synpred21_InternalXtend210536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred22_InternalXtend210867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred23_InternalXtend211317 = new BitSet(new long[]{0x0000000000000002L});

}
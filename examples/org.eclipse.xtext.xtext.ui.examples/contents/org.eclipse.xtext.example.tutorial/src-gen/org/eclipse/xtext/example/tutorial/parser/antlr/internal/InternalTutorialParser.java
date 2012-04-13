package org.eclipse.xtext.example.tutorial.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.example.tutorial.services.TutorialGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTutorialParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'entity'", "'extends'", "'{'", "'}'", "':'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=8;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=5;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int RULE_DECIMAL=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;

    // delegates
    // delegators


        public InternalTutorialParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTutorialParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTutorialParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g"; }



     	private TutorialGrammarAccess grammarAccess;
     	
        public InternalTutorialParser(TokenStream input, TutorialGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DomainModelFile";	
       	}
       	
       	@Override
       	protected TutorialGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDomainModelFile"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:67:1: entryRuleDomainModelFile returns [EObject current=null] : iv_ruleDomainModelFile= ruleDomainModelFile EOF ;
    public final EObject entryRuleDomainModelFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModelFile = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:68:2: (iv_ruleDomainModelFile= ruleDomainModelFile EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:69:2: iv_ruleDomainModelFile= ruleDomainModelFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainModelFileRule()); 
            }
            pushFollow(FOLLOW_ruleDomainModelFile_in_entryRuleDomainModelFile75);
            iv_ruleDomainModelFile=ruleDomainModelFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainModelFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomainModelFile85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainModelFile"


    // $ANTLR start "ruleDomainModelFile"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:76:1: ruleDomainModelFile returns [EObject current=null] : ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_entities_3_0= ruleEntity ) )* ) ;
    public final EObject ruleDomainModelFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_entities_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:79:28: ( ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_entities_3_0= ruleEntity ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:1: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_entities_3_0= ruleEntity ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:1: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_entities_3_0= ruleEntity ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_entities_3_0= ruleEntity ) )*
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:4: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) )
                    {
                    otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleDomainModelFile123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDomainModelFileAccess().getPackageKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:84:1: ( (lv_name_1_0= ruleQualifiedName ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:85:1: (lv_name_1_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:85:1: (lv_name_1_0= ruleQualifiedName )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:86:3: lv_name_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDomainModelFileAccess().getNameQualifiedNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDomainModelFile144);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDomainModelFileRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:102:4: ( (lv_imports_2_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:103:1: (lv_imports_2_0= ruleImport )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainModelFileAccess().getImportsImportParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleDomainModelFile167);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainModelFileRule());
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:120:3: ( (lv_entities_3_0= ruleEntity ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:121:1: (lv_entities_3_0= ruleEntity )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:121:1: (lv_entities_3_0= ruleEntity )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:122:3: lv_entities_3_0= ruleEntity
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainModelFileAccess().getEntitiesEntityParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEntity_in_ruleDomainModelFile189);
            	    lv_entities_3_0=ruleEntity();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainModelFileRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"entities",
            	              		lv_entities_3_0, 
            	              		"Entity");
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
    // $ANTLR end "ruleDomainModelFile"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:146:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:147:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:148:2: iv_ruleImport= ruleImport EOF
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:155:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:158:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:159:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport273); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:163:1: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:164:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:164:1: (lv_importedNamespace_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:165:3: lv_importedNamespace_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleImport294);
            lv_importedNamespace_1_0=ruleQualifiedName();

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
                      		"QualifiedName");
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


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:189:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:190:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:191:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntityRule()); 
            }
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity330);
            iv_ruleEntity=ruleEntity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity340); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:198:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_superType_3_0 = null;

        EObject lv_features_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:201:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:202:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:202:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:202:3: otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleEntity377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:206:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:207:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:207:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:208:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEntityAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleEntity398);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEntityRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:224:2: (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:224:4: otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmTypeReference ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleEntity411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:228:1: ( (lv_superType_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:229:1: (lv_superType_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:229:1: (lv_superType_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:230:3: lv_superType_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEntityAccess().getSuperTypeJvmTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleEntity432);
                    lv_superType_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEntityRule());
                      	        }
                             		set(
                             			current, 
                             			"superType",
                              		lv_superType_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleEntity446); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:250:1: ( (lv_features_5_0= ruleProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:251:1: (lv_features_5_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:251:1: (lv_features_5_0= ruleProperty )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:252:3: lv_features_5_0= ruleProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEntityAccess().getFeaturesPropertyParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity467);
            	    lv_features_5_0=ruleProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEntityRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_5_0, 
            	              		"Property");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleEntity480); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:280:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:281:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:282:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty516);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty526); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:289:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:292:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:293:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:293:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:293:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:293:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:294:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:294:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:295:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getNameValidIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleProperty572);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleProperty584); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:315:1: ( (lv_type_2_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:316:1: (lv_type_2_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:316:1: (lv_type_2_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:317:3: lv_type_2_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleProperty605);
            lv_type_2_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:341:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:342:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:343:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression641);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression651); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:350:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:353:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:355:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression697);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:371:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:372:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:373:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment731);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment741); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:380:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:383:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==20) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=RULE_STRING && LA7_1<=RULE_ID)||(LA7_1>=17 && LA7_1<=19)||(LA7_1>=21 && LA7_1<=47)||(LA7_1>=49 && LA7_1<=73)) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_DECIMAL)||LA7_0==17||LA7_0==30||(LA7_0>=33 && LA7_0<=34)||LA7_0==39||LA7_0==45||LA7_0==47||LA7_0==51||LA7_0==53||(LA7_0>=56 && LA7_0<=58)||LA7_0==61||(LA7_0>=63 && LA7_0<=70)) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:384:3: ()
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:385:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:390:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:391:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:391:1: ( ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:392:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment799);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment815);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:413:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:414:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:414:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:415:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment835);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:432:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:432:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:433:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment865);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==21) ) {
                        int LA6_1 = input.LA(2);

                        if ( (synpred1_InternalTutorial()) ) {
                            alt6=1;
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:446:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:446:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:446:7: ()
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:447:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:452:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:453:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:453:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:454:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment918);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:467:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:468:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:468:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:469:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment941);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:493:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:494:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:495:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign981);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign992); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:502:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:505:28: (kw= '=' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:507:2: kw= '='
            {
            kw=(Token)match(input,20,FOLLOW_20_in_ruleOpSingleAssign1029); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:520:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:521:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:522:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1069);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1080); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:529:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:532:28: (kw= '+=' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:534:2: kw= '+='
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleOpMultiAssign1117); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:547:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:548:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:549:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1156);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1166); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:556:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:559:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:560:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:560:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:561:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1213);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred2_InternalTutorial()) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:574:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:574:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:574:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:575:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:580:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:581:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:581:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:582:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1266);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:595:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:596:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:596:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:597:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1289);
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
            	    break loop8;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:621:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:622:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:623:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1328);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1339); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:630:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:633:28: (kw= '||' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:2: kw= '||'
            {
            kw=(Token)match(input,22,FOLLOW_22_in_ruleOpOr1376); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:648:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:649:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:650:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1415);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1425); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:657:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:660:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:661:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:661:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:662:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1472);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred3_InternalTutorial()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:675:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:675:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:675:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:676:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:681:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:682:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:682:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:683:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1525);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:696:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:697:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:697:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:698:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1548);
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
            	    break loop9;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:722:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:723:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:724:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1587);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1598); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:731:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:734:28: (kw= '&&' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:736:2: kw= '&&'
            {
            kw=(Token)match(input,23,FOLLOW_23_in_ruleOpAnd1635); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:749:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:750:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:751:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1674);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression1684); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:758:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:761:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:762:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:762:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1731);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred4_InternalTutorial()) ) {
                        alt10=1;
                    }


                }
                else if ( (LA10_0==25) ) {
                    int LA10_3 = input.LA(2);

                    if ( (synpred4_InternalTutorial()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:776:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:776:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:776:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:777:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:782:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:783:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:783:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:784:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1784);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:797:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:798:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:798:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:799:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1807);
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
            	    break loop10;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:823:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:824:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:825:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality1846);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality1857); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:832:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:835:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:836:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:836:1: (kw= '==' | kw= '!=' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            else if ( (LA11_0==25) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:837:2: kw= '=='
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpEquality1895); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:844:2: kw= '!='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpEquality1914); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:857:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:858:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:859:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1954);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression1964); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:866:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:869:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:870:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:870:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:871:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2011);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop12:
            do {
                int alt12=3;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    int LA12_2 = input.LA(2);

                    if ( (synpred5_InternalTutorial()) ) {
                        alt12=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA12_3 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA12_4 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA12_5 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA12_6 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:881:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:881:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:881:6: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:882:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleXRelationalExpression2047); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:891:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:892:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:892:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:893:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2070);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
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


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:915:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:915:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:915:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:916:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:921:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:922:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:922:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:923:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2131);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:936:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:937:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:937:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:938:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2154);
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
            	    break loop12;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:962:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:963:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:964:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2194);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2205); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:971:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:974:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:975:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:975:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt13=1;
                }
                break;
            case 28:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            case 30:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:976:2: kw= '>='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare2243); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:983:2: kw= '<='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpCompare2262); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:990:2: kw= '>'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare2281); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:997:2: kw= '<'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpCompare2300); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1010:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1011:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1012:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2340);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2350); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1019:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1022:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1023:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1023:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1024:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2397);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred7_InternalTutorial()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==32) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred7_InternalTutorial()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1037:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1037:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1037:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1038:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1043:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1044:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1044:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1045:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2450);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1058:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1059:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1059:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1060:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2473);
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
            	    break loop14;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1084:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1085:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1086:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2512);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2523); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1093:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1096:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1097:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1097:1: (kw= '->' | kw= '..' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1098:2: kw= '->'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpOther2561); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1105:2: kw= '..'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpOther2580); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1118:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1119:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1120:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2620);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2630); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1127:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1130:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1131:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1131:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1132:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2677);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred8_InternalTutorial()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==34) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred8_InternalTutorial()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1145:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1145:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1145:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1146:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1151:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1152:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1152:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1153:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2730);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1166:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1167:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1167:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1168:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2753);
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
            	    break loop16;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1192:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1193:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1194:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2792);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2803); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1201:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1204:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1205:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1205:1: (kw= '+' | kw= '-' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            else if ( (LA17_0==34) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1206:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpAdd2841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1213:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpAdd2860); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1227:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1228:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2900);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2910); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1235:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1238:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1239:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1239:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1240:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2957);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop18:
            do {
                int alt18=2;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    int LA18_2 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA18_3 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA18_4 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA18_5 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt18=1;
                    }


                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1253:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1253:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1253:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1254:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1259:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1260:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1260:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1261:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3010);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1274:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1275:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1275:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1276:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3033);
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
            	    break loop18;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1300:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1301:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1302:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3072);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3083); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1309:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1312:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1313:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1313:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt19=1;
                }
                break;
            case 36:
                {
                alt19=2;
                }
                break;
            case 37:
                {
                alt19=3;
                }
                break;
            case 38:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1314:2: kw= '*'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti3121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1321:2: kw= '**'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti3140); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1328:2: kw= '/'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti3159); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1335:2: kw= '%'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpMulti3178); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1348:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1349:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1350:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3218);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3228); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1357:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1360:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=33 && LA20_0<=34)||LA20_0==39) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_ID)||LA20_0==17||LA20_0==30||LA20_0==45||LA20_0==47||LA20_0==51||LA20_0==53||(LA20_0>=56 && LA20_0<=58)||LA20_0==61||(LA20_0>=63 && LA20_0<=70)) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:3: ()
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1362:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1367:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1368:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1368:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1369:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3286);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1382:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1383:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1383:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1384:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3307);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1402:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3336);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1418:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1419:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1420:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3372);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3383); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1427:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1430:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1431:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1431:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt21=1;
                }
                break;
            case 34:
                {
                alt21=2;
                }
                break;
            case 33:
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1432:2: kw= '!'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpUnary3421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1439:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpUnary3440); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1446:2: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3459); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1459:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1460:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1461:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3499);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3509); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1468:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1471:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1472:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1472:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1473:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3556);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==40) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred10_InternalTutorial()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1483:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1483:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1483:6: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1484:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXCastedExpression3591); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1493:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1494:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1494:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1495:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3614);
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
            	    break loop22;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1519:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1520:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1521:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3652);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3662); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1528:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
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

        EObject lv_memberCallArguments_22_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1531:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1532:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1532:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1533:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3709);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop30:
            do {
                int alt30=3;
                switch ( input.LA(1) ) {
                case 41:
                    {
                    int LA30_2 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt30=1;
                    }
                    else if ( (synpred12_InternalTutorial()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA30_3 = input.LA(2);

                    if ( (synpred12_InternalTutorial()) ) {
                        alt30=2;
                    }


                    }
                    break;
                case 43:
                    {
                    int LA30_4 = input.LA(2);

                    if ( (synpred12_InternalTutorial()) ) {
                        alt30=2;
                    }


                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1547:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1547:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1547:26: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1548:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall3758); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1558:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1558:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1559:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3781);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3797);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1580:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1581:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1581:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1582:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3819);
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
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1615:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1615:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1615:8: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1616:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1621:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt23=3;
            	    switch ( input.LA(1) ) {
            	    case 41:
            	        {
            	        alt23=1;
            	        }
            	        break;
            	    case 42:
            	        {
            	        alt23=2;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt23=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt23) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1621:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleXMemberFeatureCall3905); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1626:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1626:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1627:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1627:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1628:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,42,FOLLOW_42_in_ruleXMemberFeatureCall3929); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1642:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1642:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1643:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1643:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1644:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall3966); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1657:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==30) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1657:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleXMemberFeatureCall3995); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1661:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1662:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1662:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1663:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4016);
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

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1679:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop24:
            	            do {
            	                int alt24=2;
            	                int LA24_0 = input.LA(1);

            	                if ( (LA24_0==44) ) {
            	                    alt24=1;
            	                }


            	                switch (alt24) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1679:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4029); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1683:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1684:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1684:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1685:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4050);
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
            	            	    break loop24;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall4064); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1705:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1706:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1706:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1707:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4089);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt28=2;
            	    alt28 = dfa28.predict(input);
            	    switch (alt28) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1727:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1728:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4123); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt27=3;
            	            alt27 = dfa27.predict(input);
            	            switch (alt27) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1758:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1759:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4208);
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
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1776:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1776:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1776:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1776:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1777:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1777:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1778:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4236);
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

            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1794:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop26:
            	                    do {
            	                        int alt26=2;
            	                        int LA26_0 = input.LA(1);

            	                        if ( (LA26_0==44) ) {
            	                            alt26=1;
            	                        }


            	                        switch (alt26) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1794:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4249); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1798:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1799:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1799:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1800:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4270);
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
            	                    	    break loop26;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,46,FOLLOW_46_in_ruleXMemberFeatureCall4287); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt29=2;
            	    alt29 = dfa29.predict(input);
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1825:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1826:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4320);
            	            lv_memberCallArguments_22_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"memberCallArguments",
            	                      		lv_memberCallArguments_22_0, 
            	                      		"XClosure");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }
            	            break;

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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1850:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1851:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1852:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4360);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4370); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1859:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
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

        EObject this_XReturnExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1862:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1863:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1863:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt31=13;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt31=1;
                }
                break;
            case 17:
                {
                alt31=2;
                }
                break;
            case 53:
                {
                alt31=3;
                }
                break;
            case RULE_ID:
            case 30:
            case 61:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 47:
            case 64:
            case 65:
            case 66:
            case 67:
                {
                alt31=5;
                }
                break;
            case 51:
                {
                alt31=6;
                }
                break;
            case 56:
                {
                alt31=7;
                }
                break;
            case 57:
                {
                alt31=8;
                }
                break;
            case 58:
                {
                alt31=9;
                }
                break;
            case 68:
                {
                alt31=10;
                }
                break;
            case 69:
                {
                alt31=11;
                }
                break;
            case 70:
                {
                alt31=12;
                }
                break;
            case 45:
                {
                alt31=13;
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1864:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4417);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1874:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4444);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1884:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4471);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1894:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4498);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1904:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4525);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4552);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1924:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4579);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1934:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4606);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1944:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4633);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1954:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4660);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1964:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4687);
                    this_XReturnExpression_10=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1974:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4714);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1984:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4741);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2000:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2001:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2002:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4776);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4786); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2009:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XNumberLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2012:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2013:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2013:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt32=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt32=1;
                }
                break;
            case 64:
            case 65:
                {
                alt32=2;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt32=3;
                }
                break;
            case 66:
                {
                alt32=4;
                }
                break;
            case RULE_STRING:
                {
                alt32=5;
                }
                break;
            case 67:
                {
                alt32=6;
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2014:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4833);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2024:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4860);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2034:5: this_XNumberLiteral_2= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral4887);
                    this_XNumberLiteral_2=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNumberLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2044:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral4914);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2054:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral4941);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2064:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4968);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2080:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2081:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2082:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5003);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5013); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2089:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2092:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2093:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2093:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2093:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2093:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2094:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5059); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==RULE_ID||LA34_0==45||LA34_0==73) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2119:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2119:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2120:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5130);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"declaredFormalParameters",
                                      		lv_declaredFormalParameters_2_0, 
                                      		"JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2136:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==44) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2136:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleXClosure5143); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2140:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2141:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2141:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2142:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5164);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"declaredFormalParameters",
                            	              		lv_declaredFormalParameters_4_0, 
                            	              		"JvmFormalParameter");
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
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2158:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2159:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2159:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2160:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,48,FOLLOW_48_in_ruleXClosure5186); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_2_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXClosureRule());
                      	        }
                             		setWithLastConsumed(current, "explicitSyntax", true, "|");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2173:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2174:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2174:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2175:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5223);
            lv_expression_6_0=ruleXExpressionInClosure();

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
                      		"XExpressionInClosure");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleXClosure5235); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_4());
                  
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


    // $ANTLR start "entryRuleXExpressionInClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2203:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2204:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2205:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5271);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5281); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2212:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2215:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2216:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2216:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2216:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2216:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2217:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2222:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)||LA37_0==17||LA37_0==30||(LA37_0>=33 && LA37_0<=34)||LA37_0==39||LA37_0==45||LA37_0==47||LA37_0==51||LA37_0==53||(LA37_0>=56 && LA37_0<=61)||(LA37_0>=63 && LA37_0<=70)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2222:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2222:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2223:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2223:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2224:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5337);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_1_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2240:2: (otherlv_2= ';' )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==50) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2240:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleXExpressionInClosure5350); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2252:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2253:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2254:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5390);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5400); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2261:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2264:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2265:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2265:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2265:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2265:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2265:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2281:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2281:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2281:7: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2282:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID||LA39_0==45||LA39_0==73) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2288:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2288:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2289:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5508);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"declaredFormalParameters",
                              		lv_declaredFormalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2305:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==44) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2305:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXShortClosure5521); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2309:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2310:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2310:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2311:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5542);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"declaredFormalParameters",
                    	              		lv_declaredFormalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2327:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2328:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2328:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2329:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,48,FOLLOW_48_in_ruleXShortClosure5564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXShortClosureRule());
              	        }
                     		setWithLastConsumed(current, "explicitSyntax", true, "|");
              	    
            }

            }


            }


            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2342:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2344:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5600);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2368:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2369:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2370:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5636);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5646); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2377:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2380:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2381:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2381:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2381:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleXParenthesizedExpression5683); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5705);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleXParenthesizedExpression5716); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2406:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2407:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2408:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5752);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5762); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2415:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2418:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2419:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2419:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2419:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2419:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2420:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXIfExpression5808); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression5820); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2433:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2434:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2434:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2435:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5841);
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

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXIfExpression5853); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2455:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2456:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2456:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2457:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5874);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==52) ) {
                int LA40_1 = input.LA(2);

                if ( (synpred18_InternalTutorial()) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,52,FOLLOW_52_in_ruleXIfExpression5895); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2478:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2479:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2479:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2480:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5917);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2504:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2505:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2506:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5955);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression5965); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2513:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        AntlrDatatypeRuleToken lv_localVarName_6_0 = null;

        EObject lv_switch_8_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2516:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2517:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2517:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2517:2: () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2517:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2518:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXSwitchExpression6011); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:1: ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==17||LA42_0==30||(LA42_0>=33 && LA42_0<=34)||LA42_0==39||LA42_0==47||LA42_0==51||LA42_0==53||(LA42_0>=56 && LA42_0<=58)||LA42_0==61||(LA42_0>=63 && LA42_0<=70)) ) {
                alt42=1;
            }
            else if ( (LA42_0==45) ) {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==RULE_ID) ) {
                    int LA42_3 = input.LA(3);

                    if ( ((LA42_3>=20 && LA42_3<=38)||(LA42_3>=40 && LA42_3<=43)||(LA42_3>=45 && LA42_3<=47)||LA42_3==62) ) {
                        alt42=1;
                    }
                    else if ( (LA42_3==19) && (synpred20_InternalTutorial())) {
                        alt42=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA42_2>=RULE_STRING && LA42_2<=RULE_DECIMAL)||LA42_2==17||LA42_2==30||(LA42_2>=33 && LA42_2<=34)||LA42_2==39||LA42_2==45||LA42_2==47||LA42_2==51||LA42_2==53||(LA42_2>=56 && LA42_2<=58)||LA42_2==61||(LA42_2>=63 && LA42_2<=70)) ) {
                    alt42=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_ID) ) {
                        int LA41_1 = input.LA(2);

                        if ( (LA41_1==19) && (synpred19_InternalTutorial())) {
                            alt41=1;
                        }
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:4: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2532:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2532:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2532:6: ( (lv_localVarName_2_0= ruleValidID ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2533:1: (lv_localVarName_2_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2533:1: (lv_localVarName_2_0= ruleValidID )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2534:3: lv_localVarName_2_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6054);
                            lv_localVarName_2_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"localVarName",
                                      		lv_localVarName_2_0, 
                                      		"ValidID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6066); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_1());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2554:4: ( (lv_switch_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2555:1: (lv_switch_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2555:1: (lv_switch_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2556:3: lv_switch_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6090);
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


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2579:5: (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2579:7: otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleXSwitchExpression6134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_1_0_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2583:1: ( (lv_localVarName_6_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2584:1: (lv_localVarName_6_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2584:1: (lv_localVarName_6_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2585:3: lv_localVarName_6_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6155);
                    lv_localVarName_6_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_6_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6167); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_2());
                          
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:3: ( (lv_switch_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2606:1: (lv_switch_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2606:1: (lv_switch_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2607:3: lv_switch_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6190);
                    lv_switch_8_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_8_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression6202); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2631:1: ( (lv_cases_11_0= ruleXCasePart ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==19||LA43_0==45||LA43_0==55||LA43_0==73) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2632:1: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2632:1: (lv_cases_11_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2633:3: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6237);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_11_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2649:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==54) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2649:5: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,54,FOLLOW_54_in_ruleXSwitchExpression6251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2657:1: ( (lv_default_14_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2658:1: (lv_default_14_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2658:1: (lv_default_14_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2659:3: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6284);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_14_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleXSwitchExpression6298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
                  
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2687:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2688:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2689:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6334);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6344); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2696:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2699:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2700:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2700:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2700:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2700:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||LA45_0==45||LA45_0==73) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2701:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2701:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2702:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6390);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2718:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==55) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2718:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXCasePart6404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2722:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2723:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2723:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2724:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6425);
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleXCasePart6439); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2744:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2745:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2745:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2746:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6460);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2770:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2771:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2772:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6496);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6506); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2779:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2782:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2783:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2783:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2783:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2783:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2784:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXForLoopExpression6552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXForLoopExpression6564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2797:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2798:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2798:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2799:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6585);
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

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleXForLoopExpression6597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2819:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2820:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2820:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2821:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6618);
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

            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleXForLoopExpression6630); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2841:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2842:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2842:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2843:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6651);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2867:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2868:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2869:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6687);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6697); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2876:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2879:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2880:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2880:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2880:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2880:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2881:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXWhileExpression6743); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXWhileExpression6755); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2894:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2895:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2895:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2896:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6776);
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

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXWhileExpression6788); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2916:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2917:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2917:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2918:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6809);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2942:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2943:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2944:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6845);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression6855); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2951:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2954:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2955:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2955:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2955:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2955:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2956:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXDoWhileExpression6901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2965:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2966:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2966:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2967:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6922);
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

            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleXDoWhileExpression6934); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleXDoWhileExpression6946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2991:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2992:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2992:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2993:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6967);
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

            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleXDoWhileExpression6979); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3021:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3022:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3023:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7015);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7025); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3030:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3033:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3034:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3034:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3034:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3034:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3035:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXBlockExpression7071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3044:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_ID)||LA48_0==17||LA48_0==30||(LA48_0>=33 && LA48_0<=34)||LA48_0==39||LA48_0==45||LA48_0==47||LA48_0==51||LA48_0==53||(LA48_0>=56 && LA48_0<=61)||(LA48_0>=63 && LA48_0<=70)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3044:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3044:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3045:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3045:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3046:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7093);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3062:2: (otherlv_3= ';' )?
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==50) ) {
            	        alt47=1;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3062:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,50,FOLLOW_50_in_ruleXBlockExpression7106); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleXBlockExpression7122); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3078:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3079:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3080:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7158);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7168); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3087:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3090:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3091:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3091:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=59 && LA49_0<=60)) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==17||LA49_0==30||(LA49_0>=33 && LA49_0<=34)||LA49_0==39||LA49_0==45||LA49_0==47||LA49_0==51||LA49_0==53||(LA49_0>=56 && LA49_0<=58)||LA49_0==61||(LA49_0>=63 && LA49_0<=70)) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3092:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7215);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3102:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7242);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3118:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3119:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3120:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7277);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7287); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3127:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3130:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3131:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3131:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3131:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3131:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3132:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3137:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==59) ) {
                alt50=1;
            }
            else if ( (LA50_0==60) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3137:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3137:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3138:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3138:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3139:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,59,FOLLOW_59_in_ruleXVariableDeclaration7340); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3153:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleXVariableDeclaration7371); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (synpred21_InternalTutorial()) ) {
                    alt51=1;
                }
                else if ( (true) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA51_0==45) && (synpred21_InternalTutorial())) {
                alt51=1;
            }
            else if ( (LA51_0==73) && (synpred21_InternalTutorial())) {
                alt51=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3165:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3165:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3165:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3166:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3166:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3167:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7419);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3183:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3184:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3184:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3185:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7440);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3202:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3202:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3203:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3203:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3204:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7469);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3220:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==20) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3220:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleXVariableDeclaration7483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3224:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3225:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3225:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3226:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7504);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3250:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3251:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3252:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7542);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7552); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3259:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3262:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3263:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3263:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3263:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3263:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==RULE_ID||LA53_1==30||LA53_1==41||LA53_1==47) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==45||LA53_0==73) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3264:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3264:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3265:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7598);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3281:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3282:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3282:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3283:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7620);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3307:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3308:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3309:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7656);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7666); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3316:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3319:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3320:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3320:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3320:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3320:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3321:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3321:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3322:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7712);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3338:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3339:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3339:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3340:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7733);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
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
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3364:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3365:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3366:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7769);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7779); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3373:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_10_0 = null;

        EObject lv_featureCallArguments_12_0 = null;

        EObject lv_featureCallArguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3376:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3377:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3377:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3377:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3377:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3378:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3383:2: ( ( ruleStaticQualifier ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==62) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3384:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3384:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3385:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7836);
                    ruleStaticQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==30) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXFeatureCall7850); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3402:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3403:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3403:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3404:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7871);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_3_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3420:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==44) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3420:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall7884); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3424:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3425:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3425:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3426:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7905);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_5_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall7919); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3446:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3447:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3447:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3448:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7944);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3468:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3469:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,45,FOLLOW_45_in_ruleXFeatureCall7978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_8_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt58=3;
                    alt58 = dfa58.predict(input);
                    switch (alt58) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3499:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3500:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8063);
                            lv_featureCallArguments_9_0=ruleXShortClosure();

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
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3517:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3517:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3517:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3517:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3518:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3518:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3519:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8091);
                            lv_featureCallArguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3535:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==44) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3535:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleXFeatureCall8104); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3540:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3540:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3541:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8125);
                            	    lv_featureCallArguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_12_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop57;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,46,FOLLOW_46_in_ruleXFeatureCall8142); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3566:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3567:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8175);
                    lv_featureCallArguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"featureCallArguments",
                              		lv_featureCallArguments_14_0, 
                              		"XClosure");
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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3591:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3592:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3593:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8213);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8224); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3600:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3603:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3604:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3604:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                alt61=1;
            }
            else if ( (LA61_0==61) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3605:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8271);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3617:2: kw= 'super'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleIdOrSuper8295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleStaticQualifier"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3630:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3631:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3632:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8336);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8347); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticQualifier"


    // $ANTLR start "ruleStaticQualifier"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3642:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3643:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3643:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    int LA62_2 = input.LA(2);

                    if ( (LA62_2==62) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3644:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8394);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleStaticQualifier8412); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);


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
    // $ANTLR end "ruleStaticQualifier"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3668:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3669:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3670:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8453);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8463); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3677:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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

        EObject lv_arguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3680:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3682:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXConstructorCall8509); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3691:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3692:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3692:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3693:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8532);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt64=2;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:3: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:3: ( ( '<' )=>otherlv_3= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:4: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleXConstructorCall8553); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3711:2: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3712:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3712:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3713:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8575);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3729:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==44) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3729:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8588); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3733:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3734:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3734:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3735:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8609);
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
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall8623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:4: ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:4: ( ( '(' )=>otherlv_8= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:5: ( '(' )=>otherlv_8= '('
                    {
                    otherlv_8=(Token)match(input,45,FOLLOW_45_in_ruleXConstructorCall8646); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt66=3;
                    alt66 = dfa66.predict(input);
                    switch (alt66) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3777:1: (lv_arguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3778:3: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8719);
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
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3795:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3795:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3795:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3795:7: ( (lv_arguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3796:1: (lv_arguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3796:1: (lv_arguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3797:3: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8747);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3813:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( (LA65_0==44) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3813:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleXConstructorCall8760); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3817:1: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3818:1: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3818:1: (lv_arguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3819:3: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8781);
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
                            	    break loop65;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,46,FOLLOW_46_in_ruleXConstructorCall8798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3839:3: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3839:4: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3844:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3845:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall8831);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_14_0, 
                              		"XClosure");
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3869:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3870:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8868);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8878); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3878:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3881:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3882:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3882:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3882:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3882:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3883:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3888:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==64) ) {
                alt69=1;
            }
            else if ( (LA69_0==65) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3888:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXBooleanLiteral8925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3893:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3893:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3894:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3894:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3895:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,65,FOLLOW_65_in_ruleXBooleanLiteral8949); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3916:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3917:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3918:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8999);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9009); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3925:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3928:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3929:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3929:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3929:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3929:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3930:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXNullLiteral9055); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXNumberLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3947:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3948:2: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9091);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral9101); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3959:28: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3960:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3960:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3960:2: () ( (lv_value_1_0= ruleNumber ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3960:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3961:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3966:2: ( (lv_value_1_0= ruleNumber ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3967:1: (lv_value_1_0= ruleNumber )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3967:1: (lv_value_1_0= ruleNumber )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3968:3: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumber_in_ruleXNumberLiteral9156);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"Number");
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
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3992:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3993:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3994:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9192);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9202); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4001:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4004:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4005:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4005:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4005:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4005:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4006:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4011:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4012:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4012:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4013:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9253); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
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


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4037:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4038:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4039:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9294);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9304); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4046:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4049:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4050:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4050:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4050:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4050:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4051:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXTypeLiteral9350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleXTypeLiteral9362); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4064:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4065:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4065:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4066:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9385);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXTypeLiteral9397); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4091:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4092:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4093:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9433);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9443); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4100:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4103:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4104:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4104:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4104:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4104:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4105:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXThrowExpression9489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4114:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4115:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4115:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4116:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9510);
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


    // $ANTLR start "entryRuleXReturnExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4140:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4141:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4142:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9546);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9556); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4149:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4152:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4153:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4153:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4153:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4153:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4154:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXReturnExpression9602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4163:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4163:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4168:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4169:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9633);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4193:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4194:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4195:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9670);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9680); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4202:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4205:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4207:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleXTryCatchFinallyExpression9726); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4216:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4217:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4217:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4218:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9747);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==72) ) {
                alt73=1;
            }
            else if ( (LA73_0==71) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==72) ) {
                            int LA71_2 = input.LA(2);

                            if ( (synpred30_InternalTutorial()) ) {
                                alt71=1;
                            }


                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4236:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4237:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9777);
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
                    	    if ( cnt71 >= 1 ) break loop71;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==71) ) {
                        int LA72_1 = input.LA(2);

                        if ( (synpred31_InternalTutorial()) ) {
                            alt72=1;
                        }
                    }
                    switch (alt72) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,71,FOLLOW_71_in_ruleXTryCatchFinallyExpression9799); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4258:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4259:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4259:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4260:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9821);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4277:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4277:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4277:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,71,FOLLOW_71_in_ruleXTryCatchFinallyExpression9843); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4281:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4282:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4282:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4283:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9864);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4307:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4309:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9902);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9912); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4316:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4319:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4320:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4320:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4320:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4320:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4320:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleXCatchClause9957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleXCatchClause9970); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4329:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4330:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4330:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4331:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9991);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

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
                      		"FullJvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleXCatchClause10003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4351:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4352:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4352:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4353:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10024);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4377:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4378:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4379:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10061);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10072); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4386:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4389:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4390:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4390:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4391:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10119);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==41) ) {
                    int LA74_2 = input.LA(2);

                    if ( (LA74_2==RULE_ID) ) {
                        int LA74_3 = input.LA(3);

                        if ( (synpred33_InternalTutorial()) ) {
                            alt74=1;
                        }


                    }


                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleQualifiedName10147); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10170);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop74;
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


    // $ANTLR start "entryRuleNumber"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4432:2: (iv_ruleNumber= ruleNumber EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4433:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber10224);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber10235); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4443:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:28: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4448:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4448:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_HEX) ) {
                alt78=1;
            }
            else if ( ((LA78_0>=RULE_INT && LA78_0<=RULE_DECIMAL)) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4448:6: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber10279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4456:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4456:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4456:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4456:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_INT) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==RULE_DECIMAL) ) {
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
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4456:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10307); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4464:10: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10333); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_DECIMAL_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4471:2: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==41) ) {
                        int LA77_1 = input.LA(2);

                        if ( ((LA77_1>=RULE_INT && LA77_1<=RULE_DECIMAL)) ) {
                            alt77=1;
                        }
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4472:2: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,41,FOLLOW_41_in_ruleNumber10353); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); 
                                  
                            }
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4477:1: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt76=2;
                            int LA76_0 = input.LA(1);

                            if ( (LA76_0==RULE_INT) ) {
                                alt76=1;
                            }
                            else if ( (LA76_0==RULE_DECIMAL) ) {
                                alt76=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 76, 0, input);

                                throw nvae;
                            }
                            switch (alt76) {
                                case 1 :
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4477:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10369); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_INT_4);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4485:10: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10395); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_DECIMAL_5);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); 
                                          
                                    }

                                    }
                                    break;

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4503:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4504:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4505:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10448);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10458); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4512:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4515:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4516:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4516:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            else if ( (LA80_0==45||LA80_0==73) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4516:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4516:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4517:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10506);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==47) ) {
                            int LA79_2 = input.LA(2);

                            if ( (LA79_2==49) ) {
                                int LA79_3 = input.LA(3);

                                if ( (synpred34_InternalTutorial()) ) {
                                    alt79=1;
                                }


                            }


                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4528:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4528:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4528:6: ()
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4529:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleJvmTypeReference10544); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleJvmTypeReference10556); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4544:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10588);
                    this_XFunctionTypeRef_4=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_4; 
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4560:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4561:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4562:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10623);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10633); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4569:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4572:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==45) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleXFunctionTypeRef10671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4577:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==RULE_ID||LA82_0==45||LA82_0==73) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4577:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4577:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4578:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4578:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4579:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10693);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop81:
                            do {
                                int alt81=2;
                                int LA81_0 = input.LA(1);

                                if ( (LA81_0==44) ) {
                                    alt81=1;
                                }


                                switch (alt81) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXFunctionTypeRef10706); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4600:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4600:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4601:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10727);
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


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXFunctionTypeRef10743); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,73,FOLLOW_73_in_ruleXFunctionTypeRef10757); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4625:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4626:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4626:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4627:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10778);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4651:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4652:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4653:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10814);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10824); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4660:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4663:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4664:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4664:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4664:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4664:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4665:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4665:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4666:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10872);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt85=2;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleJvmParameterizedTypeReference10893); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4684:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4685:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4685:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4686:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10915);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4702:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==44) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4702:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleJvmParameterizedTypeReference10928); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4706:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4707:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4707:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4708:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10949);
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
                    	    break loop84;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleJvmParameterizedTypeReference10963); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4736:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4737:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11001);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11011); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4745:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4748:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4749:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4749:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID||LA86_0==45||LA86_0==73) ) {
                alt86=1;
            }
            else if ( (LA86_0==74) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4750:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11058);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4760:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11085);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4776:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4777:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4778:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11120);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11130); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4785:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4788:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4790:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleJvmWildcardTypeReference11176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4799:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt87=3;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==16) ) {
                alt87=1;
            }
            else if ( (LA87_0==61) ) {
                alt87=2;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4799:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4799:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4800:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4800:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4801:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11198);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4818:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4818:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4819:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4819:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4820:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11225);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4844:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4845:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4846:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11263);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11273); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4853:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4856:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4857:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4857:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4857:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJvmUpperBound11310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4861:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4862:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4862:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4863:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11331);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4887:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4888:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4889:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11367);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11377); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4896:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4899:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4900:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4900:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4900:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleJvmUpperBoundAnded11414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4904:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4905:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4905:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4906:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11435);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4930:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4931:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4932:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11471);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11481); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4939:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4942:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4943:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4943:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4943:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleJvmLowerBound11518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4947:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4948:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4948:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4949:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11539);
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


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4975:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4976:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4977:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11578);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11589); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4984:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4987:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4988:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleValidID"

    // $ANTLR start synpred1_InternalTutorial
    public final void synpred1_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:441:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:442:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:442:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:443:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:443:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:444:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalTutorial886);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalTutorial

    // $ANTLR start synpred2_InternalTutorial
    public final void synpred2_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:569:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:570:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:570:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:571:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:571:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:572:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalTutorial1234);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalTutorial

    // $ANTLR start synpred3_InternalTutorial
    public final void synpred3_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:670:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:671:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:671:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:672:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:672:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:673:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalTutorial1493);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalTutorial

    // $ANTLR start synpred4_InternalTutorial
    public final void synpred4_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:771:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:772:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:772:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:773:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:773:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:774:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalTutorial1752);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalTutorial

    // $ANTLR start synpred5_InternalTutorial
    public final void synpred5_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:879:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:880:1: 
        {
        }

        match(input,26,FOLLOW_26_in_synpred5_InternalTutorial2028); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalTutorial

    // $ANTLR start synpred6_InternalTutorial
    public final void synpred6_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:910:10: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:911:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:911:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:912:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:912:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:913:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalTutorial2099);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalTutorial

    // $ANTLR start synpred7_InternalTutorial
    public final void synpred7_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1032:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1033:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1033:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1034:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1034:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1035:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalTutorial2418);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalTutorial

    // $ANTLR start synpred8_InternalTutorial
    public final void synpred8_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1141:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1141:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1142:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1142:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1143:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalTutorial2698);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalTutorial

    // $ANTLR start synpred9_InternalTutorial
    public final void synpred9_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1248:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1249:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1249:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1250:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1250:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1251:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalTutorial2978);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalTutorial

    // $ANTLR start synpred10_InternalTutorial
    public final void synpred10_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:4: ( () 'as' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:5: () 'as'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1481:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1482:1: 
        {
        }

        match(input,40,FOLLOW_40_in_synpred10_InternalTutorial3572); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalTutorial

    // $ANTLR start synpred11_InternalTutorial
    public final void synpred11_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1541:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1542:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred11_InternalTutorial3726); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1543:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1544:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1544:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1545:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalTutorial3735);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalTutorial3741);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalTutorial

    // $ANTLR start synpred12_InternalTutorial
    public final void synpred12_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1599:10: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1600:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1600:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt88=3;
        switch ( input.LA(1) ) {
        case 41:
            {
            alt88=1;
            }
            break;
        case 42:
            {
            alt88=2;
            }
            break;
        case 43:
            {
            alt88=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 88, 0, input);

            throw nvae;
        }

        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1600:4: '.'
                {
                match(input,41,FOLLOW_41_in_synpred12_InternalTutorial3844); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1602:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1602:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1603:1: ( '?.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1603:1: ( '?.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1604:2: '?.'
                {
                match(input,42,FOLLOW_42_in_synpred12_InternalTutorial3858); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1609:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1609:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1610:1: ( '*.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1610:1: ( '*.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1611:2: '*.'
                {
                match(input,43,FOLLOW_43_in_synpred12_InternalTutorial3878); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalTutorial

    // $ANTLR start synpred13_InternalTutorial
    public final void synpred13_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1721:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1721:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1722:2: '('
        {
        match(input,45,FOLLOW_45_in_synpred13_InternalTutorial4105); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalTutorial

    // $ANTLR start synpred14_InternalTutorial
    public final void synpred14_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1742:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1742:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==RULE_ID||LA90_0==45||LA90_0==73) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1742:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1742:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1743:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1743:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1744:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4157);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1746:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop89:
                do {
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==44) ) {
                        alt89=1;
                    }


                    switch (alt89) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1746:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred14_InternalTutorial4164); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1747:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1748:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1748:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1749:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4171);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop89;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1751:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1752:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1752:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1753:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred14_InternalTutorial4185); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalTutorial

    // $ANTLR start synpred15_InternalTutorial
    public final void synpred15_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1821:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1821:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1822:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred15_InternalTutorial4303);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalTutorial

    // $ANTLR start synpred16_InternalTutorial
    public final void synpred16_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==45||LA92_0==73) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2103:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2104:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2104:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2105:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5076);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2107:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==44) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2107:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred16_InternalTutorial5083); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2108:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2109:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2109:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2110:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5090);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop91;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2112:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2113:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2113:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2114:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred16_InternalTutorial5104); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalTutorial

    // $ANTLR start synpred18_InternalTutorial
    public final void synpred18_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:4: ( 'else' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2473:6: 'else'
        {
        match(input,52,FOLLOW_52_in_synpred18_InternalTutorial5887); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalTutorial

    // $ANTLR start synpred19_InternalTutorial
    public final void synpred19_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:4: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:5: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:5: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:6: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2527:6: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2528:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2528:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2529:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalTutorial6029);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,19,FOLLOW_19_in_synpred19_InternalTutorial6035); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalTutorial

    // $ANTLR start synpred20_InternalTutorial
    public final void synpred20_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:9: ( '(' ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:9: ( '(' ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2573:11: '(' ( ( ruleValidID ) ) ':'
        {
        match(input,45,FOLLOW_45_in_synpred20_InternalTutorial6111); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2574:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2575:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2575:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2576:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalTutorial6118);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,19,FOLLOW_19_in_synpred20_InternalTutorial6124); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalTutorial

    // $ANTLR start synpred21_InternalTutorial
    public final void synpred21_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3158:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3158:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3159:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred21_InternalTutorial7389);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3161:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3162:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3162:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3163:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred21_InternalTutorial7398);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalTutorial

    // $ANTLR start synpred22_InternalTutorial
    public final void synpred22_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3462:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3462:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3463:2: '('
        {
        match(input,45,FOLLOW_45_in_synpred22_InternalTutorial7960); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalTutorial

    // $ANTLR start synpred23_InternalTutorial
    public final void synpred23_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3483:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3483:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt96=2;
        int LA96_0 = input.LA(1);

        if ( (LA96_0==RULE_ID||LA96_0==45||LA96_0==73) ) {
            alt96=1;
        }
        switch (alt96) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3483:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3483:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3484:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3484:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3485:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8012);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3487:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop95:
                do {
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==44) ) {
                        alt95=1;
                    }


                    switch (alt95) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3487:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred23_InternalTutorial8019); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3488:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3489:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3489:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3490:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8026);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop95;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3492:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3493:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3493:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3494:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred23_InternalTutorial8040); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalTutorial

    // $ANTLR start synpred24_InternalTutorial
    public final void synpred24_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3562:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3562:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3563:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred24_InternalTutorial8158);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalTutorial

    // $ANTLR start synpred25_InternalTutorial
    public final void synpred25_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:6: '<'
        {
        match(input,30,FOLLOW_30_in_synpred25_InternalTutorial8545); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalTutorial

    // $ANTLR start synpred26_InternalTutorial
    public final void synpred26_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:5: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:7: '('
        {
        match(input,45,FOLLOW_45_in_synpred26_InternalTutorial8638); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalTutorial

    // $ANTLR start synpred27_InternalTutorial
    public final void synpred27_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3761:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3761:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==RULE_ID||LA98_0==45||LA98_0==73) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3761:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3761:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3762:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3762:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3763:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8668);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3765:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop97:
                do {
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==44) ) {
                        alt97=1;
                    }


                    switch (alt97) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3765:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,44,FOLLOW_44_in_synpred27_InternalTutorial8675); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3766:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3767:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3767:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3768:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8682);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop97;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3770:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3771:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3771:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3772:2: '|'
        {
        match(input,48,FOLLOW_48_in_synpred27_InternalTutorial8696); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalTutorial

    // $ANTLR start synpred28_InternalTutorial
    public final void synpred28_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3839:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3840:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3840:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3841:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred28_InternalTutorial8814);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalTutorial

    // $ANTLR start synpred29_InternalTutorial
    public final void synpred29_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4163:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4164:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4164:1: ( ruleXExpression )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4165:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred29_InternalTutorial9616);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalTutorial

    // $ANTLR start synpred30_InternalTutorial
    public final void synpred30_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:5: ( 'catch' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4234:7: 'catch'
        {
        match(input,72,FOLLOW_72_in_synpred30_InternalTutorial9761); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalTutorial

    // $ANTLR start synpred31_InternalTutorial
    public final void synpred31_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:5: ( 'finally' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4253:7: 'finally'
        {
        match(input,71,FOLLOW_71_in_synpred31_InternalTutorial9791); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalTutorial

    // $ANTLR start synpred33_InternalTutorial
    public final void synpred33_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:3: ( '.' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4402:2: '.'
        {
        match(input,41,FOLLOW_41_in_synpred33_InternalTutorial10138); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalTutorial

    // $ANTLR start synpred34_InternalTutorial
    public final void synpred34_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:3: ( () '[' ']' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:4: () '[' ']'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:4: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4526:1: 
        {
        }

        match(input,47,FOLLOW_47_in_synpred34_InternalTutorial10521); if (state.failed) return ;
        match(input,49,FOLLOW_49_in_synpred34_InternalTutorial10525); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_InternalTutorial

    // $ANTLR start synpred35_InternalTutorial
    public final void synpred35_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:6: '<'
        {
        match(input,30,FOLLOW_30_in_synpred35_InternalTutorial10885); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalTutorial

    // Delegated rules

    public final boolean synpred28_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA85 dfa85 = new DFA85(this);
    static final String DFA28_eotS =
        "\76\uffff";
    static final String DFA28_eofS =
        "\1\2\75\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA28_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA28_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA28_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\30\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\13\2",
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

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1720:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\36\uffff";
    static final String DFA27_eofS =
        "\36\uffff";
    static final String DFA27_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA27_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA27_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA27_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA27_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1741:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_0 = input.LA(1);

                         
                        int index27_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA27_0==RULE_ID) ) {s = 1;}

                        else if ( (LA27_0==45) ) {s = 2;}

                        else if ( (LA27_0==73) && (synpred14_InternalTutorial())) {s = 3;}

                        else if ( (LA27_0==48) && (synpred14_InternalTutorial())) {s = 4;}

                        else if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_DECIMAL)||LA27_0==17||LA27_0==30||(LA27_0>=33 && LA27_0<=34)||LA27_0==39||LA27_0==47||LA27_0==51||LA27_0==53||(LA27_0>=56 && LA27_0<=58)||LA27_0==61||(LA27_0>=63 && LA27_0<=70)) ) {s = 5;}

                        else if ( (LA27_0==46) ) {s = 29;}

                         
                        input.seek(index27_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\76\uffff";
    static final String DFA29_eofS =
        "\1\2\75\uffff";
    static final String DFA29_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA29_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA29_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA29_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\32\2\1\1\1\uffff\15\2\1\uffff\13\2",
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1820:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\40\uffff";
    static final String DFA35_eofS =
        "\40\uffff";
    static final String DFA35_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA35_maxS =
        "\1\111\2\0\35\uffff";
    static final String DFA35_acceptS =
        "\3\uffff\2\1\1\2\32\uffff";
    static final String DFA35_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA35_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\uffff\1\5\1\4\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff"+
            "\6\5\1\uffff\10\5\2\uffff\1\3",
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "2103:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_0 = input.LA(1);

                         
                        int index35_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA35_0==RULE_ID) ) {s = 1;}

                        else if ( (LA35_0==45) ) {s = 2;}

                        else if ( (LA35_0==73) && (synpred16_InternalTutorial())) {s = 3;}

                        else if ( (LA35_0==48) && (synpred16_InternalTutorial())) {s = 4;}

                        else if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_DECIMAL)||LA35_0==17||LA35_0==30||(LA35_0>=33 && LA35_0<=34)||LA35_0==39||LA35_0==47||LA35_0==49||LA35_0==51||LA35_0==53||(LA35_0>=56 && LA35_0<=61)||(LA35_0>=63 && LA35_0<=70)) ) {s = 5;}

                         
                        input.seek(index35_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\76\uffff";
    static final String DFA59_eofS =
        "\1\2\75\uffff";
    static final String DFA59_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA59_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA59_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA59_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA59_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\30\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\13\2",
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

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "3461:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\36\uffff";
    static final String DFA58_eofS =
        "\36\uffff";
    static final String DFA58_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA58_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA58_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA58_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA58_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            "",
            "",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "3482:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_0 = input.LA(1);

                         
                        int index58_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA58_0==RULE_ID) ) {s = 1;}

                        else if ( (LA58_0==45) ) {s = 2;}

                        else if ( (LA58_0==73) && (synpred23_InternalTutorial())) {s = 3;}

                        else if ( (LA58_0==48) && (synpred23_InternalTutorial())) {s = 4;}

                        else if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_DECIMAL)||LA58_0==17||LA58_0==30||(LA58_0>=33 && LA58_0<=34)||LA58_0==39||LA58_0==47||LA58_0==51||LA58_0==53||(LA58_0>=56 && LA58_0<=58)||LA58_0==61||(LA58_0>=63 && LA58_0<=70)) ) {s = 5;}

                        else if ( (LA58_0==46) ) {s = 29;}

                         
                        input.seek(index58_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\76\uffff";
    static final String DFA60_eofS =
        "\1\2\75\uffff";
    static final String DFA60_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA60_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA60_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA60_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA60_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\32\2\1\1\1\uffff\15\2\1\uffff\13\2",
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

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "3561:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\76\uffff";
    static final String DFA64_eofS =
        "\1\2\75\uffff";
    static final String DFA64_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA64_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA64_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA64_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA64_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\11\2\1\1\21\2\1\uffff\15\2\1\uffff"+
            "\13\2",
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

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "3706:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_1 = input.LA(1);

                         
                        int index64_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index64_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\76\uffff";
    static final String DFA67_eofS =
        "\1\2\75\uffff";
    static final String DFA67_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA67_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA67_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA67_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\30\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\13\2",
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

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "3755:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\36\uffff";
    static final String DFA66_eofS =
        "\36\uffff";
    static final String DFA66_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA66_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA66_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA66_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA66_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            "",
            "",
            ""
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "3760:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_0 = input.LA(1);

                         
                        int index66_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA66_0==RULE_ID) ) {s = 1;}

                        else if ( (LA66_0==45) ) {s = 2;}

                        else if ( (LA66_0==73) && (synpred27_InternalTutorial())) {s = 3;}

                        else if ( (LA66_0==48) && (synpred27_InternalTutorial())) {s = 4;}

                        else if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_DECIMAL)||LA66_0==17||LA66_0==30||(LA66_0>=33 && LA66_0<=34)||LA66_0==39||LA66_0==47||LA66_0==51||LA66_0==53||(LA66_0>=56 && LA66_0<=58)||LA66_0==61||(LA66_0>=63 && LA66_0<=70)) ) {s = 5;}

                        else if ( (LA66_0==46) ) {s = 29;}

                         
                        input.seek(index66_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA66_2 = input.LA(1);

                         
                        int index66_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index66_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\76\uffff";
    static final String DFA68_eofS =
        "\1\2\75\uffff";
    static final String DFA68_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA68_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA68_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA68_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA68_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\32\2\1\1\1\uffff\15\2\1\uffff\13\2",
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

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "3839:3: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA70_eotS =
        "\76\uffff";
    static final String DFA70_eofS =
        "\1\33\75\uffff";
    static final String DFA70_minS =
        "\1\4\32\0\43\uffff";
    static final String DFA70_maxS =
        "\1\111\32\0\43\uffff";
    static final String DFA70_acceptS =
        "\33\uffff\1\2\41\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\43\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\21\1\15\1\16\1\17\1\1\10\uffff\1\6\2\33\1\uffff\11\33\1\10"+
            "\2\33\1\4\1\3\4\33\1\2\5\33\1\32\1\33\1\12\1\uffff\2\33\1\23"+
            "\1\33\1\7\2\33\1\24\1\25\1\26\2\33\1\11\1\uffff\1\5\1\13\1\14"+
            "\1\20\1\22\1\27\1\30\1\31\3\33",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
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
            return "4163:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA70_2 = input.LA(1);

                         
                        int index70_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA70_3 = input.LA(1);

                         
                        int index70_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA70_4 = input.LA(1);

                         
                        int index70_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA70_5 = input.LA(1);

                         
                        int index70_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA70_6 = input.LA(1);

                         
                        int index70_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA70_7 = input.LA(1);

                         
                        int index70_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA70_8 = input.LA(1);

                         
                        int index70_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA70_9 = input.LA(1);

                         
                        int index70_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA70_10 = input.LA(1);

                         
                        int index70_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA70_11 = input.LA(1);

                         
                        int index70_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA70_12 = input.LA(1);

                         
                        int index70_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA70_13 = input.LA(1);

                         
                        int index70_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA70_14 = input.LA(1);

                         
                        int index70_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA70_15 = input.LA(1);

                         
                        int index70_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA70_16 = input.LA(1);

                         
                        int index70_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA70_17 = input.LA(1);

                         
                        int index70_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA70_18 = input.LA(1);

                         
                        int index70_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA70_19 = input.LA(1);

                         
                        int index70_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA70_20 = input.LA(1);

                         
                        int index70_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA70_21 = input.LA(1);

                         
                        int index70_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA70_22 = input.LA(1);

                         
                        int index70_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA70_23 = input.LA(1);

                         
                        int index70_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA70_24 = input.LA(1);

                         
                        int index70_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA70_25 = input.LA(1);

                         
                        int index70_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA70_26 = input.LA(1);

                         
                        int index70_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index70_26);
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
    static final String DFA85_eotS =
        "\76\uffff";
    static final String DFA85_eofS =
        "\1\2\75\uffff";
    static final String DFA85_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA85_maxS =
        "\1\111\1\0\74\uffff";
    static final String DFA85_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA85_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA85_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\11\2\1\1\21\2\1\uffff\15\2\1\uffff"+
            "\13\2",
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

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "4679:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA85_1 = input.LA(1);

                         
                        int index85_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index85_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 85, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleDomainModelFile_in_entryRuleDomainModelFile75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomainModelFile85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleDomainModelFile123 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainModelFile144 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleDomainModelFile167 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleDomainModelFile189 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport273 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleImport294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEntity377 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleEntity398 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleEntity411 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleEntity432 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEntity446 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity467 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_18_in_ruleEntity480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleProperty572 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleProperty584 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleProperty605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment799 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment815 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment865 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment918 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpSingleAssign1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpMultiAssign1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1213 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1266 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1289 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpOr1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1472 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1525 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1548 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpAnd1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1731 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1784 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1807 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpEquality1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpEquality1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2011 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_26_in_ruleXRelationalExpression2047 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2070 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2131 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2154 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2397 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2450 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2473 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpOther2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2677 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2730 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2753 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpAdd2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpAdd2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2957 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3010 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3033 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpMulti3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3286 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpUnary3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpUnary3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3556 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleXCastedExpression3591 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3614 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3709 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall3758 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3781 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3797 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3819 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall3905 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_42_in_ruleXMemberFeatureCall3929 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall3966 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_30_in_ruleXMemberFeatureCall3995 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4016 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4029 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4050 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall4064 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4089 = new BitSet(new long[]{0x0000AE0000000002L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4123 = new BitSet(new long[]{0xA729E086400201F0L,0x000000000000027FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4208 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4236 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4249 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4270 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXMemberFeatureCall4287 = new BitSet(new long[]{0x00008E0000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4320 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5059 = new BitSet(new long[]{0xBF2BA086400201F0L,0x000000000000027FL});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5130 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXClosure5143 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5164 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_ruleXClosure5186 = new BitSet(new long[]{0xBF2AA086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5223 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXClosure5235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5337 = new BitSet(new long[]{0xBF2CA086400201F2L,0x000000000000007FL});
    public static final BitSet FOLLOW_50_in_ruleXExpressionInClosure5350 = new BitSet(new long[]{0xBF28A086400201F2L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5508 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_ruleXShortClosure5521 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5542 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_ruleXShortClosure5564 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXParenthesizedExpression5683 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5705 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXParenthesizedExpression5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXIfExpression5808 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression5820 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5841 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXIfExpression5853 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5874 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXIfExpression5895 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXSwitchExpression6011 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6054 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6066 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6090 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_45_in_ruleXSwitchExpression6134 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6155 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6167 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6190 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression6202 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6216 = new BitSet(new long[]{0x0080200000080100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6237 = new BitSet(new long[]{0x00C02000000C0100L,0x0000000000000200L});
    public static final BitSet FOLLOW_54_in_ruleXSwitchExpression6251 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6263 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6284 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXSwitchExpression6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6390 = new BitSet(new long[]{0x0080000000080000L});
    public static final BitSet FOLLOW_55_in_ruleXCasePart6404 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6425 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXCasePart6439 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXForLoopExpression6552 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXForLoopExpression6564 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6585 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXForLoopExpression6597 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6618 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXForLoopExpression6630 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXWhileExpression6743 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXWhileExpression6755 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6776 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXWhileExpression6788 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXDoWhileExpression6901 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6922 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleXDoWhileExpression6934 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXDoWhileExpression6946 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6967 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXDoWhileExpression6979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXBlockExpression7071 = new BitSet(new long[]{0xBF28A086400601F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7093 = new BitSet(new long[]{0xBF2CA086400601F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_50_in_ruleXBlockExpression7106 = new BitSet(new long[]{0xBF28A086400601F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_18_in_ruleXBlockExpression7122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXVariableDeclaration7340 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_60_in_ruleXVariableDeclaration7371 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7419 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7440 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7469 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleXVariableDeclaration7483 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7598 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7712 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7836 = new BitSet(new long[]{0x2000000040000100L});
    public static final BitSet FOLLOW_30_in_ruleXFeatureCall7850 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7871 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall7884 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7905 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall7919 = new BitSet(new long[]{0x2000000040000100L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7944 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_45_in_ruleXFeatureCall7978 = new BitSet(new long[]{0xA729E086400201F0L,0x000000000000027FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8063 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8091 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFeatureCall8104 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8125 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFeatureCall8142 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleIdOrSuper8295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8394 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleStaticQualifier8412 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXConstructorCall8509 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8532 = new BitSet(new long[]{0x0000A00040000002L});
    public static final BitSet FOLLOW_30_in_ruleXConstructorCall8553 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8575 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8588 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8609 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall8623 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_45_in_ruleXConstructorCall8646 = new BitSet(new long[]{0xA729E086400201F0L,0x000000000000027FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8719 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8747 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXConstructorCall8760 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8781 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXConstructorCall8798 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall8831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXBooleanLiteral8925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXBooleanLiteral8949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXNullLiteral9055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral9101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral9156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXTypeLiteral9350 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXTypeLiteral9362 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9385 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXTypeLiteral9397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXThrowExpression9489 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXReturnExpression9602 = new BitSet(new long[]{0xA728A086400201F2L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXTryCatchFinallyExpression9726 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9777 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_71_in_ruleXTryCatchFinallyExpression9799 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXTryCatchFinallyExpression9843 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXCatchClause9957 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleXCatchClause9970 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9991 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXCatchClause10003 = new BitSet(new long[]{0xA728A086400201F0L,0x000000000000007FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10119 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleQualifiedName10147 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10170 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber10224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber10235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber10279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10307 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10333 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleNumber10353 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10506 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleJvmTypeReference10544 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleJvmTypeReference10556 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXFunctionTypeRef10671 = new BitSet(new long[]{0x0000600000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10693 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_44_in_ruleXFunctionTypeRef10706 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10727 = new BitSet(new long[]{0x0000500000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFunctionTypeRef10743 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleXFunctionTypeRef10757 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10872 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleJvmParameterizedTypeReference10893 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10915 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_44_in_ruleJvmParameterizedTypeReference10928 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10949 = new BitSet(new long[]{0x0000100020000000L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference10963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleJvmWildcardTypeReference11176 = new BitSet(new long[]{0x2000000000010002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJvmUpperBound11310 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleJvmUpperBoundAnded11414 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleJvmLowerBound11518 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalTutorial886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalTutorial1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalTutorial1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalTutorial1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred5_InternalTutorial2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalTutorial2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalTutorial2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalTutorial2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalTutorial2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred10_InternalTutorial3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred11_InternalTutorial3726 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalTutorial3735 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalTutorial3741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred12_InternalTutorial3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred12_InternalTutorial3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred12_InternalTutorial3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred13_InternalTutorial4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4157 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred14_InternalTutorial4164 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4171 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred14_InternalTutorial4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred15_InternalTutorial4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5076 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred16_InternalTutorial5083 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5090 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred16_InternalTutorial5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred18_InternalTutorial5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalTutorial6029 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred19_InternalTutorial6035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred20_InternalTutorial6111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalTutorial6118 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred20_InternalTutorial6124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred21_InternalTutorial7389 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred21_InternalTutorial7398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred22_InternalTutorial7960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8012 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred23_InternalTutorial8019 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8026 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred23_InternalTutorial8040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred24_InternalTutorial8158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred25_InternalTutorial8545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred26_InternalTutorial8638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8668 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_synpred27_InternalTutorial8675 = new BitSet(new long[]{0x0000200000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8682 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_synpred27_InternalTutorial8696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred28_InternalTutorial8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred29_InternalTutorial9616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_synpred30_InternalTutorial9761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred31_InternalTutorial9791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred33_InternalTutorial10138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred34_InternalTutorial10521 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_synpred34_InternalTutorial10525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred35_InternalTutorial10885 = new BitSet(new long[]{0x0000000000000002L});

}
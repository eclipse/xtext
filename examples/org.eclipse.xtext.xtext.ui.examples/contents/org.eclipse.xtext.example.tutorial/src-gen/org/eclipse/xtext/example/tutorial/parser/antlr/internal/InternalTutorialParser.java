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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'entity'", "'extends'", "'{'", "'}'", "':'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'=>'", "'?:'", "'<=>'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'?'", "'&'"
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
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;

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

                if ( (LA7_1==EOF||(LA7_1>=RULE_STRING && LA7_1<=RULE_ID)||(LA7_1>=17 && LA7_1<=19)||(LA7_1>=21 && LA7_1<=50)||(LA7_1>=52 && LA7_1<=75)) ) {
                    alt7=2;
                }
                else if ( (LA7_1==20) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_DECIMAL)||LA7_0==17||LA7_0==30||(LA7_0>=36 && LA7_0<=37)||LA7_0==42||LA7_0==48||LA7_0==50||LA7_0==54||LA7_0==56||(LA7_0>=59 && LA7_0<=61)||LA7_0==64||(LA7_0>=66 && LA7_0<=73)) ) {
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
                case 29:
                    {
                    int LA12_2 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA12_3 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA12_4 = input.LA(2);

                    if ( (synpred5_InternalTutorial()) ) {
                        alt12=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA12_5 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 28:
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
                alt14 = dfa14.predict(input);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1093:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? ) | (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? ) | (kw= '<' kw= '>' ) | kw= '?:' | kw= '<=>' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1096:28: ( (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? ) | (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? ) | (kw= '<' kw= '>' ) | kw= '?:' | kw= '<=>' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1097:1: (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? ) | (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? ) | (kw= '<' kw= '>' ) | kw= '?:' | kw= '<=>' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1097:1: (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? ) | (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? ) | (kw= '<' kw= '>' ) | kw= '?:' | kw= '<=>' )
            int alt17=8;
            alt17 = dfa17.predict(input);
            switch (alt17) {
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
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1112:2: kw= '=>'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpOther2599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1118:6: (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1118:6: (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1119:2: kw= '>' kw= '>' ( ( '>' )=>kw= '>' )?
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther2619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_0()); 
                          
                    }
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther2632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_1()); 
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1130:1: ( ( '>' )=>kw= '>' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==29) && (synpred8_InternalTutorial())) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1130:2: ( '>' )=>kw= '>'
                            {
                            kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther2654); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_3_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1139:6: (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1139:6: (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1140:2: kw= '<' kw= '<' ( ( '<' )=>kw= '<' )?
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2677); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_0()); 
                          
                    }
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_1()); 
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1151:1: ( ( '<' )=>kw= '<' )?
                    int alt16=2;
                    alt16 = dfa16.predict(input);
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1151:2: ( '<' )=>kw= '<'
                            {
                            kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2712); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_4_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1160:6: (kw= '<' kw= '>' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1160:6: (kw= '<' kw= '>' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1161:2: kw= '<' kw= '>'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther2735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_5_0()); 
                          
                    }
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther2748); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1174:2: kw= '?:'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpOther2768); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1181:2: kw= '<=>'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpOther2787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_7()); 
                          
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1194:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1195:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1196:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2827);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2837); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1203:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1206:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1207:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1207:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1208:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2884);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==36) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred10_InternalTutorial()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==37) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred10_InternalTutorial()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1221:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1221:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1221:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1222:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1227:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1228:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1228:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1229:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2937);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1242:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1243:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1243:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1244:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2960);
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1268:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1269:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1270:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2999);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3010); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1277:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1280:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1281:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1281:1: (kw= '+' | kw= '-' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            else if ( (LA19_0==37) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1282:2: kw= '+'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpAdd3048); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1289:2: kw= '-'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpAdd3067); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1302:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1303:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1304:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3107);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3117); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1311:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1314:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1315:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1315:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1316:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3164);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA20_5 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1329:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1329:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1329:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1330:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1335:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1336:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1336:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1337:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3217);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1350:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1351:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1351:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1352:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3240);
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
            	    break loop20;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1376:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1377:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1378:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3279);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3290); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1385:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1388:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1389:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1389:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt21=1;
                }
                break;
            case 39:
                {
                alt21=2;
                }
                break;
            case 40:
                {
                alt21=3;
                }
                break;
            case 41:
                {
                alt21=4;
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1390:2: kw= '*'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpMulti3328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1397:2: kw= '**'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti3347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1404:2: kw= '/'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpMulti3366); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1411:2: kw= '%'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpMulti3385); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1424:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1425:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1426:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3425);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3435); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1433:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1436:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=36 && LA22_0<=37)||LA22_0==42) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)||LA22_0==17||LA22_0==30||LA22_0==48||LA22_0==50||LA22_0==54||LA22_0==56||(LA22_0>=59 && LA22_0<=61)||LA22_0==64||(LA22_0>=66 && LA22_0<=73)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1437:3: ()
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1438:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1443:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1444:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1444:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1445:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3493);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1458:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1459:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1459:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1460:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3514);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1478:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3543);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1494:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1495:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1496:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3579);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3590); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1503:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1506:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1507:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1507:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt23=1;
                }
                break;
            case 37:
                {
                alt23=2;
                }
                break;
            case 36:
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1508:2: kw= '!'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpUnary3628); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1515:2: kw= '-'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpUnary3647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1522:2: kw= '+'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpUnary3666); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1535:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1536:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1537:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3706);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3716); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1544:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1547:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1548:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1548:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1549:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3763);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==43) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred12_InternalTutorial()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1559:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1559:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1559:6: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1560:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXCastedExpression3798); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1569:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1570:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1570:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1571:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3821);
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
            	    break loop24;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1595:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1596:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1597:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3859);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3869); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1604:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1607:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1608:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1608:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1609:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3916);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop32:
            do {
                int alt32=3;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (synpred13_InternalTutorial()) ) {
                        alt32=1;
                    }
                    else if ( (synpred14_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (synpred14_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (synpred14_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1623:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1623:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1623:26: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1624:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall3965); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1633:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1634:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1634:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1635:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3988);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4004);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1656:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1657:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1657:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1658:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4026);
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
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1691:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1691:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1691:8: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1692:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1697:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt25=3;
            	    switch ( input.LA(1) ) {
            	    case 44:
            	        {
            	        alt25=1;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt25=2;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt25=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt25) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1697:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4112); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1702:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1702:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1703:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1703:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1704:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4136); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1718:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1718:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1719:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1719:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1720:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,46,FOLLOW_46_in_ruleXMemberFeatureCall4173); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1733:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==30) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1733:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleXMemberFeatureCall4202); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1737:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1738:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1738:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1739:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4223);
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

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1755:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop26:
            	            do {
            	                int alt26=2;
            	                int LA26_0 = input.LA(1);

            	                if ( (LA26_0==47) ) {
            	                    alt26=1;
            	                }


            	                switch (alt26) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1755:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,47,FOLLOW_47_in_ruleXMemberFeatureCall4236); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1759:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1760:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1760:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1761:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4257);
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
            	            	    break loop26;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleXMemberFeatureCall4271); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1781:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1782:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1782:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1783:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4296);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt30=2;
            	    alt30 = dfa30.predict(input);
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1803:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1804:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,48,FOLLOW_48_in_ruleXMemberFeatureCall4330); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt29=3;
            	            alt29 = dfa29.predict(input);
            	            switch (alt29) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1834:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1835:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4415);
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
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1852:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1852:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1852:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1852:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1853:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1853:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1854:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4443);
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

            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1870:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop28:
            	                    do {
            	                        int alt28=2;
            	                        int LA28_0 = input.LA(1);

            	                        if ( (LA28_0==47) ) {
            	                            alt28=1;
            	                        }


            	                        switch (alt28) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1870:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,47,FOLLOW_47_in_ruleXMemberFeatureCall4456); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1874:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1875:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1875:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1876:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4477);
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
            	                    	    break loop28;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,49,FOLLOW_49_in_ruleXMemberFeatureCall4494); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt31=2;
            	    alt31 = dfa31.predict(input);
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:4: ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1899:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1900:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4529);
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1924:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1925:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1926:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4569);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4579); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1933:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1936:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1937:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1937:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt33=13;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1938:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4626);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1948:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4653);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1958:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4680);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1968:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4707);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1978:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4734);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1988:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4761);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1998:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4788);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2008:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4815);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2018:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4842);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2028:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4869);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2038:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4896);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2048:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4923);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2058:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4950);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2074:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2075:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2076:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4985);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4995); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2083:1: ruleXLiteral returns [EObject current=null] : ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2086:28: ( ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:1: ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:1: ( ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure ) | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt34=6;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==50) && (synpred18_InternalTutorial())) {
                alt34=1;
            }
            else if ( ((LA34_0>=67 && LA34_0<=68)) ) {
                alt34=2;
            }
            else if ( ((LA34_0>=RULE_HEX && LA34_0<=RULE_DECIMAL)) ) {
                alt34=3;
            }
            else if ( (LA34_0==69) ) {
                alt34=4;
            }
            else if ( (LA34_0==RULE_STRING) ) {
                alt34=5;
            }
            else if ( (LA34_0==70) ) {
                alt34=6;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:2: ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:2: ( ( ( () '[' ) )=>this_XClosure_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:3: ( ( () '[' ) )=>this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5055);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2100:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5083);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2110:5: this_XNumberLiteral_2= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5110);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2120:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5137);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2130:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5164);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2140:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5191);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2156:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2157:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2158:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5226);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5236); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2165:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2168:28: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2169:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2169:1: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2169:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2169:2: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2169:3: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2171:5: ( () otherlv_1= '[' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2171:6: () otherlv_1= '['
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2171:6: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2172:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXClosure5296); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
                  
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ID||LA36_0==33||LA36_0==48) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2197:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2197:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2198:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5369);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2214:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==47) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2214:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5382); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2218:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2219:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2219:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2220:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5403);
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
                            	    break loop35;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2236:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2237:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2237:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2238:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,51,FOLLOW_51_in_ruleXClosure5425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
                          
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2251:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2252:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2252:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2253:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5462);
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

            otherlv_7=(Token)match(input,52,FOLLOW_52_in_ruleXClosure5474); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
                  
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2281:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2282:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2283:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5510);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5520); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2290:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2293:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2294:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2294:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2294:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2294:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2295:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2300:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||LA39_0==17||LA39_0==30||(LA39_0>=36 && LA39_0<=37)||LA39_0==42||LA39_0==48||LA39_0==50||LA39_0==54||LA39_0==56||(LA39_0>=59 && LA39_0<=64)||(LA39_0>=66 && LA39_0<=73)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2300:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2300:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2301:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2301:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2302:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5576);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2318:2: (otherlv_2= ';' )?
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==53) ) {
            	        alt38=1;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2318:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleXExpressionInClosure5589); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2330:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2331:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2332:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5629);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5639); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2339:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2342:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2343:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2359:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2359:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2359:7: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2360:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2365:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||LA41_0==33||LA41_0==48) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2365:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2365:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2366:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2366:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2367:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5747);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2383:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==47) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2383:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXShortClosure5760); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2387:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2388:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2388:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2389:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5781);
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
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2405:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2406:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2406:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2407:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,51,FOLLOW_51_in_ruleXShortClosure5803); if (state.failed) return current;
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2420:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2421:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2421:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2422:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5839);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2446:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2447:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2448:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5875);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5885); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2455:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2458:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleXParenthesizedExpression5922); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5944);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleXParenthesizedExpression5955); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2484:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2485:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2486:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5991);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6001); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2493:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2496:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2497:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2497:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2497:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2497:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2498:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXIfExpression6047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleXIfExpression6059); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2511:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2512:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2512:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2513:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6080);
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

            otherlv_4=(Token)match(input,49,FOLLOW_49_in_ruleXIfExpression6092); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2533:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2534:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2534:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2535:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6113);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==55) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred22_InternalTutorial()) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,55,FOLLOW_55_in_ruleXIfExpression6134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2556:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2557:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2557:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2558:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6156);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2582:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2583:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2584:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6194);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6204); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2591:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2594:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2595:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2595:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2595:2: () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2595:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2596:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXSwitchExpression6250); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:1: ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||LA44_0==17||LA44_0==30||(LA44_0>=36 && LA44_0<=37)||LA44_0==42||LA44_0==50||LA44_0==54||LA44_0==56||(LA44_0>=59 && LA44_0<=61)||LA44_0==64||(LA44_0>=66 && LA44_0<=73)) ) {
                alt44=1;
            }
            else if ( (LA44_0==48) ) {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==RULE_ID) ) {
                    int LA44_3 = input.LA(3);

                    if ( ((LA44_3>=20 && LA44_3<=41)||(LA44_3>=43 && LA44_3<=46)||(LA44_3>=48 && LA44_3<=50)||LA44_3==65) ) {
                        alt44=1;
                    }
                    else if ( (LA44_3==19) && (synpred24_InternalTutorial())) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA44_2>=RULE_STRING && LA44_2<=RULE_DECIMAL)||LA44_2==17||LA44_2==30||(LA44_2>=36 && LA44_2<=37)||LA44_2==42||LA44_2==48||LA44_2==50||LA44_2==54||LA44_2==56||(LA44_2>=59 && LA44_2<=61)||LA44_2==64||(LA44_2>=66 && LA44_2<=73)) ) {
                    alt44=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==RULE_ID) ) {
                        int LA43_1 = input.LA(2);

                        if ( (LA43_1==19) && (synpred23_InternalTutorial())) {
                            alt43=1;
                        }
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:4: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2610:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2610:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2610:6: ( (lv_localVarName_2_0= ruleValidID ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2611:1: (lv_localVarName_2_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2611:1: (lv_localVarName_2_0= ruleValidID )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2612:3: lv_localVarName_2_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6293);
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

                            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6305); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_1());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2632:4: ( (lv_switch_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2633:1: (lv_switch_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2633:1: (lv_switch_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2634:3: lv_switch_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6329);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2657:5: (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2657:7: otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':'
                    {
                    otherlv_5=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_1_0_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2661:1: ( (lv_localVarName_6_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2662:1: (lv_localVarName_6_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2662:1: (lv_localVarName_6_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2663:3: lv_localVarName_6_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6394);
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

                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6406); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_2());
                          
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2683:3: ( (lv_switch_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2684:1: (lv_switch_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2684:1: (lv_switch_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2685:3: lv_switch_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6429);
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

                    otherlv_9=(Token)match(input,49,FOLLOW_49_in_ruleXSwitchExpression6441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6455); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2709:1: ( (lv_cases_11_0= ruleXCasePart ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID||LA45_0==19||LA45_0==33||LA45_0==48||LA45_0==58) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2710:1: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2710:1: (lv_cases_11_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2711:3: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6476);
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
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2727:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==57) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2727:5: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,57,FOLLOW_57_in_ruleXSwitchExpression6490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleXSwitchExpression6502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2735:1: ( (lv_default_14_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2736:1: (lv_default_14_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2736:1: (lv_default_14_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2737:3: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6523);
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

            otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleXSwitchExpression6537); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2765:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2766:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6573);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6583); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2774:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2777:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID||LA47_0==33||LA47_0==48) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2779:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2779:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2780:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6629);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2796:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==58) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2796:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXCasePart6643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2800:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2801:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2801:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2802:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6664);
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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleXCasePart6678); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2822:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2823:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2823:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2824:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6699);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2848:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2849:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2850:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6735);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6745); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2857:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2860:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2861:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2861:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2861:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2861:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2862:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXForLoopExpression6791); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleXForLoopExpression6803); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2875:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2876:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2876:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2877:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6824);
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

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleXForLoopExpression6836); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2897:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2898:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2898:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2899:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6857);
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

            otherlv_6=(Token)match(input,49,FOLLOW_49_in_ruleXForLoopExpression6869); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2919:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2920:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2920:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2921:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6890);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2945:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2946:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2947:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6926);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6936); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2954:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2957:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2958:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2958:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2958:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2958:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2959:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXWhileExpression6982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleXWhileExpression6994); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2972:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2973:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2973:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2974:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7015);
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

            otherlv_4=(Token)match(input,49,FOLLOW_49_in_ruleXWhileExpression7027); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2994:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2995:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2995:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2996:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7048);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3020:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3021:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3022:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7084);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7094); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3029:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3032:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3033:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3033:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3033:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3033:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3034:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXDoWhileExpression7140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3043:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3044:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3044:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3045:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7161);
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

            otherlv_3=(Token)match(input,60,FOLLOW_60_in_ruleXDoWhileExpression7173); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXDoWhileExpression7185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3069:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3070:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3070:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3071:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7206);
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

            otherlv_6=(Token)match(input,49,FOLLOW_49_in_ruleXDoWhileExpression7218); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3099:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3100:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3101:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7254);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7264); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3108:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3111:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3112:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3112:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3112:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3112:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3113:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXBlockExpression7310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3122:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==17||LA50_0==30||(LA50_0>=36 && LA50_0<=37)||LA50_0==42||LA50_0==48||LA50_0==50||LA50_0==54||LA50_0==56||(LA50_0>=59 && LA50_0<=64)||(LA50_0>=66 && LA50_0<=73)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3122:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3122:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3123:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3123:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3124:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7332);
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

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3140:2: (otherlv_3= ';' )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==53) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3140:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXBlockExpression7345); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleXBlockExpression7361); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3156:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3157:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3158:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7397);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7407); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3165:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3168:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3169:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3169:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=62 && LA51_0<=63)) ) {
                alt51=1;
            }
            else if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_ID)||LA51_0==17||LA51_0==30||(LA51_0>=36 && LA51_0<=37)||LA51_0==42||LA51_0==48||LA51_0==50||LA51_0==54||LA51_0==56||(LA51_0>=59 && LA51_0<=61)||LA51_0==64||(LA51_0>=66 && LA51_0<=73)) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3170:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7454);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3180:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7481);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3196:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3197:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3198:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7516);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7526); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3205:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3208:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3209:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3209:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3209:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3209:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3210:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3215:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==62) ) {
                alt52=1;
            }
            else if ( (LA52_0==63) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3215:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3215:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3216:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3216:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3217:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,62,FOLLOW_62_in_ruleXVariableDeclaration7579); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3231:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleXVariableDeclaration7610); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred25_InternalTutorial()) ) {
                    alt53=1;
                }
                else if ( (true) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA53_0==48) && (synpred25_InternalTutorial())) {
                alt53=1;
            }
            else if ( (LA53_0==33) && (synpred25_InternalTutorial())) {
                alt53=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3243:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3243:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3243:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3244:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3244:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3245:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7658);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3261:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3262:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3262:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3263:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7679);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3280:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3280:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3281:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3281:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3282:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7708);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3298:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==20) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3298:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleXVariableDeclaration7722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3302:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3303:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3303:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3304:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7743);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3328:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3329:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3330:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7781);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7791); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3337:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3340:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3341:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3341:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3341:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3341:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==RULE_ID||LA55_1==30||LA55_1==44||LA55_1==50) ) {
                    alt55=1;
                }
            }
            else if ( (LA55_0==33||LA55_0==48) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3342:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3342:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3343:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7837);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3359:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3360:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3360:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3361:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7859);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3385:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3386:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3387:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7895);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7905); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3394:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3397:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3399:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3399:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3400:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7951);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3416:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3417:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3417:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3418:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7972);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3442:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3443:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3444:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8008);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall8018); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3451:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3454:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3455:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3455:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3455:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3455:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3456:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3461:2: ( ( ruleStaticQualifier ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==65) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3462:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3462:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3463:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8075);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3476:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==30) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3476:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXFeatureCall8089); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3480:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3481:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3481:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3482:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8110);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3498:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==47) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3498:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXFeatureCall8123); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3502:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3503:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3503:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3504:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8144);
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
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleXFeatureCall8158); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3524:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3525:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3525:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3526:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8183);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3546:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3547:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,48,FOLLOW_48_in_ruleXFeatureCall8217); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt60=3;
                    alt60 = dfa60.predict(input);
                    switch (alt60) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3577:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3578:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8302);
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
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3595:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3595:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3595:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3595:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3596:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3596:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3597:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8330);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3613:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==47) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3613:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleXFeatureCall8343); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3617:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3618:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3618:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3619:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8364);
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
                            	    break loop59;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,49,FOLLOW_49_in_ruleXFeatureCall8381); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:4: ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3642:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3643:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8416);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3667:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3668:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3669:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8454);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8465); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3679:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3680:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3680:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            else if ( (LA63_0==64) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8512);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3693:2: kw= 'super'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleIdOrSuper8536); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3706:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3707:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3708:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8577);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8588); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3715:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3718:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3719:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3719:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==65) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3720:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8635);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,65,FOLLOW_65_in_ruleStaticQualifier8653); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3744:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3745:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3746:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8694);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8704); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3753:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3756:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3757:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3757:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3757:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3757:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3758:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXConstructorCall8750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3767:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3768:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3768:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3769:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8773);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:3: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:3: ( ( '<' )=>otherlv_3= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:4: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleXConstructorCall8794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3787:2: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3788:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3788:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3789:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8816);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3805:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==47) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3805:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleXConstructorCall8829); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3809:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3810:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3810:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3811:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8850);
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
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleXConstructorCall8864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:4: ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:4: ( ( '(' )=>otherlv_8= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:5: ( '(' )=>otherlv_8= '('
                    {
                    otherlv_8=(Token)match(input,48,FOLLOW_48_in_ruleXConstructorCall8887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt68=3;
                    alt68 = dfa68.predict(input);
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3853:1: (lv_arguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3854:3: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8960);
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
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:7: ( (lv_arguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3872:1: (lv_arguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3872:1: (lv_arguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3873:3: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8988);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3889:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==47) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3889:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleXConstructorCall9001); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3893:1: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3894:1: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3894:1: (lv_arguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3895:3: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9022);
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
                            	    break loop67;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,49,FOLLOW_49_in_ruleXConstructorCall9039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3918:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3919:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall9074);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3943:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3944:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3945:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9111);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9121); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3952:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3955:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3957:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3962:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==67) ) {
                alt71=1;
            }
            else if ( (LA71_0==68) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3962:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXBooleanLiteral9168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3967:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3967:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3968:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3968:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3969:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,68,FOLLOW_68_in_ruleXBooleanLiteral9192); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3990:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3991:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3992:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9242);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9252); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3999:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4002:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4003:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4003:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4003:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4003:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4004:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXNullLiteral9298); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4021:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4022:2: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4023:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9334);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral9344); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4030:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4033:28: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:2: () ( (lv_value_1_0= ruleNumber ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4035:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4040:2: ( (lv_value_1_0= ruleNumber ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4041:1: (lv_value_1_0= ruleNumber )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4041:1: (lv_value_1_0= ruleNumber )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4042:3: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumber_in_ruleXNumberLiteral9399);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4066:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4067:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4068:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9435);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9445); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4075:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4078:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4079:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4079:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4079:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4079:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4080:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4085:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4086:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4086:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4087:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9496); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4111:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4112:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4113:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9537);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9547); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4120:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4123:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4124:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4124:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4124:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4124:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4125:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleXTypeLiteral9593); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleXTypeLiteral9605); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4138:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4139:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4139:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4140:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9628);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,49,FOLLOW_49_in_ruleXTypeLiteral9640); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4165:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4166:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4167:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9676);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9686); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4174:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4177:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4178:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4178:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4178:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4178:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4179:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleXThrowExpression9732); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4188:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4189:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4189:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4190:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9753);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4214:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4215:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4216:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9789);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9799); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4223:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4226:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4227:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4227:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4227:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4227:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4228:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXReturnExpression9845); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4237:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4237:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4242:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4243:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9876);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4267:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4268:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4269:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9913);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9923); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4276:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4279:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4280:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4280:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4280:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4280:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4281:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_73_in_ruleXTryCatchFinallyExpression9969); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4290:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4291:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4291:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4292:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9990);
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

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==75) ) {
                alt75=1;
            }
            else if ( (LA75_0==74) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==75) ) {
                            int LA73_2 = input.LA(2);

                            if ( (synpred34_InternalTutorial()) ) {
                                alt73=1;
                            }


                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4310:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4311:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10020);
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
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==74) ) {
                        int LA74_1 = input.LA(2);

                        if ( (synpred35_InternalTutorial()) ) {
                            alt74=1;
                        }
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,74,FOLLOW_74_in_ruleXTryCatchFinallyExpression10042); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4332:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4333:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4333:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4334:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10064);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4351:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4351:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4351:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,74,FOLLOW_74_in_ruleXTryCatchFinallyExpression10086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4355:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4356:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4356:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4357:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10107);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4381:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4382:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4383:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10145);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10155); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4390:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4393:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4394:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4394:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4394:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4394:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4394:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleXCatchClause10200); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXCatchClause10213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4403:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4404:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4404:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4405:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10234);
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

            otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleXCatchClause10246); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4425:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4426:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4426:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4427:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10267);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4451:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4452:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4453:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10304);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10315); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4460:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4463:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4464:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4464:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4465:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10362);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==44) ) {
                    int LA76_2 = input.LA(2);

                    if ( (LA76_2==RULE_ID) ) {
                        int LA76_3 = input.LA(3);

                        if ( (synpred37_InternalTutorial()) ) {
                            alt76=1;
                        }


                    }


                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,44,FOLLOW_44_in_ruleQualifiedName10390); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10413);
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
            	    break loop76;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4502:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4506:2: (iv_ruleNumber= ruleNumber EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4507:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber10467);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber10478); if (state.failed) return current;

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4517:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4521:28: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4522:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4522:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_HEX) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_INT && LA80_0<=RULE_DECIMAL)) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4522:6: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber10522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4530:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4530:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4530:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4530:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_INT) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==RULE_DECIMAL) ) {
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
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4530:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10550); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4538:10: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10576); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_DECIMAL_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4545:2: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==44) ) {
                        int LA79_1 = input.LA(2);

                        if ( ((LA79_1>=RULE_INT && LA79_1<=RULE_DECIMAL)) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4546:2: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleNumber10596); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); 
                                  
                            }
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4551:1: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==RULE_INT) ) {
                                alt78=1;
                            }
                            else if ( (LA78_0==RULE_DECIMAL) ) {
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
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4551:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10612); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_INT_4);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4559:10: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10638); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4577:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4578:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4579:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10691);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10701); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4586:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4589:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4590:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4590:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            else if ( (LA82_0==33||LA82_0==48) ) {
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4590:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4590:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4591:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10749);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==50) ) {
                            int LA81_2 = input.LA(2);

                            if ( (LA81_2==52) ) {
                                int LA81_3 = input.LA(3);

                                if ( (synpred38_InternalTutorial()) ) {
                                    alt81=1;
                                }


                            }


                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4602:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4602:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4602:6: ()
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4603:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleJvmTypeReference10787); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleJvmTypeReference10799); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4618:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10831);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4634:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4635:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4636:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10866);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10876); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4643:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4646:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4647:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4647:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4647:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4647:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==48) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4647:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleXFunctionTypeRef10914); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4651:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==RULE_ID||LA84_0==33||LA84_0==48) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4651:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4651:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4652:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4652:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4653:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10936);
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

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4669:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==47) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4669:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXFunctionTypeRef10949); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4673:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4674:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4674:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4675:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10970);
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


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,49,FOLLOW_49_in_ruleXFunctionTypeRef10986); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleXFunctionTypeRef11000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4699:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4700:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4700:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4701:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11021);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4725:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4726:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4727:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11057);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11067); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4734:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4737:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4739:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4739:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4740:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11115);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleJvmParameterizedTypeReference11136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4758:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4759:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4759:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4760:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11158);
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

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4776:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==47) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4776:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleJvmParameterizedTypeReference11171); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4780:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4781:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4781:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4782:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11192);
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
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleJvmParameterizedTypeReference11206); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4810:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4811:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4812:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11244);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11254); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4819:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4822:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4823:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4823:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID||LA88_0==33||LA88_0==48) ) {
                alt88=1;
            }
            else if ( (LA88_0==76) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4824:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11301);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4834:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11328);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4850:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4851:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4852:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11363);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11373); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4859:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4862:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4863:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4863:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4863:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4863:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4864:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleJvmWildcardTypeReference11419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt89=3;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==16) ) {
                alt89=1;
            }
            else if ( (LA89_0==64) ) {
                alt89=2;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4874:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4874:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4875:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11441);
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
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4892:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4892:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4893:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4893:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4894:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11468);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4918:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4919:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4920:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11506);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11516); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4927:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4930:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4931:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4931:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4931:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJvmUpperBound11553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4935:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4936:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4936:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4937:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11574);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4961:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4962:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4963:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11610);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11620); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4970:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4973:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4974:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4974:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4974:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_77_in_ruleJvmUpperBoundAnded11657); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4978:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4979:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4979:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4980:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11678);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5004:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5005:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5006:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11714);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11724); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5013:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5016:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5017:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5017:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5017:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleJvmLowerBound11761); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5021:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5022:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5022:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5023:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11782);
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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5049:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5050:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5051:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11821);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11832); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5058:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5061:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5062:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11871); if (state.failed) return current;
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
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1130:2: ( '>' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1131:2: '>'
        {
        match(input,29,FOLLOW_29_in_synpred8_InternalTutorial2645); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalTutorial

    // $ANTLR start synpred9_InternalTutorial
    public final void synpred9_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1151:2: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1152:2: '<'
        {
        match(input,30,FOLLOW_30_in_synpred9_InternalTutorial2703); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalTutorial

    // $ANTLR start synpred10_InternalTutorial
    public final void synpred10_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1217:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1217:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1218:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1218:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1219:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred10_InternalTutorial2905);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalTutorial

    // $ANTLR start synpred11_InternalTutorial
    public final void synpred11_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1325:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1325:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1326:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1326:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1327:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred11_InternalTutorial3185);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalTutorial

    // $ANTLR start synpred12_InternalTutorial
    public final void synpred12_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:4: ( () 'as' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:5: () 'as'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1557:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1558:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred12_InternalTutorial3779); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalTutorial

    // $ANTLR start synpred13_InternalTutorial
    public final void synpred13_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1617:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1618:1: 
        {
        }

        match(input,44,FOLLOW_44_in_synpred13_InternalTutorial3933); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1619:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1620:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1620:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1621:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred13_InternalTutorial3942);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred13_InternalTutorial3948);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalTutorial

    // $ANTLR start synpred14_InternalTutorial
    public final void synpred14_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:10: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1676:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1676:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt90=3;
        switch ( input.LA(1) ) {
        case 44:
            {
            alt90=1;
            }
            break;
        case 45:
            {
            alt90=2;
            }
            break;
        case 46:
            {
            alt90=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 90, 0, input);

            throw nvae;
        }

        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1676:4: '.'
                {
                match(input,44,FOLLOW_44_in_synpred14_InternalTutorial4051); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1678:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1678:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1679:1: ( '?.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1679:1: ( '?.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1680:2: '?.'
                {
                match(input,45,FOLLOW_45_in_synpred14_InternalTutorial4065); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1685:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1685:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1686:1: ( '*.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1686:1: ( '*.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1687:2: '*.'
                {
                match(input,46,FOLLOW_46_in_synpred14_InternalTutorial4085); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred14_InternalTutorial

    // $ANTLR start synpred15_InternalTutorial
    public final void synpred15_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1797:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1797:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1798:2: '('
        {
        match(input,48,FOLLOW_48_in_synpred15_InternalTutorial4312); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalTutorial

    // $ANTLR start synpred16_InternalTutorial
    public final void synpred16_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1817:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1818:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1818:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==33||LA92_0==48) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1818:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1818:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1819:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1819:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial4364);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1822:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==47) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1822:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,47,FOLLOW_47_in_synpred16_InternalTutorial4371); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1823:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1824:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1824:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1825:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial4378);
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

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1827:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1828:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1828:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1829:2: '|'
        {
        match(input,51,FOLLOW_51_in_synpred16_InternalTutorial4392); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalTutorial

    // $ANTLR start synpred17_InternalTutorial
    public final void synpred17_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:5: ( () '[' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:5: ( () '[' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:6: () '['
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1896:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1897:1: 
        {
        }

        match(input,50,FOLLOW_50_in_synpred17_InternalTutorial4512); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalTutorial

    // $ANTLR start synpred18_InternalTutorial
    public final void synpred18_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:3: ( ( () '[' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:4: ( () '[' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:4: ( () '[' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:5: () '['
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2087:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2088:1: 
        {
        }

        match(input,50,FOLLOW_50_in_synpred18_InternalTutorial5036); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalTutorial

    // $ANTLR start synpred20_InternalTutorial
    public final void synpred20_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:6: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID||LA94_0==33||LA94_0==48) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:7: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2181:7: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2182:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2182:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2183:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalTutorial5315);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2185:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==47) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2185:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,47,FOLLOW_47_in_synpred20_InternalTutorial5322); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2186:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2187:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2187:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2188:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalTutorial5329);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop93;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2190:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2191:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2191:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2192:2: '|'
        {
        match(input,51,FOLLOW_51_in_synpred20_InternalTutorial5343); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalTutorial

    // $ANTLR start synpred22_InternalTutorial
    public final void synpred22_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:4: ( 'else' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2551:6: 'else'
        {
        match(input,55,FOLLOW_55_in_synpred22_InternalTutorial6126); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalTutorial

    // $ANTLR start synpred23_InternalTutorial
    public final void synpred23_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:4: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:5: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:5: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:6: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2605:6: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2606:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2606:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2607:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred23_InternalTutorial6268);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,19,FOLLOW_19_in_synpred23_InternalTutorial6274); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalTutorial

    // $ANTLR start synpred24_InternalTutorial
    public final void synpred24_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:9: ( '(' ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:9: ( '(' ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:11: '(' ( ( ruleValidID ) ) ':'
        {
        match(input,48,FOLLOW_48_in_synpred24_InternalTutorial6350); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2652:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2653:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2653:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2654:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred24_InternalTutorial6357);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,19,FOLLOW_19_in_synpred24_InternalTutorial6363); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalTutorial

    // $ANTLR start synpred25_InternalTutorial
    public final void synpred25_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3235:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3236:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3236:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3237:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred25_InternalTutorial7628);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3239:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3240:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3240:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3241:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred25_InternalTutorial7637);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalTutorial

    // $ANTLR start synpred26_InternalTutorial
    public final void synpred26_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3539:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3540:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3540:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3541:2: '('
        {
        match(input,48,FOLLOW_48_in_synpred26_InternalTutorial8199); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalTutorial

    // $ANTLR start synpred27_InternalTutorial
    public final void synpred27_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==RULE_ID||LA98_0==33||LA98_0==48) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3561:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3562:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3562:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3563:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8251);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3565:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop97:
                do {
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==47) ) {
                        alt97=1;
                    }


                    switch (alt97) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3565:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,47,FOLLOW_47_in_synpred27_InternalTutorial8258); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3566:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3567:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3567:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3568:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8265);
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

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3570:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3572:2: '|'
        {
        match(input,51,FOLLOW_51_in_synpred27_InternalTutorial8279); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalTutorial

    // $ANTLR start synpred28_InternalTutorial
    public final void synpred28_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:5: ( () '[' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:5: ( () '[' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:6: () '['
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3639:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3640:1: 
        {
        }

        match(input,50,FOLLOW_50_in_synpred28_InternalTutorial8399); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalTutorial

    // $ANTLR start synpred29_InternalTutorial
    public final void synpred29_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3782:6: '<'
        {
        match(input,30,FOLLOW_30_in_synpred29_InternalTutorial8786); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalTutorial

    // $ANTLR start synpred30_InternalTutorial
    public final void synpred30_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:5: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3831:7: '('
        {
        match(input,48,FOLLOW_48_in_synpred30_InternalTutorial8879); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalTutorial

    // $ANTLR start synpred31_InternalTutorial
    public final void synpred31_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( (LA100_0==RULE_ID||LA100_0==33||LA100_0==48) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3838:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3838:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3839:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalTutorial8909);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3841:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop99:
                do {
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==47) ) {
                        alt99=1;
                    }


                    switch (alt99) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3841:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,47,FOLLOW_47_in_synpred31_InternalTutorial8916); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3842:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3843:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3843:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3844:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalTutorial8923);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop99;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3846:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3847:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3847:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3848:2: '|'
        {
        match(input,51,FOLLOW_51_in_synpred31_InternalTutorial8937); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred31_InternalTutorial

    // $ANTLR start synpred32_InternalTutorial
    public final void synpred32_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:4: ( ( () '[' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:5: ( () '[' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:5: ( () '[' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:6: () '['
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3915:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3916:1: 
        {
        }

        match(input,50,FOLLOW_50_in_synpred32_InternalTutorial9057); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalTutorial

    // $ANTLR start synpred33_InternalTutorial
    public final void synpred33_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4237:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4238:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4238:1: ( ruleXExpression )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4239:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred33_InternalTutorial9859);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred33_InternalTutorial

    // $ANTLR start synpred34_InternalTutorial
    public final void synpred34_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:5: ( 'catch' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:7: 'catch'
        {
        match(input,75,FOLLOW_75_in_synpred34_InternalTutorial10004); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalTutorial

    // $ANTLR start synpred35_InternalTutorial
    public final void synpred35_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:5: ( 'finally' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4327:7: 'finally'
        {
        match(input,74,FOLLOW_74_in_synpred35_InternalTutorial10034); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalTutorial

    // $ANTLR start synpred37_InternalTutorial
    public final void synpred37_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:3: ( '.' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4476:2: '.'
        {
        match(input,44,FOLLOW_44_in_synpred37_InternalTutorial10381); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalTutorial

    // $ANTLR start synpred38_InternalTutorial
    public final void synpred38_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:3: ( () '[' ']' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:4: () '[' ']'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4599:4: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4600:1: 
        {
        }

        match(input,50,FOLLOW_50_in_synpred38_InternalTutorial10764); if (state.failed) return ;
        match(input,52,FOLLOW_52_in_synpred38_InternalTutorial10768); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred38_InternalTutorial

    // $ANTLR start synpred39_InternalTutorial
    public final void synpred39_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4753:6: '<'
        {
        match(input,30,FOLLOW_30_in_synpred39_InternalTutorial11128); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalTutorial

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
    public final boolean synpred17_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalTutorial_fragment(); // can never throw exception
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
    public final boolean synpred32_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalTutorial_fragment(); // can never throw exception
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
    public final boolean synpred39_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalTutorial_fragment(); // can never throw exception
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
    public final boolean synpred37_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalTutorial_fragment(); // can never throw exception
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


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA87 dfa87 = new DFA87(this);
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\1\1\11\uffff";
    static final String DFA14_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA14_maxS =
        "\1\113\1\uffff\7\0\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA14_specialS =
        "\2\uffff\1\3\1\2\1\1\1\0\1\6\1\5\1\4\1\uffff}>";
    static final String[] DFA14_transitionS = {
            "\5\1\10\uffff\3\1\1\uffff\10\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10"+
            "\17\1\1\uffff\15\1\1\uffff\12\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 1032:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_5 = input.LA(1);

                         
                        int index14_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_8 = input.LA(1);

                         
                        int index14_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_7 = input.LA(1);

                         
                        int index14_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_6 = input.LA(1);

                         
                        int index14_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalTutorial()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\12\uffff";
    static final String DFA17_eofS =
        "\12\uffff";
    static final String DFA17_minS =
        "\1\35\4\uffff\1\35\4\uffff";
    static final String DFA17_maxS =
        "\1\43\4\uffff\1\36\4\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\6\1\5";
    static final String DFA17_specialS =
        "\12\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\4\1\5\1\1\1\2\1\3\1\6\1\7",
            "",
            "",
            "",
            "",
            "\1\10\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1097:1: (kw= '->' | kw= '..' | kw= '=>' | (kw= '>' kw= '>' ( ( '>' )=>kw= '>' )? ) | (kw= '<' kw= '<' ( ( '<' )=>kw= '<' )? ) | (kw= '<' kw= '>' ) | kw= '?:' | kw= '<=>' )";
        }
    }
    static final String DFA16_eotS =
        "\35\uffff";
    static final String DFA16_eofS =
        "\1\2\34\uffff";
    static final String DFA16_minS =
        "\1\4\1\0\33\uffff";
    static final String DFA16_maxS =
        "\1\111\1\0\33\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\31\uffff\1\1";
    static final String DFA16_specialS =
        "\1\uffff\1\0\33\uffff}>";
    static final String[] DFA16_transitionS = {
            "\5\2\10\uffff\1\2\14\uffff\1\1\5\uffff\2\2\4\uffff\1\2\5\uffff"+
            "\1\2\1\uffff\1\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\2\uffff"+
            "\1\2\1\uffff\10\2",
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1151:1: ( ( '<' )=>kw= '<' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalTutorial()) ) {s = 28;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\100\uffff";
    static final String DFA30_eofS =
        "\1\2\77\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA30_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA30_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\33\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\12\2",
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1796:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_1 = input.LA(1);

                         
                        int index30_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index30_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\36\uffff";
    static final String DFA29_eofS =
        "\36\uffff";
    static final String DFA29_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA29_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA29_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA29_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\1\3\2\uffff\2\5\4"+
            "\uffff\1\5\5\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5"+
            "\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            return "1817:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_0 = input.LA(1);

                         
                        int index29_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_0==RULE_ID) ) {s = 1;}

                        else if ( (LA29_0==48) ) {s = 2;}

                        else if ( (LA29_0==33) && (synpred16_InternalTutorial())) {s = 3;}

                        else if ( (LA29_0==51) && (synpred16_InternalTutorial())) {s = 4;}

                        else if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_DECIMAL)||LA29_0==17||LA29_0==30||(LA29_0>=36 && LA29_0<=37)||LA29_0==42||LA29_0==50||LA29_0==54||LA29_0==56||(LA29_0>=59 && LA29_0<=61)||LA29_0==64||(LA29_0>=66 && LA29_0<=73)) ) {s = 5;}

                        else if ( (LA29_0==49) ) {s = 29;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_2);
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
    static final String DFA31_eotS =
        "\100\uffff";
    static final String DFA31_eofS =
        "\1\2\77\uffff";
    static final String DFA31_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA31_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA31_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA31_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\35\2\1\1\1\uffff\15\2\1\uffff\12\2",
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

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1896:3: ( ( ( () '[' ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\16\uffff";
    static final String DFA33_eofS =
        "\16\uffff";
    static final String DFA33_minS =
        "\1\4\15\uffff";
    static final String DFA33_maxS =
        "\1\111\15\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15";
    static final String DFA33_specialS =
        "\16\uffff}>";
    static final String[] DFA33_transitionS = {
            "\4\5\1\4\10\uffff\1\2\14\uffff\1\4\21\uffff\1\15\1\uffff\1\5"+
            "\3\uffff\1\6\1\uffff\1\3\2\uffff\1\7\1\10\1\11\2\uffff\1\4\1"+
            "\uffff\1\1\4\5\1\12\1\13\1\14",
            "",
            "",
            "",
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

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1937:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )";
        }
    }
    static final String DFA37_eotS =
        "\40\uffff";
    static final String DFA37_eofS =
        "\40\uffff";
    static final String DFA37_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA37_maxS =
        "\1\111\2\0\35\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\2\1\1\2\32\uffff";
    static final String DFA37_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA37_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\1\3\2\uffff\2\5\4"+
            "\uffff\1\5\5\uffff\1\2\1\uffff\1\5\1\4\1\5\1\uffff\1\5\1\uffff"+
            "\1\5\2\uffff\6\5\1\uffff\10\5",
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2181:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_0 = input.LA(1);

                         
                        int index37_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA37_0==RULE_ID) ) {s = 1;}

                        else if ( (LA37_0==48) ) {s = 2;}

                        else if ( (LA37_0==33) && (synpred20_InternalTutorial())) {s = 3;}

                        else if ( (LA37_0==51) && (synpred20_InternalTutorial())) {s = 4;}

                        else if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_DECIMAL)||LA37_0==17||LA37_0==30||(LA37_0>=36 && LA37_0<=37)||LA37_0==42||LA37_0==50||LA37_0==52||LA37_0==54||LA37_0==56||(LA37_0>=59 && LA37_0<=64)||(LA37_0>=66 && LA37_0<=73)) ) {s = 5;}

                         
                        input.seek(index37_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\100\uffff";
    static final String DFA61_eofS =
        "\1\2\77\uffff";
    static final String DFA61_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA61_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA61_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\33\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\12\2",
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

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "3539:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\36\uffff";
    static final String DFA60_eofS =
        "\36\uffff";
    static final String DFA60_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA60_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA60_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA60_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA60_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\1\3\2\uffff\2\5\4"+
            "\uffff\1\5\5\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5"+
            "\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            return "3560:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_0 = input.LA(1);

                         
                        int index60_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA60_0==RULE_ID) ) {s = 1;}

                        else if ( (LA60_0==48) ) {s = 2;}

                        else if ( (LA60_0==33) && (synpred27_InternalTutorial())) {s = 3;}

                        else if ( (LA60_0==51) && (synpred27_InternalTutorial())) {s = 4;}

                        else if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_DECIMAL)||LA60_0==17||LA60_0==30||(LA60_0>=36 && LA60_0<=37)||LA60_0==42||LA60_0==50||LA60_0==54||LA60_0==56||(LA60_0>=59 && LA60_0<=61)||LA60_0==64||(LA60_0>=66 && LA60_0<=73)) ) {s = 5;}

                        else if ( (LA60_0==49) ) {s = 29;}

                         
                        input.seek(index60_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_2);
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
    static final String DFA62_eotS =
        "\100\uffff";
    static final String DFA62_eofS =
        "\1\2\77\uffff";
    static final String DFA62_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA62_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA62_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA62_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA62_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\35\2\1\1\1\uffff\15\2\1\uffff\12\2",
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "3639:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\100\uffff";
    static final String DFA66_eofS =
        "\1\2\77\uffff";
    static final String DFA66_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA66_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA66_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA66_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA66_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\11\2\1\1\24\2\1\uffff\15\2\1\uffff"+
            "\12\2",
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
            return "3782:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index66_1);
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
    static final String DFA69_eotS =
        "\100\uffff";
    static final String DFA69_eofS =
        "\1\2\77\uffff";
    static final String DFA69_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA69_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA69_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA69_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA69_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\33\2\1\1\2\2\1\uffff\15\2\1\uffff"+
            "\12\2",
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
            return "3831:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index69_1);
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
    static final String DFA68_eotS =
        "\36\uffff";
    static final String DFA68_eofS =
        "\36\uffff";
    static final String DFA68_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA68_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA68_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA68_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA68_transitionS = {
            "\4\5\1\1\10\uffff\1\5\14\uffff\1\5\2\uffff\1\3\2\uffff\2\5\4"+
            "\uffff\1\5\5\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5"+
            "\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5",
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
            return "3836:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_0 = input.LA(1);

                         
                        int index68_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA68_0==RULE_ID) ) {s = 1;}

                        else if ( (LA68_0==48) ) {s = 2;}

                        else if ( (LA68_0==33) && (synpred31_InternalTutorial())) {s = 3;}

                        else if ( (LA68_0==51) && (synpred31_InternalTutorial())) {s = 4;}

                        else if ( ((LA68_0>=RULE_STRING && LA68_0<=RULE_DECIMAL)||LA68_0==17||LA68_0==30||(LA68_0>=36 && LA68_0<=37)||LA68_0==42||LA68_0==50||LA68_0==54||LA68_0==56||(LA68_0>=59 && LA68_0<=61)||LA68_0==64||(LA68_0>=66 && LA68_0<=73)) ) {s = 5;}

                        else if ( (LA68_0==49) ) {s = 29;}

                         
                        input.seek(index68_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA68_2 = input.LA(1);

                         
                        int index68_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index68_2);
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
        "\100\uffff";
    static final String DFA70_eofS =
        "\1\2\77\uffff";
    static final String DFA70_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA70_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA70_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA70_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\35\2\1\1\1\uffff\15\2\1\uffff\12\2",
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
            return "3915:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
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
                        if ( (synpred32_InternalTutorial()) ) {s = 63;}

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
    static final String DFA72_eotS =
        "\100\uffff";
    static final String DFA72_eofS =
        "\1\33\77\uffff";
    static final String DFA72_minS =
        "\1\4\32\0\45\uffff";
    static final String DFA72_maxS =
        "\1\113\32\0\45\uffff";
    static final String DFA72_acceptS =
        "\33\uffff\1\2\43\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\45\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\21\1\15\1\16\1\17\1\1\10\uffff\1\6\2\33\1\uffff\11\33\1\10"+
            "\5\33\1\4\1\3\4\33\1\2\5\33\1\32\1\33\1\12\1\uffff\2\33\1\23"+
            "\1\33\1\7\2\33\1\24\1\25\1\26\2\33\1\11\1\uffff\1\5\1\13\1\14"+
            "\1\20\1\22\1\27\1\30\1\31\2\33",
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
            return "4237:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_2 = input.LA(1);

                         
                        int index72_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_4 = input.LA(1);

                         
                        int index72_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_5 = input.LA(1);

                         
                        int index72_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_6 = input.LA(1);

                         
                        int index72_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA72_7 = input.LA(1);

                         
                        int index72_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA72_8 = input.LA(1);

                         
                        int index72_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA72_9 = input.LA(1);

                         
                        int index72_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA72_10 = input.LA(1);

                         
                        int index72_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA72_14 = input.LA(1);

                         
                        int index72_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA72_15 = input.LA(1);

                         
                        int index72_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA72_16 = input.LA(1);

                         
                        int index72_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA72_17 = input.LA(1);

                         
                        int index72_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA72_18 = input.LA(1);

                         
                        int index72_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA72_19 = input.LA(1);

                         
                        int index72_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA72_20 = input.LA(1);

                         
                        int index72_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA72_21 = input.LA(1);

                         
                        int index72_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA72_22 = input.LA(1);

                         
                        int index72_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA72_23 = input.LA(1);

                         
                        int index72_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA72_24 = input.LA(1);

                         
                        int index72_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA72_25 = input.LA(1);

                         
                        int index72_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA72_26 = input.LA(1);

                         
                        int index72_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_26);
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
    static final String DFA87_eotS =
        "\100\uffff";
    static final String DFA87_eofS =
        "\1\2\77\uffff";
    static final String DFA87_minS =
        "\1\4\1\0\76\uffff";
    static final String DFA87_maxS =
        "\1\113\1\0\76\uffff";
    static final String DFA87_acceptS =
        "\2\uffff\1\2\74\uffff\1\1";
    static final String DFA87_specialS =
        "\1\uffff\1\0\76\uffff}>";
    static final String[] DFA87_transitionS = {
            "\5\2\10\uffff\3\2\1\uffff\11\2\1\1\24\2\1\uffff\15\2\1\uffff"+
            "\12\2",
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

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "4753:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalTutorial()) ) {s = 63;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
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
    public static final BitSet FOLLOW_16_in_ruleEntity411 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleEntity432 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEntity446 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity467 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_18_in_ruleEntity480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleProperty572 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleProperty584 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleProperty605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment799 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment815 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment865 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment918 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
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
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1266 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1289 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpOr1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1472 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1525 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1548 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpAnd1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1731 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1784 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1807 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpEquality1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpEquality1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2011 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_26_in_ruleXRelationalExpression2047 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2070 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2131 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2154 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2397 = new BitSet(new long[]{0x0000000FE0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2450 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2473 = new BitSet(new long[]{0x0000000FE0000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpOther2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpOther2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpOther2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOther2619 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleOpOther2632 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOther2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2677 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2690 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther2735 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleOpOther2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpOther2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpOther2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2884 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2937 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2960 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpAdd3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpAdd3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3164 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3217 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3240 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpMulti3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpMulti3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3493 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpUnary3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpUnary3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpUnary3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3763 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXCastedExpression3798 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3821 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3916 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall3965 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3988 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4004 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4026 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4112 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4136 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_46_in_ruleXMemberFeatureCall4173 = new BitSet(new long[]{0x0000000040000100L});
    public static final BitSet FOLLOW_30_in_ruleXMemberFeatureCall4202 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4223 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_47_in_ruleXMemberFeatureCall4236 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4257 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall4271 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4296 = new BitSet(new long[]{0x0005700000000002L});
    public static final BitSet FOLLOW_48_in_ruleXMemberFeatureCall4330 = new BitSet(new long[]{0x394F0432400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4415 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4443 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXMemberFeatureCall4456 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4477 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_49_in_ruleXMemberFeatureCall4494 = new BitSet(new long[]{0x0004700000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4529 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXClosure5296 = new BitSet(new long[]{0xF95D0432400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5369 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5382 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5403 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_ruleXClosure5425 = new BitSet(new long[]{0xF9550430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5462 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleXClosure5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5576 = new BitSet(new long[]{0xF9650430400201F2L,0x00000000000003FDL});
    public static final BitSet FOLLOW_53_in_ruleXExpressionInClosure5589 = new BitSet(new long[]{0xF9450430400201F2L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5747 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXShortClosure5760 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5781 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_ruleXShortClosure5803 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXParenthesizedExpression5922 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5944 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXParenthesizedExpression5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXIfExpression6047 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXIfExpression6059 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6080 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXIfExpression6092 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6113 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXIfExpression6134 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression6250 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6293 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6305 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6329 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6373 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6394 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6406 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6429 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXSwitchExpression6441 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6455 = new BitSet(new long[]{0x0401000200080100L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6476 = new BitSet(new long[]{0x06010002000C0100L});
    public static final BitSet FOLLOW_57_in_ruleXSwitchExpression6490 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXSwitchExpression6502 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6523 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXSwitchExpression6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6629 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_58_in_ruleXCasePart6643 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6664 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXCasePart6678 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXForLoopExpression6791 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXForLoopExpression6803 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6824 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXForLoopExpression6836 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6857 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXForLoopExpression6869 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXWhileExpression6982 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXWhileExpression6994 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7015 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXWhileExpression7027 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXDoWhileExpression7140 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7161 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleXDoWhileExpression7173 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXDoWhileExpression7185 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7206 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXDoWhileExpression7218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXBlockExpression7310 = new BitSet(new long[]{0xF9450430400601F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7332 = new BitSet(new long[]{0xF9650430400601F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_53_in_ruleXBlockExpression7345 = new BitSet(new long[]{0xF9450430400601F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_18_in_ruleXBlockExpression7361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXVariableDeclaration7579 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_63_in_ruleXVariableDeclaration7610 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7658 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7679 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7708 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleXVariableDeclaration7722 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7837 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7951 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8008 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall8018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8075 = new BitSet(new long[]{0x0000000040000100L,0x0000000000000001L});
    public static final BitSet FOLLOW_30_in_ruleXFeatureCall8089 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8110 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_47_in_ruleXFeatureCall8123 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8144 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall8158 = new BitSet(new long[]{0x0000000040000100L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8183 = new BitSet(new long[]{0x0005000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXFeatureCall8217 = new BitSet(new long[]{0x394F0432400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8302 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8330 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXFeatureCall8343 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8364 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_49_in_ruleXFeatureCall8381 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleIdOrSuper8536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleStaticQualifier8653 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXConstructorCall8750 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8773 = new BitSet(new long[]{0x0005000040000002L});
    public static final BitSet FOLLOW_30_in_ruleXConstructorCall8794 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8816 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_47_in_ruleXConstructorCall8829 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8850 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall8864 = new BitSet(new long[]{0x0005000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXConstructorCall8887 = new BitSet(new long[]{0x394F0432400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8960 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8988 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXConstructorCall9001 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9022 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_49_in_ruleXConstructorCall9039 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall9074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXBooleanLiteral9168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXBooleanLiteral9192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXNullLiteral9298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral9344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral9399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXTypeLiteral9593 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXTypeLiteral9605 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9628 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXTypeLiteral9640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXThrowExpression9732 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXReturnExpression9845 = new BitSet(new long[]{0x39450430400201F2L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleXTryCatchFinallyExpression9969 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10020 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_74_in_ruleXTryCatchFinallyExpression10042 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleXTryCatchFinallyExpression10086 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleXCatchClause10200 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXCatchClause10213 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10234 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleXCatchClause10246 = new BitSet(new long[]{0x39450430400201F0L,0x00000000000003FDL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10362 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleQualifiedName10390 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10413 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber10467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber10478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber10522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10550 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10576 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleNumber10596 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10749 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleJvmTypeReference10787 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleJvmTypeReference10799 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXFunctionTypeRef10914 = new BitSet(new long[]{0x0003000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10936 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXFunctionTypeRef10949 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10970 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_49_in_ruleXFunctionTypeRef10986 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXFunctionTypeRef11000 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11115 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleJvmParameterizedTypeReference11136 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11158 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_47_in_ruleJvmParameterizedTypeReference11171 = new BitSet(new long[]{0x0001000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11192 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference11206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleJvmWildcardTypeReference11419 = new BitSet(new long[]{0x0000000000010002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJvmUpperBound11553 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleJvmUpperBoundAnded11657 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleJvmLowerBound11761 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalTutorial886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalTutorial1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalTutorial1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalTutorial1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred5_InternalTutorial2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalTutorial2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalTutorial2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred8_InternalTutorial2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred9_InternalTutorial2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred10_InternalTutorial2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred11_InternalTutorial3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred12_InternalTutorial3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred13_InternalTutorial3933 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred13_InternalTutorial3942 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred13_InternalTutorial3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred14_InternalTutorial4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred14_InternalTutorial4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred14_InternalTutorial4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred15_InternalTutorial4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial4364 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_synpred16_InternalTutorial4371 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial4378 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_synpred16_InternalTutorial4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred17_InternalTutorial4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred18_InternalTutorial5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalTutorial5315 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_synpred20_InternalTutorial5322 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalTutorial5329 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_synpred20_InternalTutorial5343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred22_InternalTutorial6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred23_InternalTutorial6268 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred23_InternalTutorial6274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred24_InternalTutorial6350 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred24_InternalTutorial6357 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred24_InternalTutorial6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred25_InternalTutorial7628 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred25_InternalTutorial7637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred26_InternalTutorial8199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8251 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_synpred27_InternalTutorial8258 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial8265 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_synpred27_InternalTutorial8279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred28_InternalTutorial8399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred29_InternalTutorial8786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred30_InternalTutorial8879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalTutorial8909 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_47_in_synpred31_InternalTutorial8916 = new BitSet(new long[]{0x0001000200000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred31_InternalTutorial8923 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_synpred31_InternalTutorial8937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred32_InternalTutorial9057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred33_InternalTutorial9859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_synpred34_InternalTutorial10004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_synpred35_InternalTutorial10034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred37_InternalTutorial10381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred38_InternalTutorial10764 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_synpred38_InternalTutorial10768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred39_InternalTutorial11128 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.example.domainmodel.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.example.domainmodel.services.DomainmodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDomainmodelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'entity'", "'extends'", "':'", "'op'", "'('", "','", "')'", "'.'", "'*'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "'['", "'|'", "']'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
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
    public static final int RULE_WS=9;
    public static final int T__74=74;
    public static final int T__73=73;

    // delegates
    // delegators


        public InternalDomainmodelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDomainmodelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDomainmodelParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g"; }



     	private DomainmodelGrammarAccess grammarAccess;
     	
        public InternalDomainmodelParser(TokenStream input, DomainmodelGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DomainModel";	
       	}
       	
       	@Override
       	protected DomainmodelGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDomainModel"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:67:1: entryRuleDomainModel returns [EObject current=null] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final EObject entryRuleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModel = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:68:2: (iv_ruleDomainModel= ruleDomainModel EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:69:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainModelRule()); 
            }
            pushFollow(FOLLOW_ruleDomainModel_in_entryRuleDomainModel75);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomainModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:76:1: ruleDomainModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:79:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:82:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_ruleDomainModel130);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_0_0, 
            	              		"AbstractElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleAbstractElement"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:106:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:107:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:108:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractElementRule()); 
            }
            pushFollow(FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractElement176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:115:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_Entity_1 = null;

        EObject this_Import_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:118:28: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:119:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:119:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:120:5: this_PackageDeclaration_0= rulePackageDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePackageDeclaration_in_ruleAbstractElement223);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PackageDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:130:5: this_Entity_1= ruleEntity
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getEntityParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntity_in_ruleAbstractElement250);
                    this_Entity_1=ruleEntity();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Entity_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:140:5: this_Import_2= ruleImport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleImport_in_ruleAbstractElement277);
                    this_Import_2=ruleImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Import_2; 
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:156:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:157:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:158:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport312);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport322); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:165:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:168:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:169:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:169:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:169:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:173:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:174:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:174:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:175:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport380);
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


    // $ANTLR start "entryRulePackageDeclaration"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:199:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:200:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:201:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            }
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration416);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration426); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:208:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:211:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:212:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:212:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:212:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_rulePackageDeclaration463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:216:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:217:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:217:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:218:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDeclaration484);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
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

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_rulePackageDeclaration496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:238:1: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:239:1: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:239:1: (lv_elements_3_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:240:3: lv_elements_3_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_rulePackageDeclaration517);
            	    lv_elements_3_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"AbstractElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_rulePackageDeclaration530); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:268:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:269:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:270:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntityRule()); 
            }
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity566);
            iv_ruleEntity=ruleEntity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity576); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:277:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:280:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:281:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:281:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:281:3: otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleEntity613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:285:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:286:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:286:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:287:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEntityAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleEntity634);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:303:2: (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:303:4: otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleEntity647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:307:1: ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:308:1: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:308:1: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:309:3: lv_superType_3_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEntityAccess().getSuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleEntity668);
                    lv_superType_3_0=ruleJvmParameterizedTypeReference();

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
                              		"JvmParameterizedTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleEntity682); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:329:1: ( (lv_features_5_0= ruleFeature ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:330:1: (lv_features_5_0= ruleFeature )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:330:1: (lv_features_5_0= ruleFeature )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:331:3: lv_features_5_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEntityAccess().getFeaturesFeatureParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFeature_in_ruleEntity703);
            	    lv_features_5_0=ruleFeature();

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
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEntity716); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFeature"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:359:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:360:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:361:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature752);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature762); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:368:1: ruleFeature returns [EObject current=null] : (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Property_0 = null;

        EObject this_Operation_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:371:28: ( (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:372:1: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:372:1: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:373:5: this_Property_0= ruleProperty
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getPropertyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleProperty_in_ruleFeature809);
                    this_Property_0=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Property_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:383:5: this_Operation_1= ruleOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getOperationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOperation_in_ruleFeature836);
                    this_Operation_1=ruleOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Operation_1; 
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:399:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:400:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:401:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty871);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty881); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:408:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:411:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:412:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:412:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:412:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:412:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:414:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getNameValidIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleProperty927);
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleProperty939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:434:1: ( (lv_type_2_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:435:1: (lv_type_2_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:435:1: (lv_type_2_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:436:3: lv_type_2_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleProperty960);
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


    // $ANTLR start "entryRuleOperation"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:460:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:461:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:462:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRule()); 
            }
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation996);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1006); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:469:1: ruleOperation returns [EObject current=null] : (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) ( (lv_body_9_0= ruleXBlockExpression ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_type_8_0 = null;

        EObject lv_body_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:472:28: ( (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) ( (lv_body_9_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:473:1: (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) ( (lv_body_9_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:473:1: (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) ( (lv_body_9_0= ruleXBlockExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:473:3: otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) ( (lv_body_9_0= ruleXBlockExpression ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleOperation1043); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationAccess().getOpKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:477:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:478:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:478:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:479:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleOperation1064);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
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

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleOperation1076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:499:1: ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==72) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:499:2: ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:499:2: ( (lv_params_3_0= ruleFullJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:500:1: (lv_params_3_0= ruleFullJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:500:1: (lv_params_3_0= ruleFullJvmFormalParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:501:3: lv_params_3_0= ruleFullJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getParamsFullJvmFormalParameterParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleOperation1098);
                    lv_params_3_0=ruleFullJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                      	        }
                             		add(
                             			current, 
                             			"params",
                              		lv_params_3_0, 
                              		"FullJvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:517:2: (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:517:4: otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleOperation1111); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:521:1: ( (lv_params_5_0= ruleFullJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:522:1: (lv_params_5_0= ruleFullJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:522:1: (lv_params_5_0= ruleFullJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:523:3: lv_params_5_0= ruleFullJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationAccess().getParamsFullJvmFormalParameterParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleOperation1132);
                    	    lv_params_5_0=ruleFullJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"params",
                    	              		lv_params_5_0, 
                    	              		"FullJvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleOperation1148); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleOperation1160); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getColonKeyword_5());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:547:1: ( (lv_type_8_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:548:1: (lv_type_8_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:548:1: (lv_type_8_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:549:3: lv_type_8_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getTypeJvmTypeReferenceParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleOperation1181);
            lv_type_8_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_8_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:565:2: ( (lv_body_9_0= ruleXBlockExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:566:1: (lv_body_9_0= ruleXBlockExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:566:1: (lv_body_9_0= ruleXBlockExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:567:3: lv_body_9_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getBodyXBlockExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleOperation1202);
            lv_body_9_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_9_0, 
                      		"XBlockExpression");
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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:591:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:592:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:593:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1239);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1250); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:600:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:603:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:604:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:604:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:605:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1297);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:615:1: (kw= '.' kw= '*' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:616:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedNameWithWildCard1316); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildCard1329); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:635:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:636:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:637:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression1371);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression1381); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:644:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:647:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:649:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1427);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:665:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:666:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:667:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1461);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1471); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:674:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:677:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==EOF||(LA11_1>=RULE_INT && LA11_1<=RULE_ID)||(LA11_1>=13 && LA11_1<=14)||LA11_1==17||(LA11_1>=19 && LA11_1<=23)||(LA11_1>=25 && LA11_1<=46)||(LA11_1>=48 && LA11_1<=72)) ) {
                    alt11=2;
                }
                else if ( (LA11_1==24) ) {
                    alt11=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA11_0>=RULE_INT && LA11_0<=RULE_STRING)||LA11_0==13||LA11_0==19||LA11_0==34||(LA11_0>=37 && LA11_0<=38)||LA11_0==42||LA11_0==46||LA11_0==50||LA11_0==52||(LA11_0>=55 && LA11_0<=57)||LA11_0==60||(LA11_0>=62 && LA11_0<=69)) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:678:3: ()
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:679:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:684:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:685:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:685:1: ( ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:686:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment1529);
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
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1545);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:707:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:708:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:708:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:709:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1565);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:726:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:726:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:727:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1595);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==25) ) {
                        int LA10_1 = input.LA(2);

                        if ( (synpred1_InternalDomainmodel()) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:740:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:740:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:740:7: ()
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:741:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:746:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:747:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:747:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:748:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1648);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:761:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:762:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:762:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:763:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1671);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:787:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:788:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:789:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1711);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1722); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:796:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:799:28: (kw= '=' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:801:2: kw= '='
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleOpSingleAssign1759); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:814:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:815:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:816:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1799);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1810); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:823:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:826:28: (kw= '+=' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:828:2: kw= '+='
            {
            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpMultiAssign1847); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:841:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:842:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:843:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1886);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1896); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:850:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:853:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:854:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:854:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:855:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1943);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==26) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred2_InternalDomainmodel()) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:868:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:868:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:868:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:869:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:874:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:875:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:875:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:876:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1996);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:889:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:890:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:890:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:891:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression2019);
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:915:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:916:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:917:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2058);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2069); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:924:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:927:28: (kw= '||' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:929:2: kw= '||'
            {
            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOr2106); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:942:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:943:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:944:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression2145);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression2155); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:951:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:954:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:955:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:955:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:956:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2202);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred3_InternalDomainmodel()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:969:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:969:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:969:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:970:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:975:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:976:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:976:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:977:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression2255);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:990:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:991:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:991:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:992:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2278);
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
            	    break loop13;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1016:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1017:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1018:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2317);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd2328); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1025:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1028:28: (kw= '&&' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1030:2: kw= '&&'
            {
            kw=(Token)match(input,27,FOLLOW_27_in_ruleOpAnd2365); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1043:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1044:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1045:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2404);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2414); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1052:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1055:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1056:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1056:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1057:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2461);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred4_InternalDomainmodel()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==29) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred4_InternalDomainmodel()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1070:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1070:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1070:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1071:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1076:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1077:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1077:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1078:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2514);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1091:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1092:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1092:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1093:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2537);
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1117:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1118:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1119:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2576);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2587); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1126:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1129:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1130:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1130:1: (kw= '==' | kw= '!=' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            else if ( (LA15_0==29) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1131:2: kw= '=='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpEquality2625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1138:2: kw= '!='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpEquality2644); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1151:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1152:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1153:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2684);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2694); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1160:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1163:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1164:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1164:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1165:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2741);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop16:
            do {
                int alt16=3;
                switch ( input.LA(1) ) {
                case 30:
                    {
                    int LA16_2 = input.LA(2);

                    if ( (synpred5_InternalDomainmodel()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA16_3 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt16=2;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA16_4 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt16=2;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA16_5 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt16=2;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA16_6 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt16=2;
                    }


                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1175:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1175:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1175:6: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1176:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXRelationalExpression2777); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1185:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1186:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1186:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1187:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2800);
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
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1209:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1209:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1209:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1210:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1215:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1216:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1216:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1217:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2861);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1230:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1231:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1231:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1232:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2884);
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1256:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1257:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1258:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2924);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2935); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1265:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1268:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1269:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1269:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt17=1;
                }
                break;
            case 32:
                {
                alt17=2;
                }
                break;
            case 33:
                {
                alt17=3;
                }
                break;
            case 34:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1270:2: kw= '>='
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpCompare2973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1277:2: kw= '<='
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpCompare2992); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1284:2: kw= '>'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpCompare3011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1291:2: kw= '<'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpCompare3030); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1304:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1305:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1306:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3070);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3080); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1313:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1316:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1317:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1317:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1318:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3127);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==35) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred7_InternalDomainmodel()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==36) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred7_InternalDomainmodel()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1331:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1331:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1331:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1332:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1337:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1338:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1338:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1339:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3180);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1352:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1353:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1353:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1354:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3203);
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1378:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1379:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1380:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3242);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3253); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1387:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1390:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1391:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1391:1: (kw= '->' | kw= '..' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            else if ( (LA19_0==36) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1392:2: kw= '->'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpOther3291); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1399:2: kw= '..'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpOther3310); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1412:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1413:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1414:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3350);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression3360); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1421:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1424:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1425:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1425:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1426:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3407);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==37) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred8_InternalDomainmodel()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==38) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred8_InternalDomainmodel()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1439:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1439:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1439:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1440:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1445:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1446:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1446:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1447:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3460);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1460:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1461:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1461:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1462:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3483);
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1486:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1487:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1488:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3522);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3533); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1495:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1498:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1499:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1499:1: (kw= '+' | kw= '-' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==37) ) {
                alt21=1;
            }
            else if ( (LA21_0==38) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1500:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpAdd3571); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1507:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpAdd3590); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1520:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1521:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1522:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3630);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3640); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1529:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1532:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1533:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1533:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1534:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3687);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop22:
            do {
                int alt22=2;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA22_4 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA22_5 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt22=1;
                    }


                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1547:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1547:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1547:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1548:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1553:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1554:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1554:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1555:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3740);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1568:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1569:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1569:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1570:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3763);
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1594:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1595:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1596:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3802);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3813); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1603:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1606:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1607:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1607:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt23=1;
                }
                break;
            case 39:
                {
                alt23=2;
                }
                break;
            case 40:
                {
                alt23=3;
                }
                break;
            case 41:
                {
                alt23=4;
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1608:2: kw= '*'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpMulti3851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1615:2: kw= '**'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti3870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1622:2: kw= '/'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpMulti3889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1629:2: kw= '%'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpMulti3908); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1642:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1643:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1644:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3948);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3958); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1651:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1654:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=37 && LA24_0<=38)||LA24_0==42) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=RULE_INT && LA24_0<=RULE_ID)||LA24_0==13||LA24_0==19||LA24_0==34||LA24_0==46||LA24_0==50||LA24_0==52||(LA24_0>=55 && LA24_0<=57)||LA24_0==60||(LA24_0>=62 && LA24_0<=69)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1655:3: ()
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1656:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1661:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1662:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1662:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1663:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4016);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1676:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1677:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1677:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1678:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4037);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1696:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4066);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1712:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1713:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1714:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary4102);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary4113); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1721:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1724:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1725:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1725:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt25=1;
                }
                break;
            case 38:
                {
                alt25=2;
                }
                break;
            case 37:
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1726:2: kw= '!'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpUnary4151); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1733:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary4170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1740:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpUnary4189); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1753:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1754:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1755:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4229);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression4239); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1762:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1765:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1766:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1766:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1767:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4286);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred10_InternalDomainmodel()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1777:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1777:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1777:6: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1778:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXCastedExpression4321); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1787:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1788:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1788:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1789:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4344);
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1813:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1814:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1815:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4382);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall4392); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1822:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1825:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1826:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1826:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1827:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4439);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop34:
            do {
                int alt34=3;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    int LA34_2 = input.LA(2);

                    if ( (synpred11_InternalDomainmodel()) ) {
                        alt34=1;
                    }
                    else if ( (synpred12_InternalDomainmodel()) ) {
                        alt34=2;
                    }


                    }
                    break;
                case 44:
                    {
                    int LA34_3 = input.LA(2);

                    if ( (synpred12_InternalDomainmodel()) ) {
                        alt34=2;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA34_4 = input.LA(2);

                    if ( (synpred12_InternalDomainmodel()) ) {
                        alt34=2;
                    }


                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1841:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1841:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1841:26: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1842:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall4488); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1852:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1852:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1853:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4511);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4527);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1874:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1875:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1875:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1876:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4549);
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
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:8: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1910:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1915:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt27=3;
            	    switch ( input.LA(1) ) {
            	    case 22:
            	        {
            	        alt27=1;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt27=2;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt27=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1915:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall4635); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1920:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1920:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1921:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1921:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1922:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4659); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1936:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1936:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1937:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1937:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1938:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4696); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1951:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==34) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1951:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleXMemberFeatureCall4725); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1955:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1956:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1956:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1957:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4746);
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

            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1973:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop28:
            	            do {
            	                int alt28=2;
            	                int LA28_0 = input.LA(1);

            	                if ( (LA28_0==20) ) {
            	                    alt28=1;
            	                }


            	                switch (alt28) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1973:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall4759); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1977:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1978:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1978:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1979:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4780);
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
            	            	    break loop28;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,33,FOLLOW_33_in_ruleXMemberFeatureCall4794); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1999:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2000:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2000:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2001:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4819);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2014:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt32=2;
            	    alt32 = dfa32.predict(input);
            	    switch (alt32) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2014:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2014:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2014:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2021:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2022:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall4853); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt31=3;
            	            alt31 = dfa31.predict(input);
            	            switch (alt31) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2052:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2053:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4938);
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
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2070:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2070:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2070:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2070:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2071:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2071:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2072:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4966);
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

            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2088:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop30:
            	                    do {
            	                        int alt30=2;
            	                        int LA30_0 = input.LA(1);

            	                        if ( (LA30_0==20) ) {
            	                            alt30=1;
            	                        }


            	                        switch (alt30) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2088:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall4979); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2092:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2093:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2093:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2094:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5000);
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
            	                    	    break loop30;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall5017); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2114:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2114:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2119:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2120:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall5050);
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2144:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2145:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2146:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5090);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression5100); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2153:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2156:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2157:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2157:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt35=13;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt35=1;
                }
                break;
            case 13:
                {
                alt35=2;
                }
                break;
            case 52:
                {
                alt35=3;
                }
                break;
            case RULE_ID:
            case 34:
            case 60:
                {
                alt35=4;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 46:
            case 63:
            case 64:
            case 65:
            case 66:
                {
                alt35=5;
                }
                break;
            case 50:
                {
                alt35=6;
                }
                break;
            case 55:
                {
                alt35=7;
                }
                break;
            case 56:
                {
                alt35=8;
                }
                break;
            case 57:
                {
                alt35=9;
                }
                break;
            case 67:
                {
                alt35=10;
                }
                break;
            case 68:
                {
                alt35=11;
                }
                break;
            case 69:
                {
                alt35=12;
                }
                break;
            case 19:
                {
                alt35=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2158:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5147);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2168:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5174);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2178:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5201);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2188:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5228);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2198:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5255);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2208:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5282);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2218:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5309);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2228:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5336);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2238:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5363);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2248:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5390);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2258:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5417);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2268:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5444);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2278:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5471);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2294:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2295:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2296:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral5506);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral5516); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2303:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2306:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2307:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2307:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt36=6;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt36=1;
                }
                break;
            case 63:
            case 64:
                {
                alt36=2;
                }
                break;
            case RULE_INT:
                {
                alt36=3;
                }
                break;
            case 65:
                {
                alt36=4;
                }
                break;
            case RULE_STRING:
                {
                alt36=5;
                }
                break;
            case 66:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2308:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5563);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2318:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5590);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2328:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral5617);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2338:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5644);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2348:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5671);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2358:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5698);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2374:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2375:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2376:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5733);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5743); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2383:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2386:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2387:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2387:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2387:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2387:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2388:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleXClosure5789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2412:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2412:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2412:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID||LA38_0==19||LA38_0==72) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2412:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2412:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2413:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2413:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2414:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5860);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2430:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==20) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2430:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleXClosure5873); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2434:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2435:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2435:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2436:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5894);
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
                            	    break loop37;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2452:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2453:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2453:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2454:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5916); if (state.failed) return current;
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2467:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2468:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2468:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2469:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5953);
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

            otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleXClosure5965); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2497:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2498:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2499:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure6001);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure6011); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2506:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2509:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2510:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2510:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2510:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2510:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2511:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2516:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_INT && LA41_0<=RULE_ID)||LA41_0==13||LA41_0==19||LA41_0==34||(LA41_0>=37 && LA41_0<=38)||LA41_0==42||LA41_0==46||LA41_0==50||LA41_0==52||(LA41_0>=55 && LA41_0<=60)||(LA41_0>=62 && LA41_0<=69)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2516:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2516:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2517:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2517:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2518:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure6067);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2534:2: (otherlv_2= ';' )?
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==49) ) {
            	        alt40=1;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2534:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleXExpressionInClosure6080); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2546:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2547:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2548:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure6120);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure6130); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2555:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2558:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2559:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2559:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2559:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2559:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2559:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2575:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2575:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2575:7: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2576:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2581:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID||LA43_0==19||LA43_0==72) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2581:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2581:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2582:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2582:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2583:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6238);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2599:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==20) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2599:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXShortClosure6251); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2603:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2604:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2604:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2605:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6272);
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
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2621:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2622:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2622:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2623:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,47,FOLLOW_47_in_ruleXShortClosure6294); if (state.failed) return current;
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2636:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2637:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2637:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2638:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure6330);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2662:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2663:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2664:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6366);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6376); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2671:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2674:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleXParenthesizedExpression6413); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6435);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXParenthesizedExpression6446); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2700:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2701:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2702:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6482);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6492); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2709:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2712:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2713:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2713:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2713:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2713:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2714:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXIfExpression6538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXIfExpression6550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2727:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2728:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2728:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6571);
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

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXIfExpression6583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2749:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2750:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2750:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2751:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6604);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred18_InternalDomainmodel()) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,51,FOLLOW_51_in_ruleXIfExpression6625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2772:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2773:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2773:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2774:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6647);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2798:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2799:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2800:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6685);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6695); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2807:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2810:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2811:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2811:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2811:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2811:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2812:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXSwitchExpression6741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==17) && (synpred19_InternalDomainmodel())) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2826:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2826:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2826:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2827:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2827:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2828:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6782);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2848:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2849:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2849:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2850:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6818);
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

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXSwitchExpression6830); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2870:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID||LA46_0==17||LA46_0==19||LA46_0==54||LA46_0==72) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2871:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2871:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2872:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6851);
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
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2888:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2888:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,53,FOLLOW_53_in_ruleXSwitchExpression6865); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6877); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2896:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2897:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2897:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2898:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6898);
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

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleXSwitchExpression6912); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2926:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2927:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2928:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6948);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6958); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2935:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2938:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2939:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2939:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2939:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2939:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID||LA48_0==19||LA48_0==72) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2940:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2940:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2941:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart7004);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2957:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==54) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2957:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXCasePart7018); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2961:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2962:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2962:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2963:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7039);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXCasePart7053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2983:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2984:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2984:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2985:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7074);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3009:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3010:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3011:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression7110);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression7120); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3018:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3021:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3022:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3022:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3022:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3022:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3023:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXForLoopExpression7166); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXForLoopExpression7178); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3036:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3037:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3037:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3038:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7199);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleXForLoopExpression7211); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3058:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3059:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3059:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3060:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7232);
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

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleXForLoopExpression7244); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3080:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3081:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3081:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3082:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7265);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3106:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3107:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3108:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7301);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7311); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3115:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3118:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3119:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3119:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3119:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3119:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3120:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXWhileExpression7357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXWhileExpression7369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3133:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3134:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3134:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3135:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7390);
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

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXWhileExpression7402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3155:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3156:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3156:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3157:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7423);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3181:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3182:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3183:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7459);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7469); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3190:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3193:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3194:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3194:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3194:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3194:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3195:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXDoWhileExpression7515); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3204:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3205:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3205:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3206:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7536);
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

            otherlv_3=(Token)match(input,56,FOLLOW_56_in_ruleXDoWhileExpression7548); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleXDoWhileExpression7560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3230:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3231:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3231:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3232:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7581);
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

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleXDoWhileExpression7593); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3260:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3261:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3262:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7629);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7639); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3269:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3272:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3273:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3273:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3273:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3273:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3274:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleXBlockExpression7685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3283:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=RULE_INT && LA51_0<=RULE_ID)||LA51_0==13||LA51_0==19||LA51_0==34||(LA51_0>=37 && LA51_0<=38)||LA51_0==42||LA51_0==46||LA51_0==50||LA51_0==52||(LA51_0>=55 && LA51_0<=60)||(LA51_0>=62 && LA51_0<=69)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3283:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3283:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3284:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3284:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3285:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7707);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3301:2: (otherlv_3= ';' )?
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==49) ) {
            	        alt50=1;
            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3301:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleXBlockExpression7720); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXBlockExpression7736); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3317:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3318:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3319:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7772);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7782); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3326:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3329:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3330:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3330:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=58 && LA52_0<=59)) ) {
                alt52=1;
            }
            else if ( ((LA52_0>=RULE_INT && LA52_0<=RULE_ID)||LA52_0==13||LA52_0==19||LA52_0==34||(LA52_0>=37 && LA52_0<=38)||LA52_0==42||LA52_0==46||LA52_0==50||LA52_0==52||(LA52_0>=55 && LA52_0<=57)||LA52_0==60||(LA52_0>=62 && LA52_0<=69)) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3331:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7829);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3341:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7856);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3357:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3358:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3359:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7891);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7901); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3366:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3369:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3370:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3370:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3370:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3370:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3371:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3376:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==58) ) {
                alt53=1;
            }
            else if ( (LA53_0==59) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3376:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3376:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3377:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3377:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3378:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,58,FOLLOW_58_in_ruleXVariableDeclaration7954); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3392:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleXVariableDeclaration7985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (synpred20_InternalDomainmodel()) ) {
                    alt54=1;
                }
                else if ( (true) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA54_0==19) && (synpred20_InternalDomainmodel())) {
                alt54=1;
            }
            else if ( (LA54_0==72) && (synpred20_InternalDomainmodel())) {
                alt54=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3404:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3404:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3404:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3405:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3405:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3406:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8033);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3422:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3423:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3423:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3424:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration8054);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3441:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3441:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3442:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3442:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3443:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration8083);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3459:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==24) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3459:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleXVariableDeclaration8097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3463:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3464:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3464:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3465:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration8118);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3489:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3490:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3491:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter8156);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter8166); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3498:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3501:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3502:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3502:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3502:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3502:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==RULE_ID||LA56_1==22||LA56_1==34||LA56_1==46) ) {
                    alt56=1;
                }
            }
            else if ( (LA56_0==19||LA56_0==72) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3503:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3503:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3504:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8212);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3520:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3521:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3521:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3522:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter8234);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3546:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3547:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3548:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8270);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8280); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3555:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3558:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3559:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3559:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3559:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3559:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3560:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3560:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3561:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8326);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3577:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3578:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3578:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3579:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8347);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3603:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3604:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3605:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8383);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall8393); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3612:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3615:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3616:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3616:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3616:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3616:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3617:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3622:2: ( ( ruleStaticQualifier ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==61) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3623:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3623:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3624:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8450);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3637:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==34) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3637:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXFeatureCall8464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3641:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3642:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3642:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3643:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8485);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3659:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==20) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3659:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall8498); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3663:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3664:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3664:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3665:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8519);
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
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleXFeatureCall8533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3685:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3686:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3686:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3687:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8558);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3700:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3700:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3700:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3700:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3707:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3708:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,19,FOLLOW_19_in_ruleXFeatureCall8592); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt61=3;
                    alt61 = dfa61.predict(input);
                    switch (alt61) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3738:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3739:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8677);
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
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3756:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3756:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3756:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3756:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3757:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3757:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3758:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8705);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3774:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==20) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3774:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall8718); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3778:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3779:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3779:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3780:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8739);
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
                            	    break loop60;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall8756); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3800:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3800:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3805:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3806:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8789);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3830:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3831:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3832:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8827);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8838); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3839:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3842:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3843:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3843:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            else if ( (LA64_0==60) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3844:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8885);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3856:2: kw= 'super'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleIdOrSuper8909); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3869:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3870:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3871:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8950);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8961); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3878:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3881:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3882:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3882:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==61) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3883:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier9008);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,61,FOLLOW_61_in_ruleStaticQualifier9026); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3907:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3908:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3909:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9067);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall9077); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3916:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3919:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3920:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3920:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3920:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3920:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3921:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXConstructorCall9123); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3930:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3931:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3931:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3932:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9146);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3945:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==34) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3945:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXConstructorCall9159); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3949:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3950:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3950:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3951:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9180);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3967:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==20) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3967:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall9193); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3971:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3972:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3972:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3973:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9214);
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
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleXConstructorCall9228); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleXConstructorCall9242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt69=3;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4014:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4015:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9314);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4032:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4032:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4032:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4032:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4033:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4033:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4034:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9342);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4050:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==20) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4050:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall9355); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4054:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4055:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4055:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4056:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9376);
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
                    	    break loop68;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall9393); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4076:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4076:2: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4081:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4082:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall9424);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4106:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4107:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4108:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9461);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9471); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4115:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4118:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4119:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4119:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4119:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4119:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4120:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4125:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==63) ) {
                alt71=1;
            }
            else if ( (LA71_0==64) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4125:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXBooleanLiteral9518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4130:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4130:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4131:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4131:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4132:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,64,FOLLOW_64_in_ruleXBooleanLiteral9542); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4153:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4154:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4155:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9592);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9602); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4162:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4165:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4166:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4166:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4166:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4166:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4167:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXNullLiteral9648); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4184:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4185:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4186:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9684);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral9694); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4193:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4196:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4198:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4203:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4204:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4204:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4205:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral9745); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4229:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4230:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4231:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9786);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9796); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4238:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4241:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4242:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4242:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4242:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4242:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4243:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4248:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4249:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4249:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4250:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9847); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4274:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4275:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4276:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9888);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9898); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4283:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4286:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4288:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXTypeLiteral9944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXTypeLiteral9956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4301:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4302:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4302:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4303:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9979);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXTypeLiteral9991); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4328:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4329:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4330:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10027);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression10037); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4337:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4340:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4341:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4341:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4341:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4341:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4342:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXThrowExpression10083); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4351:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4352:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4352:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4353:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression10104);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4377:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4378:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4379:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression10140);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression10150); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4386:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4389:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4390:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4390:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4390:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4390:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4391:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXReturnExpression10196); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4400:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4400:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4405:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4406:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression10227);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4430:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4431:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4432:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10264);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10274); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4439:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4442:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4443:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4443:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4443:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4443:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4444:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXTryCatchFinallyExpression10320); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4453:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4454:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4454:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4455:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10341);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==71) ) {
                alt75=1;
            }
            else if ( (LA75_0==70) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==71) ) {
                            int LA73_2 = input.LA(2);

                            if ( (synpred27_InternalDomainmodel()) ) {
                                alt73=1;
                            }


                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4473:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4474:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10371);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==70) ) {
                        int LA74_1 = input.LA(2);

                        if ( (synpred28_InternalDomainmodel()) ) {
                            alt74=1;
                        }
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,70,FOLLOW_70_in_ruleXTryCatchFinallyExpression10393); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4495:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4496:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4496:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4497:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10415);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4514:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4514:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4514:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,70,FOLLOW_70_in_ruleXTryCatchFinallyExpression10437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4518:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4519:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4519:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4520:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10458);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4544:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4545:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4546:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10496);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10506); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4553:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4556:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4557:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4557:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4557:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4557:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4557:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleXCatchClause10551); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleXCatchClause10564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4566:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4567:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4567:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4568:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10585);
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

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXCatchClause10597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4588:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4589:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4589:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4590:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10618);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4614:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4615:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4616:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10655);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10666); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4623:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4626:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4627:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4627:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4628:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10713);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4638:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==22) ) {
                    int LA76_2 = input.LA(2);

                    if ( (LA76_2==RULE_ID) ) {
                        int LA76_3 = input.LA(3);

                        if ( (synpred30_InternalDomainmodel()) ) {
                            alt76=1;
                        }


                    }


                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4638:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4638:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4638:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedName10741); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10764);
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


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4665:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4666:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4667:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10811);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10821); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4674:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4677:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4678:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4678:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==19||LA78_0==72) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4678:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4678:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4679:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10869);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==46) ) {
                            int LA77_2 = input.LA(2);

                            if ( (LA77_2==48) ) {
                                int LA77_3 = input.LA(3);

                                if ( (synpred31_InternalDomainmodel()) ) {
                                    alt77=1;
                                }


                            }


                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4690:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4690:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4690:6: ()
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4691:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleJvmTypeReference10907); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleJvmTypeReference10919); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4706:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10951);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4722:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4723:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4724:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10986);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10996); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4731:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4734:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==19) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleXFunctionTypeRef11034); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4739:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==RULE_ID||LA80_0==19||LA80_0==72) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4739:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4739:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4740:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4740:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4741:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11056);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4757:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==20) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4757:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXFunctionTypeRef11069); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4761:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4762:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4762:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4763:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11090);
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
                            	    break loop79;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXFunctionTypeRef11106); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,72,FOLLOW_72_in_ruleXFunctionTypeRef11120); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4787:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4788:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4788:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4789:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11141);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4813:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4814:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4815:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11177);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11187); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4822:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4825:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4826:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4826:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4826:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4826:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4827:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4827:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4828:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11235);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleJvmParameterizedTypeReference11256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4846:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4847:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4847:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4848:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11278);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4864:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==20) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4864:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleJvmParameterizedTypeReference11291); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4868:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4869:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4869:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4870:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11312);
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
                    	    break loop82;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleJvmParameterizedTypeReference11326); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4898:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4899:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4900:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11364);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11374); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4907:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4910:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4911:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4911:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID||LA84_0==19||LA84_0==72) ) {
                alt84=1;
            }
            else if ( (LA84_0==73) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4912:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11421);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4922:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11448);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4938:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4939:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4940:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11483);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11493); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4947:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4950:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4951:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4951:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4951:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4951:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4952:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_73_in_ruleJvmWildcardTypeReference11539); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4961:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt85=3;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==16) ) {
                alt85=1;
            }
            else if ( (LA85_0==60) ) {
                alt85=2;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4961:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4961:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4962:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4962:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4963:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11561);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4980:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4980:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4981:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4981:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4982:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11588);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5006:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5007:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5008:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11626);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11636); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5015:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5018:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5019:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5019:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5019:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJvmUpperBound11673); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5023:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5024:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5024:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5025:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11694);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5049:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5050:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5051:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11730);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11740); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5058:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5061:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5062:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5062:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5062:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleJvmUpperBoundAnded11777); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5066:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5067:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5067:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5068:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11798);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5092:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5093:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5094:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11834);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11844); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5101:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5104:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5105:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5105:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5105:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleJvmLowerBound11881); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5109:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5110:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5110:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5111:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11902);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5137:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5138:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5139:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11941);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11952); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5146:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5149:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5150:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11991); if (state.failed) return current;
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

    // $ANTLR start synpred1_InternalDomainmodel
    public final void synpred1_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:735:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:736:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:736:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:737:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:737:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:738:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalDomainmodel1616);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalDomainmodel

    // $ANTLR start synpred2_InternalDomainmodel
    public final void synpred2_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:863:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:864:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:864:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:865:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:865:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:866:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalDomainmodel1964);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalDomainmodel

    // $ANTLR start synpred3_InternalDomainmodel
    public final void synpred3_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:964:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:965:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:965:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:966:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:966:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:967:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalDomainmodel2223);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalDomainmodel

    // $ANTLR start synpred4_InternalDomainmodel
    public final void synpred4_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1065:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1066:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1066:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1067:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1067:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1068:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalDomainmodel2482);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalDomainmodel

    // $ANTLR start synpred5_InternalDomainmodel
    public final void synpred5_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1173:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1174:1: 
        {
        }

        match(input,30,FOLLOW_30_in_synpred5_InternalDomainmodel2758); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalDomainmodel

    // $ANTLR start synpred6_InternalDomainmodel
    public final void synpred6_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:10: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1205:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1205:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1206:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1206:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1207:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalDomainmodel2829);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalDomainmodel

    // $ANTLR start synpred7_InternalDomainmodel
    public final void synpred7_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1326:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1327:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1327:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1328:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1328:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1329:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalDomainmodel3148);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalDomainmodel

    // $ANTLR start synpred8_InternalDomainmodel
    public final void synpred8_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1434:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1435:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1435:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1436:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1436:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1437:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalDomainmodel3428);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalDomainmodel

    // $ANTLR start synpred9_InternalDomainmodel
    public final void synpred9_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1542:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1543:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1543:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1544:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1544:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1545:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalDomainmodel3708);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalDomainmodel

    // $ANTLR start synpred10_InternalDomainmodel
    public final void synpred10_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:4: ( () 'as' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:5: () 'as'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1775:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1776:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred10_InternalDomainmodel4302); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalDomainmodel

    // $ANTLR start synpred11_InternalDomainmodel
    public final void synpred11_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1835:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1836:1: 
        {
        }

        match(input,22,FOLLOW_22_in_synpred11_InternalDomainmodel4456); if (state.failed) return ;
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1837:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1838:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1838:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1839:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalDomainmodel4465);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalDomainmodel4471);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalDomainmodel

    // $ANTLR start synpred12_InternalDomainmodel
    public final void synpred12_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1893:10: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1894:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1894:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt86=3;
        switch ( input.LA(1) ) {
        case 22:
            {
            alt86=1;
            }
            break;
        case 44:
            {
            alt86=2;
            }
            break;
        case 45:
            {
            alt86=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 86, 0, input);

            throw nvae;
        }

        switch (alt86) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1894:4: '.'
                {
                match(input,22,FOLLOW_22_in_synpred12_InternalDomainmodel4574); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1896:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1896:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1897:1: ( '?.' )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1897:1: ( '?.' )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1898:2: '?.'
                {
                match(input,44,FOLLOW_44_in_synpred12_InternalDomainmodel4588); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1903:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1903:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1904:1: ( '*.' )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1904:1: ( '*.' )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1905:2: '*.'
                {
                match(input,45,FOLLOW_45_in_synpred12_InternalDomainmodel4608); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalDomainmodel

    // $ANTLR start synpred13_InternalDomainmodel
    public final void synpred13_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2014:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2015:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2015:1: ( '(' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2016:2: '('
        {
        match(input,19,FOLLOW_19_in_synpred13_InternalDomainmodel4835); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalDomainmodel

    // $ANTLR start synpred14_InternalDomainmodel
    public final void synpred14_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2035:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2036:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2036:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==RULE_ID||LA88_0==19||LA88_0==72) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2036:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2036:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2037:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2037:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2038:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4887);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2040:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop87:
                do {
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==20) ) {
                        alt87=1;
                    }


                    switch (alt87) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2040:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred14_InternalDomainmodel4894); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2041:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2042:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2042:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2043:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4901);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop87;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2045:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2046:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2046:1: ( '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2047:2: '|'
        {
        match(input,47,FOLLOW_47_in_synpred14_InternalDomainmodel4915); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalDomainmodel

    // $ANTLR start synpred15_InternalDomainmodel
    public final void synpred15_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2114:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2115:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2115:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2116:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred15_InternalDomainmodel5033);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalDomainmodel

    // $ANTLR start synpred16_InternalDomainmodel
    public final void synpred16_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==RULE_ID||LA90_0==19||LA90_0==72) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2398:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2398:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2399:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalDomainmodel5806);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2401:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop89:
                do {
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==20) ) {
                        alt89=1;
                    }


                    switch (alt89) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2401:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred16_InternalDomainmodel5813); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2402:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2403:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2403:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2404:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalDomainmodel5820);
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

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2406:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2407:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2407:1: ( '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2408:2: '|'
        {
        match(input,47,FOLLOW_47_in_synpred16_InternalDomainmodel5834); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalDomainmodel

    // $ANTLR start synpred18_InternalDomainmodel
    public final void synpred18_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:4: ( 'else' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2767:6: 'else'
        {
        match(input,51,FOLLOW_51_in_synpred18_InternalDomainmodel6617); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalDomainmodel

    // $ANTLR start synpred19_InternalDomainmodel
    public final void synpred19_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2821:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2822:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2822:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2823:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalDomainmodel6757);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,17,FOLLOW_17_in_synpred19_InternalDomainmodel6763); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalDomainmodel

    // $ANTLR start synpred20_InternalDomainmodel
    public final void synpred20_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3396:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3397:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3397:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3398:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred20_InternalDomainmodel8003);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3400:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3401:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3401:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3402:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalDomainmodel8012);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalDomainmodel

    // $ANTLR start synpred21_InternalDomainmodel
    public final void synpred21_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3700:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3701:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3701:1: ( '(' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3702:2: '('
        {
        match(input,19,FOLLOW_19_in_synpred21_InternalDomainmodel8574); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalDomainmodel

    // $ANTLR start synpred22_InternalDomainmodel
    public final void synpred22_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3721:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3722:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3722:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID||LA94_0==19||LA94_0==72) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3722:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3722:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3723:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3723:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3724:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalDomainmodel8626);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3726:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==20) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3726:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred22_InternalDomainmodel8633); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3727:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3728:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3728:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3729:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalDomainmodel8640);
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

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3731:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3732:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3732:1: ( '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3733:2: '|'
        {
        match(input,47,FOLLOW_47_in_synpred22_InternalDomainmodel8654); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalDomainmodel

    // $ANTLR start synpred23_InternalDomainmodel
    public final void synpred23_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3800:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3801:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3801:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3802:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred23_InternalDomainmodel8772);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalDomainmodel

    // $ANTLR start synpred24_InternalDomainmodel
    public final void synpred24_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3997:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3998:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3998:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt96=2;
        int LA96_0 = input.LA(1);

        if ( (LA96_0==RULE_ID||LA96_0==19||LA96_0==72) ) {
            alt96=1;
        }
        switch (alt96) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3998:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3998:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3999:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3999:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4000:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalDomainmodel9263);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4002:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop95:
                do {
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==20) ) {
                        alt95=1;
                    }


                    switch (alt95) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4002:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred24_InternalDomainmodel9270); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4003:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4004:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4004:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4005:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalDomainmodel9277);
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

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4007:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4008:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4008:1: ( '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4009:2: '|'
        {
        match(input,47,FOLLOW_47_in_synpred24_InternalDomainmodel9291); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalDomainmodel

    // $ANTLR start synpred25_InternalDomainmodel
    public final void synpred25_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4076:2: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4077:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4077:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4078:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred25_InternalDomainmodel9407);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred25_InternalDomainmodel

    // $ANTLR start synpred26_InternalDomainmodel
    public final void synpred26_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4400:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4401:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4401:1: ( ruleXExpression )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4402:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred26_InternalDomainmodel10210);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalDomainmodel

    // $ANTLR start synpred27_InternalDomainmodel
    public final void synpred27_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:5: ( 'catch' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4471:7: 'catch'
        {
        match(input,71,FOLLOW_71_in_synpred27_InternalDomainmodel10355); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalDomainmodel

    // $ANTLR start synpred28_InternalDomainmodel
    public final void synpred28_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:5: ( 'finally' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4490:7: 'finally'
        {
        match(input,70,FOLLOW_70_in_synpred28_InternalDomainmodel10385); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalDomainmodel

    // $ANTLR start synpred30_InternalDomainmodel
    public final void synpred30_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4638:3: ( '.' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4639:2: '.'
        {
        match(input,22,FOLLOW_22_in_synpred30_InternalDomainmodel10732); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalDomainmodel

    // $ANTLR start synpred31_InternalDomainmodel
    public final void synpred31_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:3: ( () '[' ']' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:4: () '[' ']'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4687:4: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4688:1: 
        {
        }

        match(input,46,FOLLOW_46_in_synpred31_InternalDomainmodel10884); if (state.failed) return ;
        match(input,48,FOLLOW_48_in_synpred31_InternalDomainmodel10888); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalDomainmodel

    // $ANTLR start synpred32_InternalDomainmodel
    public final void synpred32_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:4: ( '<' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:6: '<'
        {
        match(input,34,FOLLOW_34_in_synpred32_InternalDomainmodel11248); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalDomainmodel

    // Delegated rules

    public final boolean synpred7_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalDomainmodel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA32 dfa32 = new DFA32(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA83 dfa83 = new DFA83(this);
    static final String DFA32_eotS =
        "\74\uffff";
    static final String DFA32_eofS =
        "\1\2\73\uffff";
    static final String DFA32_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA32_maxS =
        "\1\110\1\0\72\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA32_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA32_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\1\1\4\2\1\uffff\26\2\1"+
            "\uffff\15\2\1\uffff\13\2",
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
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "2014:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA31_eotS =
        "\34\uffff";
    static final String DFA31_eofS =
        "\34\uffff";
    static final String DFA31_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA31_maxS =
        "\1\110\2\0\31\uffff";
    static final String DFA31_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA31_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\5\1\1\6\uffff\1\5\5\uffff\1\2\1\uffff\1\33\14\uffff\1\5\2"+
            "\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            return "2035:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_0 = input.LA(1);

                         
                        int index31_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA31_0==RULE_ID) ) {s = 1;}

                        else if ( (LA31_0==19) ) {s = 2;}

                        else if ( (LA31_0==72) && (synpred14_InternalDomainmodel())) {s = 3;}

                        else if ( (LA31_0==47) && (synpred14_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA31_0>=RULE_INT && LA31_0<=RULE_STRING)||LA31_0==13||LA31_0==34||(LA31_0>=37 && LA31_0<=38)||LA31_0==42||LA31_0==46||LA31_0==50||LA31_0==52||(LA31_0>=55 && LA31_0<=57)||LA31_0==60||(LA31_0>=62 && LA31_0<=69)) ) {s = 5;}

                        else if ( (LA31_0==21) ) {s = 27;}

                         
                        input.seek(index31_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index31_2);
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
        "\74\uffff";
    static final String DFA33_eofS =
        "\1\2\73\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA33_maxS =
        "\1\110\1\0\72\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA33_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\25\2\1\1\1"+
            "\uffff\15\2\1\uffff\13\2",
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
            return "2114:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\36\uffff";
    static final String DFA39_eofS =
        "\36\uffff";
    static final String DFA39_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA39_maxS =
        "\1\110\2\0\33\uffff";
    static final String DFA39_acceptS =
        "\3\uffff\2\1\1\2\30\uffff";
    static final String DFA39_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA39_transitionS = {
            "\2\5\1\1\6\uffff\1\5\5\uffff\1\2\16\uffff\1\5\2\uffff\2\5\3"+
            "\uffff\1\5\3\uffff\1\5\1\4\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff"+
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
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "2397:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_0 = input.LA(1);

                         
                        int index39_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA39_0==RULE_ID) ) {s = 1;}

                        else if ( (LA39_0==19) ) {s = 2;}

                        else if ( (LA39_0==72) && (synpred16_InternalDomainmodel())) {s = 3;}

                        else if ( (LA39_0==47) && (synpred16_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA39_0>=RULE_INT && LA39_0<=RULE_STRING)||LA39_0==13||LA39_0==34||(LA39_0>=37 && LA39_0<=38)||LA39_0==42||LA39_0==46||LA39_0==48||LA39_0==50||LA39_0==52||(LA39_0>=55 && LA39_0<=60)||(LA39_0>=62 && LA39_0<=69)) ) {s = 5;}

                         
                        input.seek(index39_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\74\uffff";
    static final String DFA62_eofS =
        "\1\2\73\uffff";
    static final String DFA62_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA62_maxS =
        "\1\110\1\0\72\uffff";
    static final String DFA62_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA62_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA62_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\1\1\4\2\1\uffff\26\2\1"+
            "\uffff\15\2\1\uffff\13\2",
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
            return "3700:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
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
                        if ( (synpred21_InternalDomainmodel()) ) {s = 59;}

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
    static final String DFA61_eotS =
        "\34\uffff";
    static final String DFA61_eofS =
        "\34\uffff";
    static final String DFA61_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA61_maxS =
        "\1\110\2\0\31\uffff";
    static final String DFA61_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA61_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA61_transitionS = {
            "\2\5\1\1\6\uffff\1\5\5\uffff\1\2\1\uffff\1\33\14\uffff\1\5\2"+
            "\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            return "3721:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_0 = input.LA(1);

                         
                        int index61_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA61_0==RULE_ID) ) {s = 1;}

                        else if ( (LA61_0==19) ) {s = 2;}

                        else if ( (LA61_0==72) && (synpred22_InternalDomainmodel())) {s = 3;}

                        else if ( (LA61_0==47) && (synpred22_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA61_0>=RULE_INT && LA61_0<=RULE_STRING)||LA61_0==13||LA61_0==34||(LA61_0>=37 && LA61_0<=38)||LA61_0==42||LA61_0==46||LA61_0==50||LA61_0==52||(LA61_0>=55 && LA61_0<=57)||LA61_0==60||(LA61_0>=62 && LA61_0<=69)) ) {s = 5;}

                        else if ( (LA61_0==21) ) {s = 27;}

                         
                        input.seek(index61_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index61_2);
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
    static final String DFA63_eotS =
        "\74\uffff";
    static final String DFA63_eofS =
        "\1\2\73\uffff";
    static final String DFA63_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA63_maxS =
        "\1\110\1\0\72\uffff";
    static final String DFA63_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA63_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA63_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\25\2\1\1\1"+
            "\uffff\15\2\1\uffff\13\2",
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
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "3800:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
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
        "\1\110\2\0\31\uffff";
    static final String DFA69_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA69_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA69_transitionS = {
            "\2\5\1\1\6\uffff\1\5\5\uffff\1\2\1\uffff\1\33\14\uffff\1\5\2"+
            "\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\2\uffff\1\5\1\uffff\1"+
            "\5\2\uffff\3\5\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
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
            return "3997:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
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

                        else if ( (LA69_0==19) ) {s = 2;}

                        else if ( (LA69_0==72) && (synpred24_InternalDomainmodel())) {s = 3;}

                        else if ( (LA69_0==47) && (synpred24_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA69_0>=RULE_INT && LA69_0<=RULE_STRING)||LA69_0==13||LA69_0==34||(LA69_0>=37 && LA69_0<=38)||LA69_0==42||LA69_0==46||LA69_0==50||LA69_0==52||(LA69_0>=55 && LA69_0<=57)||LA69_0==60||(LA69_0>=62 && LA69_0<=69)) ) {s = 5;}

                        else if ( (LA69_0==21) ) {s = 27;}

                         
                        input.seek(index69_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA69_2 = input.LA(1);

                         
                        int index69_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalDomainmodel()) ) {s = 4;}

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
    static final String DFA70_eotS =
        "\74\uffff";
    static final String DFA70_eofS =
        "\1\2\73\uffff";
    static final String DFA70_minS =
        "\1\4\1\0\72\uffff";
    static final String DFA70_maxS =
        "\1\110\1\0\72\uffff";
    static final String DFA70_acceptS =
        "\2\uffff\1\2\70\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\72\uffff}>";
    static final String[] DFA70_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\25\2\1\1\1"+
            "\uffff\15\2\1\uffff\13\2",
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
            return "4076:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
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
                        if ( (synpred25_InternalDomainmodel()) ) {s = 59;}

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
        "\74\uffff";
    static final String DFA72_eofS =
        "\1\31\73\uffff";
    static final String DFA72_minS =
        "\1\4\30\0\43\uffff";
    static final String DFA72_maxS =
        "\1\110\30\0\43\uffff";
    static final String DFA72_acceptS =
        "\31\uffff\1\2\41\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\43\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\15\1\17\1\1\6\uffff\1\6\1\31\2\uffff\1\31\1\uffff\1\30\4"+
            "\31\1\uffff\11\31\1\10\2\31\1\4\1\3\3\31\1\2\3\31\1\12\1\uffff"+
            "\2\31\1\21\1\31\1\7\2\31\1\22\1\23\1\24\2\31\1\11\1\uffff\1"+
            "\5\1\13\1\14\1\16\1\20\1\25\1\26\1\27\3\31",
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
            return "4400:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_2 = input.LA(1);

                         
                        int index72_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_4 = input.LA(1);

                         
                        int index72_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_5 = input.LA(1);

                         
                        int index72_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_6 = input.LA(1);

                         
                        int index72_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA72_7 = input.LA(1);

                         
                        int index72_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA72_8 = input.LA(1);

                         
                        int index72_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA72_9 = input.LA(1);

                         
                        int index72_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA72_10 = input.LA(1);

                         
                        int index72_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA72_14 = input.LA(1);

                         
                        int index72_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA72_15 = input.LA(1);

                         
                        int index72_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA72_16 = input.LA(1);

                         
                        int index72_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA72_17 = input.LA(1);

                         
                        int index72_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA72_18 = input.LA(1);

                         
                        int index72_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA72_19 = input.LA(1);

                         
                        int index72_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA72_20 = input.LA(1);

                         
                        int index72_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA72_21 = input.LA(1);

                         
                        int index72_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA72_22 = input.LA(1);

                         
                        int index72_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA72_23 = input.LA(1);

                         
                        int index72_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA72_24 = input.LA(1);

                         
                        int index72_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalDomainmodel()) ) {s = 59;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index72_24);
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
    static final String DFA83_eotS =
        "\75\uffff";
    static final String DFA83_eofS =
        "\1\2\74\uffff";
    static final String DFA83_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA83_maxS =
        "\1\110\1\0\73\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA83_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA83_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\7\2\1\uffff\11\2\1\1\14\2\1\uffff\15"+
            "\2\1\uffff\13\2",
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
            ""
    };

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "4841:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_1 = input.LA(1);

                         
                        int index83_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index83_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleDomainModel_in_entryRuleDomainModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomainModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleDomainModel130 = new BitSet(new long[]{0x0000000000009802L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_ruleAbstractElement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleAbstractElement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleAbstractElement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport359 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageDeclaration463 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration484 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageDeclaration496 = new BitSet(new long[]{0x000000000000D800L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_rulePackageDeclaration517 = new BitSet(new long[]{0x000000000000D800L});
    public static final BitSet FOLLOW_14_in_rulePackageDeclaration530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEntity613 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleEntity634 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleEntity647 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleEntity668 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity682 = new BitSet(new long[]{0x0000000000044040L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity703 = new BitSet(new long[]{0x0000000000044040L});
    public static final BitSet FOLLOW_14_in_ruleEntity716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleFeature809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleProperty927 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleProperty939 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleProperty960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOperation1043 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleOperation1064 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1076 = new BitSet(new long[]{0x0000000000280040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleOperation1098 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleOperation1111 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleOperation1132 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleOperation1148 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleOperation1160 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleOperation1181 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleOperation1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1297 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedNameWithWildCard1316 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildCard1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression1371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment1529 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1545 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1595 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1648 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpSingleAssign1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpMultiAssign1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1943 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1996 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression2019 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOr2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression2145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2202 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression2255 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2278 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAnd2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2461 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2514 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2537 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpEquality2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpEquality2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2741 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_30_in_ruleXRelationalExpression2777 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2800 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2861 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2884 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpCompare2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpCompare2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpCompare3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpCompare3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3127 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3180 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3203 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpOther3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpOther3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3407 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3460 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3483 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpAdd3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpAdd3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3687 = new BitSet(new long[]{0x0000038000800002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3740 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3763 = new BitSet(new long[]{0x0000038000800002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpMulti3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpMulti3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4016 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary4102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpUnary4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpUnary4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4286 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXCastedExpression4321 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4344 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4439 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall4488 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4511 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4527 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4549 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall4635 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4659 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4696 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_ruleXMemberFeatureCall4725 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4746 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall4759 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4780 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXMemberFeatureCall4794 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4819 = new BitSet(new long[]{0x0000700000480002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall4853 = new BitSet(new long[]{0xD394C46400282070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4938 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4966 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall4979 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5000 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall5017 = new BitSet(new long[]{0x0000700000400002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall5050 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral5506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXClosure5789 = new BitSet(new long[]{0xDF95C46400082070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5860 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_ruleXClosure5873 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5894 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5916 = new BitSet(new long[]{0xDF95446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5953 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXClosure5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure6001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure6011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure6067 = new BitSet(new long[]{0xDF96446400082072L,0x000000000000003FL});
    public static final BitSet FOLLOW_49_in_ruleXExpressionInClosure6080 = new BitSet(new long[]{0xDF94446400082072L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure6120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure6130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6238 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_ruleXShortClosure6251 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6272 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_ruleXShortClosure6294 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure6330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleXParenthesizedExpression6413 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6435 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXParenthesizedExpression6446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXIfExpression6538 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXIfExpression6550 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6571 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXIfExpression6583 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6604 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXIfExpression6625 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXSwitchExpression6741 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6782 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6794 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6818 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleXSwitchExpression6830 = new BitSet(new long[]{0x00400000000A0040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6851 = new BitSet(new long[]{0x00600000000A4040L,0x0000000000000100L});
    public static final BitSet FOLLOW_53_in_ruleXSwitchExpression6865 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6877 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6898 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXSwitchExpression6912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart7004 = new BitSet(new long[]{0x0040000000020000L});
    public static final BitSet FOLLOW_54_in_ruleXCasePart7018 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7039 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXCasePart7053 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression7110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression7120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXForLoopExpression7166 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXForLoopExpression7178 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7199 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXForLoopExpression7211 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7232 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXForLoopExpression7244 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXWhileExpression7357 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXWhileExpression7369 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7390 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXWhileExpression7402 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXDoWhileExpression7515 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7536 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXDoWhileExpression7548 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXDoWhileExpression7560 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7581 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXDoWhileExpression7593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleXBlockExpression7685 = new BitSet(new long[]{0xDF94446400086070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7707 = new BitSet(new long[]{0xDF96446400086070L,0x000000000000003FL});
    public static final BitSet FOLLOW_49_in_ruleXBlockExpression7720 = new BitSet(new long[]{0xDF94446400086070L,0x000000000000003FL});
    public static final BitSet FOLLOW_14_in_ruleXBlockExpression7736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXVariableDeclaration7954 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_59_in_ruleXVariableDeclaration7985 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8033 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration8054 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration8083 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleXVariableDeclaration8097 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration8118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter8156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter8166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter8234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8326 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall8393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8450 = new BitSet(new long[]{0x1000000400000040L});
    public static final BitSet FOLLOW_34_in_ruleXFeatureCall8464 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8485 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall8498 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8519 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXFeatureCall8533 = new BitSet(new long[]{0x1000000400000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8558 = new BitSet(new long[]{0x0000400000080002L});
    public static final BitSet FOLLOW_19_in_ruleXFeatureCall8592 = new BitSet(new long[]{0xD394C46400282070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8677 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8705 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall8718 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8739 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall8756 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleIdOrSuper8909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier9008 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleStaticQualifier9026 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall9077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXConstructorCall9123 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9146 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_34_in_ruleXConstructorCall9159 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9180 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall9193 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9214 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXConstructorCall9228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXConstructorCall9242 = new BitSet(new long[]{0xD394C46400282070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9314 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9342 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall9355 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9376 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall9393 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall9424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXBooleanLiteral9518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXBooleanLiteral9542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXNullLiteral9648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral9694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral9745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTypeLiteral9944 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXTypeLiteral9956 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9979 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXTypeLiteral9991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression10037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXThrowExpression10083 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression10104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression10140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression10150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXReturnExpression10196 = new BitSet(new long[]{0xD394446400082072L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression10227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXTryCatchFinallyExpression10320 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10341 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10371 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_70_in_ruleXTryCatchFinallyExpression10393 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXTryCatchFinallyExpression10437 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXCatchClause10551 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXCatchClause10564 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10585 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXCatchClause10597 = new BitSet(new long[]{0xD394446400082070L,0x000000000000003FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10655 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10713 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedName10741 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10764 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10869 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleJvmTypeReference10907 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleJvmTypeReference10919 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleXFunctionTypeRef11034 = new BitSet(new long[]{0x0000000000280040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11056 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXFunctionTypeRef11069 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11090 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXFunctionTypeRef11106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleXFunctionTypeRef11120 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11235 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleJvmParameterizedTypeReference11256 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11278 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleJvmParameterizedTypeReference11291 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11312 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleJvmParameterizedTypeReference11326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleJvmWildcardTypeReference11539 = new BitSet(new long[]{0x1000000000010002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJvmUpperBound11673 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleJvmUpperBoundAnded11777 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleJvmLowerBound11881 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalDomainmodel1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalDomainmodel1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalDomainmodel2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalDomainmodel2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred5_InternalDomainmodel2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalDomainmodel2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalDomainmodel3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalDomainmodel3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalDomainmodel3708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred10_InternalDomainmodel4302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred11_InternalDomainmodel4456 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalDomainmodel4465 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalDomainmodel4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred12_InternalDomainmodel4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred12_InternalDomainmodel4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred12_InternalDomainmodel4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred13_InternalDomainmodel4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4887 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred14_InternalDomainmodel4894 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4901 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred14_InternalDomainmodel4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred15_InternalDomainmodel5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalDomainmodel5806 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred16_InternalDomainmodel5813 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalDomainmodel5820 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred16_InternalDomainmodel5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred18_InternalDomainmodel6617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalDomainmodel6757 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred19_InternalDomainmodel6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred20_InternalDomainmodel8003 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalDomainmodel8012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred21_InternalDomainmodel8574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalDomainmodel8626 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred22_InternalDomainmodel8633 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalDomainmodel8640 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred22_InternalDomainmodel8654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred23_InternalDomainmodel8772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalDomainmodel9263 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred24_InternalDomainmodel9270 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalDomainmodel9277 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred24_InternalDomainmodel9291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred25_InternalDomainmodel9407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred26_InternalDomainmodel10210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred27_InternalDomainmodel10355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred28_InternalDomainmodel10385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred30_InternalDomainmodel10732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred31_InternalDomainmodel10884 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_synpred31_InternalDomainmodel10888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred32_InternalDomainmodel11248 = new BitSet(new long[]{0x0000000000000002L});

}
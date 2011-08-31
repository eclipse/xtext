package org.eclipse.xtext.example.domainmodel.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'entity'", "'extends'", "':'", "'op'", "'('", "','", "')'", "'.'", "'*'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'as'", "'?.'", "'*.'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "';'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "':{'", "'=>'", "'?'", "'&'", "'public'", "'private'", "'protected'"
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
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__78=78;
    public static final int T__77=77;

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:68:1: entryRuleDomainModel returns [EObject current=null] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final EObject entryRuleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModel = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:69:2: (iv_ruleDomainModel= ruleDomainModel EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:70:2: iv_ruleDomainModel= ruleDomainModel EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:77:1: ruleDomainModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleDomainModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:80:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:81:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:81:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:82:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:82:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:83:3: lv_elements_0_0= ruleAbstractElement
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:107:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:108:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:109:2: iv_ruleAbstractElement= ruleAbstractElement EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:116:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_Entity_1 = null;

        EObject this_Import_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:119:28: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:120:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:120:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity | this_Import_2= ruleImport )
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:121:5: this_PackageDeclaration_0= rulePackageDeclaration
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:131:5: this_Entity_1= ruleEntity
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:141:5: this_Import_2= ruleImport
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:157:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:158:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:159:2: iv_ruleImport= ruleImport EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:166:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:169:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:170:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:170:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:170:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:174:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:175:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:175:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:176:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:200:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:201:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:202:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:209:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:212:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:213:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:213:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:213:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_rulePackageDeclaration463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:217:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:218:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:218:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:219:3: lv_name_1_0= ruleQualifiedName
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:239:1: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:240:1: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:240:1: (lv_elements_3_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:241:3: lv_elements_3_0= ruleAbstractElement
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:269:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:270:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:271:2: iv_ruleEntity= ruleEntity EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:278:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:281:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:282:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:282:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:282:3: otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleEntity613); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:286:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:287:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:287:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:288:3: lv_name_1_0= ruleValidID
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:304:2: (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:304:4: otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleEntity647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:308:1: ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:309:1: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:309:1: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:310:3: lv_superType_3_0= ruleJvmParameterizedTypeReference
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:330:1: ( (lv_features_5_0= ruleFeature ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||LA5_0==18||(LA5_0>=76 && LA5_0<=78)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:331:1: (lv_features_5_0= ruleFeature )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:331:1: (lv_features_5_0= ruleFeature )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:332:3: lv_features_5_0= ruleFeature
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:360:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:361:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:362:2: iv_ruleFeature= ruleFeature EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:369:1: ruleFeature returns [EObject current=null] : (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Property_0 = null;

        EObject this_Operation_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:372:28: ( (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:373:1: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:373:1: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==18||(LA6_0>=76 && LA6_0<=78)) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:374:5: this_Property_0= ruleProperty
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:384:5: this_Operation_1= ruleOperation
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:400:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:401:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:402:2: iv_ruleProperty= ruleProperty EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:409:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:412:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:413:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:414:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:414:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:415:3: lv_name_0_0= ruleValidID
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:435:1: ( (lv_type_2_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:436:1: (lv_type_2_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:436:1: (lv_type_2_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:437:3: lv_type_2_0= ruleJvmTypeReference
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:461:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:462:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:463:2: iv_ruleOperation= ruleOperation EOF
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:470:1: ruleOperation returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'op' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_type_9_0= ruleJvmTypeReference ) ) ( (lv_body_10_0= ruleXBlockExpression ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_visibility_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_params_4_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_type_9_0 = null;

        EObject lv_body_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:473:28: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'op' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_type_9_0= ruleJvmTypeReference ) ) ( (lv_body_10_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:474:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'op' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_type_9_0= ruleJvmTypeReference ) ) ( (lv_body_10_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:474:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'op' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_type_9_0= ruleJvmTypeReference ) ) ( (lv_body_10_0= ruleXBlockExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:474:2: ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'op' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_type_9_0= ruleJvmTypeReference ) ) ( (lv_body_10_0= ruleXBlockExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:474:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=76 && LA7_0<=78)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:475:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:475:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:476:3: lv_visibility_0_0= ruleVisibility
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVisibility_in_ruleOperation1052);
                    lv_visibility_0_0=ruleVisibility();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"visibility",
                              		lv_visibility_0_0, 
                              		"Visibility");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleOperation1065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOpKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:496:1: ( (lv_name_2_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:497:1: (lv_name_2_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:497:1: (lv_name_2_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:498:3: lv_name_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getNameValidIDParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleOperation1086);
            lv_name_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleOperation1098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:518:1: ( ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==73) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:518:2: ( (lv_params_4_0= ruleJvmFormalParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:518:2: ( (lv_params_4_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:519:1: (lv_params_4_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:519:1: (lv_params_4_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:520:3: lv_params_4_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationAccess().getParamsJvmFormalParameterParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleOperation1120);
                    lv_params_4_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                      	        }
                             		add(
                             			current, 
                             			"params",
                              		lv_params_4_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:536:2: (otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:536:4: otherlv_5= ',' ( (lv_params_6_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleOperation1133); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:540:1: ( (lv_params_6_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:541:1: (lv_params_6_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:541:1: (lv_params_6_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:542:3: lv_params_6_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationAccess().getParamsJvmFormalParameterParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleOperation1154);
                    	    lv_params_6_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"params",
                    	              		lv_params_6_0, 
                    	              		"JvmFormalParameter");
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

            otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleOperation1170); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleOperation1182); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getColonKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:566:1: ( (lv_type_9_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:567:1: (lv_type_9_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:567:1: (lv_type_9_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:568:3: lv_type_9_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getTypeJvmTypeReferenceParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleOperation1203);
            lv_type_9_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_9_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:584:2: ( (lv_body_10_0= ruleXBlockExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:585:1: (lv_body_10_0= ruleXBlockExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:585:1: (lv_body_10_0= ruleXBlockExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:586:3: lv_body_10_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationAccess().getBodyXBlockExpressionParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleOperation1224);
            lv_body_10_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOperationRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_10_0, 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:610:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:611:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:612:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1261);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1272); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:619:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:622:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:623:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:623:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:624:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1319);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:634:1: (kw= '.' kw= '*' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:635:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedNameWithWildCard1338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildCard1351); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:654:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:655:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:656:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression1393);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression1403); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:663:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:666:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:668:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1449);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:684:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:685:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:686:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1483);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1493); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:693:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:696:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==24) ) {
                    alt12=1;
                }
                else if ( (LA12_1==EOF||(LA12_1>=RULE_INT && LA12_1<=RULE_ID)||(LA12_1>=13 && LA12_1<=14)||LA12_1==17||(LA12_1>=19 && LA12_1<=23)||(LA12_1>=25 && LA12_1<=46)||(LA12_1>=48 && LA12_1<=73)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_STRING)||LA12_0==13||LA12_0==17||LA12_0==19||LA12_0==34||(LA12_0>=37 && LA12_0<=38)||LA12_0==42||LA12_0==46||LA12_0==49||LA12_0==51||(LA12_0>=54 && LA12_0<=56)||LA12_0==60||(LA12_0>=62 && LA12_0<=69)||LA12_0==72) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:697:3: ()
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:698:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:703:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:704:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:704:1: ( ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:705:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment1551);
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
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1567);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:726:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:727:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:727:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:728:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1587);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:745:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:745:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:746:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1617);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==25) ) {
                        int LA11_1 = input.LA(2);

                        if ( (synpred1_InternalDomainmodel()) ) {
                            alt11=1;
                        }
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:759:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:759:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:759:7: ()
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:760:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:765:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:766:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:766:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:767:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1670);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:780:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:781:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:781:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:782:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1693);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:806:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:807:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:808:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1733);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1744); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:815:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:818:28: (kw= '=' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:820:2: kw= '='
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleOpSingleAssign1781); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:833:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:834:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:835:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1821);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1832); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:842:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:845:28: (kw= '+=' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:847:2: kw= '+='
            {
            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpMultiAssign1869); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:860:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:861:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:862:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1908);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1918); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:869:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:872:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:873:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:873:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:874:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1965);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred2_InternalDomainmodel()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:887:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:887:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:887:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:888:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:893:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:894:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:894:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:895:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression2018);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:908:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:909:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:909:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:910:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression2041);
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:934:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:935:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:936:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2080);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2091); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:943:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:946:28: (kw= '||' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:948:2: kw= '||'
            {
            kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOr2128); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:961:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:962:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:963:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression2167);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression2177); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:970:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:973:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:974:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:974:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:975:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2224);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==27) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred3_InternalDomainmodel()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:988:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:988:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:988:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:989:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:994:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:995:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:995:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:996:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression2277);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1009:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1010:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1010:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1011:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2300);
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1035:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1036:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1037:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2339);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd2350); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1044:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1047:28: (kw= '&&' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1049:2: kw= '&&'
            {
            kw=(Token)match(input,27,FOLLOW_27_in_ruleOpAnd2387); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1062:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1063:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1064:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2426);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2436); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1071:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1074:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1075:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1075:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1076:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2483);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==28) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred4_InternalDomainmodel()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==29) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred4_InternalDomainmodel()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1089:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1089:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1089:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1090:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1095:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1096:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1096:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1097:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2536);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1110:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1111:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1111:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1112:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2559);
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
            	    break loop15;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1136:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1137:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1138:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2598);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2609); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1145:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1148:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1149:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1149:1: (kw= '==' | kw= '!=' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            else if ( (LA16_0==29) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1150:2: kw= '=='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpEquality2647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1157:2: kw= '!='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpEquality2666); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1170:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1171:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1172:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2706);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2716); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1179:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1182:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1183:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1183:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1184:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2763);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop17:
            do {
                int alt17=3;
                switch ( input.LA(1) ) {
                case 30:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred5_InternalDomainmodel()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt17=2;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt17=2;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA17_5 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt17=2;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA17_6 = input.LA(2);

                    if ( (synpred6_InternalDomainmodel()) ) {
                        alt17=2;
                    }


                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1194:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1194:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1194:6: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1195:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleXRelationalExpression2799); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1204:3: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1205:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1205:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1206:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2824);
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
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1225:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1225:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1225:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1226:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1231:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1232:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1232:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1233:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2885);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1246:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1247:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1247:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1248:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2908);
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
            	    break loop17;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1272:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1273:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1274:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2948);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2959); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1281:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1284:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1285:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1285:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt18=1;
                }
                break;
            case 32:
                {
                alt18=2;
                }
                break;
            case 33:
                {
                alt18=3;
                }
                break;
            case 34:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1286:2: kw= '>='
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpCompare2997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1293:2: kw= '<='
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpCompare3016); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1300:2: kw= '>'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpCompare3035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1307:2: kw= '<'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpCompare3054); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1320:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1321:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1322:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3094);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3104); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1329:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1332:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1333:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1333:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1334:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3151);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==35) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred7_InternalDomainmodel()) ) {
                        alt19=1;
                    }


                }
                else if ( (LA19_0==36) ) {
                    int LA19_3 = input.LA(2);

                    if ( (synpred7_InternalDomainmodel()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1347:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1347:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1347:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1348:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1353:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1354:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1354:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1355:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3204);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1368:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1369:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1369:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1370:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3227);
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
            	    break loop19;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1394:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1395:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1396:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3266);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3277); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1403:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1406:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1407:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1407:1: (kw= '->' | kw= '..' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            else if ( (LA20_0==36) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1408:2: kw= '->'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpOther3315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1415:2: kw= '..'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpOther3334); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1428:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1429:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1430:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3374);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression3384); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1437:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1440:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1441:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1441:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1442:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3431);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==37) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred8_InternalDomainmodel()) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==38) ) {
                    int LA21_3 = input.LA(2);

                    if ( (synpred8_InternalDomainmodel()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1455:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1455:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1455:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1456:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1461:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1462:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1462:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1463:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3484);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1476:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1477:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1477:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1478:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3507);
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
            	    break loop21;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1502:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1503:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1504:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3546);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3557); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1511:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1514:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1515:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1515:1: (kw= '+' | kw= '-' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            else if ( (LA22_0==38) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1516:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpAdd3595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1523:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpAdd3614); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1536:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1537:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1538:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3654);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3664); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1545:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1548:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1549:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1549:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1550:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3711);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop23:
            do {
                int alt23=2;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA23_2 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt23=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA23_3 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt23=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA23_4 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt23=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA23_5 = input.LA(2);

                    if ( (synpred9_InternalDomainmodel()) ) {
                        alt23=1;
                    }


                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1563:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1563:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1563:7: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1564:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1569:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1570:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1570:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1571:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3764);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1584:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1585:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1585:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1586:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3787);
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
            	    break loop23;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1610:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1611:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1612:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3826);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3837); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1619:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1622:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1623:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1623:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt24=1;
                }
                break;
            case 39:
                {
                alt24=2;
                }
                break;
            case 40:
                {
                alt24=3;
                }
                break;
            case 41:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1624:2: kw= '*'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpMulti3875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1631:2: kw= '**'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti3894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1638:2: kw= '/'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpMulti3913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1645:2: kw= '%'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpMulti3932); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1658:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1659:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1660:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3972);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3982); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1667:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1670:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=37 && LA25_0<=38)||LA25_0==42) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=RULE_INT && LA25_0<=RULE_ID)||LA25_0==13||LA25_0==17||LA25_0==19||LA25_0==34||LA25_0==46||LA25_0==49||LA25_0==51||(LA25_0>=54 && LA25_0<=56)||LA25_0==60||(LA25_0>=62 && LA25_0<=69)||LA25_0==72) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1671:3: ()
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1672:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1677:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1678:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1678:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1679:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4040);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1692:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1693:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1693:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1694:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4061);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1712:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4090);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1728:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1729:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1730:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary4126);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary4137); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1737:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1740:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1741:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1741:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt26=1;
                }
                break;
            case 38:
                {
                alt26=2;
                }
                break;
            case 37:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1742:2: kw= '!'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpUnary4175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1749:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpUnary4194); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1756:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpUnary4213); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1769:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1770:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1771:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4253);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression4263); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1778:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1781:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1782:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1782:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1783:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4310);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==43) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred10_InternalDomainmodel()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1793:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1793:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1793:6: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1794:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXCastedExpression4345); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1803:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1804:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1804:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1805:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4368);
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1829:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1830:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1831:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4406);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall4416); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1838:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1841:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1842:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1842:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1843:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4463);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
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
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1857:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1857:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1857:26: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1858:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall4512); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1867:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1868:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1868:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1869:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4535);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4551);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1890:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1891:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1891:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1892:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4573);
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
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1925:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1925:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1925:8: ()
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1926:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1931:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt28=3;
            	    switch ( input.LA(1) ) {
            	    case 22:
            	        {
            	        alt28=1;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt28=2;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt28=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt28) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1931:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleXMemberFeatureCall4659); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1936:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1936:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1937:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1937:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1938:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4683); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1952:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1952:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1953:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1953:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1954:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4720); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1967:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==34) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1967:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleXMemberFeatureCall4749); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1971:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1972:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1972:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1973:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4770);
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

            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1989:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop29:
            	            do {
            	                int alt29=2;
            	                int LA29_0 = input.LA(1);

            	                if ( (LA29_0==20) ) {
            	                    alt29=1;
            	                }


            	                switch (alt29) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1989:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall4783); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1993:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1994:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1994:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1995:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4804);
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
            	            	    break loop29;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,33,FOLLOW_33_in_ruleXMemberFeatureCall4818); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2015:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2016:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2016:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2017:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4843);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2030:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2030:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2030:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2030:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2037:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2038:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,19,FOLLOW_19_in_ruleXMemberFeatureCall4877); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt32=3;
            	            alt32 = dfa32.predict(input);
            	            switch (alt32) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2063:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2064:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4952);
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
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2081:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2081:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2081:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2081:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2082:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2082:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2083:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4980);
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

            	                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2099:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop31:
            	                    do {
            	                        int alt31=2;
            	                        int LA31_0 = input.LA(1);

            	                        if ( (LA31_0==20) ) {
            	                            alt31=1;
            	                        }


            	                        switch (alt31) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2099:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall4993); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2103:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2104:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2104:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2105:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5014);
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
            	                    	    break loop31;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall5031); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2133:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2134:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2135:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5072);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression5082); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2142:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XWithExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XLiteral_5 = null;

        EObject this_XIfExpression_6 = null;

        EObject this_XForLoopExpression_7 = null;

        EObject this_XWhileExpression_8 = null;

        EObject this_XDoWhileExpression_9 = null;

        EObject this_XThrowExpression_10 = null;

        EObject this_XReturnExpression_11 = null;

        EObject this_XTryCatchFinallyExpression_12 = null;

        EObject this_XParenthesizedExpression_13 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2145:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2146:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2146:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            int alt35=14;
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
            case 51:
                {
                alt35=3;
                }
                break;
            case 17:
            case 72:
                {
                alt35=4;
                }
                break;
            case RULE_ID:
            case 34:
            case 60:
                {
                alt35=5;
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
                alt35=6;
                }
                break;
            case 49:
                {
                alt35=7;
                }
                break;
            case 54:
                {
                alt35=8;
                }
                break;
            case 55:
                {
                alt35=9;
                }
                break;
            case 56:
                {
                alt35=10;
                }
                break;
            case 67:
                {
                alt35=11;
                }
                break;
            case 68:
                {
                alt35=12;
                }
                break;
            case 69:
                {
                alt35=13;
                }
                break;
            case 19:
                {
                alt35=14;
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2147:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5129);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2157:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5156);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2167:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5183);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2177:5: this_XWithExpression_3= ruleXWithExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWithExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWithExpression_in_ruleXPrimaryExpression5210);
                    this_XWithExpression_3=ruleXWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWithExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2187:5: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5237);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2197:5: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5264);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2207:5: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5291);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2217:5: this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5318);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2227:5: this_XWhileExpression_8= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5345);
                    this_XWhileExpression_8=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2237:5: this_XDoWhileExpression_9= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5372);
                    this_XDoWhileExpression_9=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2247:5: this_XThrowExpression_10= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5399);
                    this_XThrowExpression_10=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2257:5: this_XReturnExpression_11= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5426);
                    this_XReturnExpression_11=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2267:5: this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5453);
                    this_XTryCatchFinallyExpression_12=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2277:5: this_XParenthesizedExpression_13= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_13()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5480);
                    this_XParenthesizedExpression_13=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_13; 
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2293:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2294:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2295:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral5515);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral5525); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2302:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2305:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2306:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2306:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2307:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5572);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2317:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5599);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2327:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral5626);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2337:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5653);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2347:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5680);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2357:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5707);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2373:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2374:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2375:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5742);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5752); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2382:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2385:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2386:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2386:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2386:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2386:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2387:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleXClosure5798); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2396:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID||LA38_0==19||LA38_0==73) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2396:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2396:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2397:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2398:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5820);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2414:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==20) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2414:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleXClosure5833); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2418:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2419:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2419:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2420:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5854);
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleXClosure5870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2440:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2441:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2441:1: (lv_expression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2442:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5891);
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

            otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleXClosure5903); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2470:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2471:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2472:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5939);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5949); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2479:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2482:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2483:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2483:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2483:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2483:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2483:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2494:5: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2494:6: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2494:6: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2495:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2500:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||LA40_0==19||LA40_0==73) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2500:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2500:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2501:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2501:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2502:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6047);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2518:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==20) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2518:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXShortClosure6060); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2522:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2523:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2523:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2524:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6081);
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
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXShortClosure6097); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_0_0_2());
                  
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2544:3: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2545:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2545:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2546:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure6120);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2570:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2571:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2572:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6156);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6166); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2579:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2582:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2583:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2583:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2583:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleXParenthesizedExpression6203); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6225);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXParenthesizedExpression6236); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2608:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2609:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2610:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6272);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6282); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2617:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2620:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2621:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2621:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2621:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2621:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2622:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleXIfExpression6328); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXIfExpression6340); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2635:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2636:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2636:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2637:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6361);
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

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXIfExpression6373); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2657:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2658:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2658:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2659:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6394);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==50) ) {
                int LA41_1 = input.LA(2);

                if ( (synpred16_InternalDomainmodel()) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,50,FOLLOW_50_in_ruleXIfExpression6415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2680:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2681:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2681:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2682:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6437);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2706:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2707:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2708:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6475);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6485); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2715:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2718:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2719:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2719:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2719:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2719:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2720:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXSwitchExpression6531); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==17) && (synpred17_InternalDomainmodel())) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2734:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2734:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2734:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2735:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2735:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2736:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6572);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2756:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2757:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2757:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2758:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6608);
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

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXSwitchExpression6620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2778:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==17||LA43_0==19||LA43_0==53||LA43_0==73) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2779:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2779:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2780:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6641);
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
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2796:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==52) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2796:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,52,FOLLOW_52_in_ruleXSwitchExpression6655); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2804:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2805:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2805:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2806:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6688);
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

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleXSwitchExpression6702); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2834:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2835:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2836:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6738);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6748); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2843:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2846:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2847:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2847:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2847:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2847:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||LA45_0==19||LA45_0==73) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2848:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2848:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2849:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6794);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2865:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2865:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXCasePart6808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2869:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2870:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2870:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2871:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6829);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXCasePart6843); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2891:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2892:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2892:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2893:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6864);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2917:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2918:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2919:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6900);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6910); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2926:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2929:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2930:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2930:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2930:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2930:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2931:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXForLoopExpression6956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXForLoopExpression6968); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2944:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2945:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2945:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2946:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6989);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleXForLoopExpression7001); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2966:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2967:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2967:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2968:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7022);
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

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleXForLoopExpression7034); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2988:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2989:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2989:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2990:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7055);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3014:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3015:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3016:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7091);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7101); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3023:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3026:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3027:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3027:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3027:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3027:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3028:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXWhileExpression7147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXWhileExpression7159); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3041:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3042:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3042:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3043:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7180);
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

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXWhileExpression7192); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3063:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3064:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3064:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3065:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7213);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3089:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3090:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3091:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7249);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7259); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3098:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3101:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3102:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3102:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3102:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3102:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3103:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleXDoWhileExpression7305); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3112:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3113:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3113:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3114:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7326);
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

            otherlv_3=(Token)match(input,55,FOLLOW_55_in_ruleXDoWhileExpression7338); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleXDoWhileExpression7350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3138:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3139:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3139:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3140:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7371);
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

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleXDoWhileExpression7383); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3168:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3169:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3170:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7419);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7429); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3177:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3180:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3181:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3181:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3181:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3181:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3182:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleXBlockExpression7475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3191:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=RULE_INT && LA48_0<=RULE_ID)||LA48_0==13||LA48_0==17||LA48_0==19||LA48_0==34||(LA48_0>=37 && LA48_0<=38)||LA48_0==42||LA48_0==46||LA48_0==49||LA48_0==51||(LA48_0>=54 && LA48_0<=56)||(LA48_0>=58 && LA48_0<=60)||(LA48_0>=62 && LA48_0<=69)||LA48_0==72) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3191:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3191:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3192:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3192:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3193:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7497);
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

            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3209:2: (otherlv_3= ';' )?
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==57) ) {
            	        alt47=1;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3209:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleXBlockExpression7510); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXBlockExpression7526); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3225:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3226:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3227:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7562);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7572); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3234:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3237:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3238:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3238:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=58 && LA49_0<=59)) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=RULE_INT && LA49_0<=RULE_ID)||LA49_0==13||LA49_0==17||LA49_0==19||LA49_0==34||(LA49_0>=37 && LA49_0<=38)||LA49_0==42||LA49_0==46||LA49_0==49||LA49_0==51||(LA49_0>=54 && LA49_0<=56)||LA49_0==60||(LA49_0>=62 && LA49_0<=69)||LA49_0==72) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3239:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7619);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3249:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7646);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3265:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3266:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3267:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7681);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7691); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3274:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3277:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3278:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3278:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3278:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3278:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3279:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3284:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==58) ) {
                alt50=1;
            }
            else if ( (LA50_0==59) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3284:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3284:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3285:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3285:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3286:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,58,FOLLOW_58_in_ruleXVariableDeclaration7744); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3300:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleXVariableDeclaration7775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (synpred18_InternalDomainmodel()) ) {
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
            else if ( (LA51_0==19) && (synpred18_InternalDomainmodel())) {
                alt51=1;
            }
            else if ( (LA51_0==73) && (synpred18_InternalDomainmodel())) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3312:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3312:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3312:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3313:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3313:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3314:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7823);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3330:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3331:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3331:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3332:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7844);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3349:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3349:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3350:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3350:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3351:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7873);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3367:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==24) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3367:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleXVariableDeclaration7887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3371:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3372:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3372:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3373:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7908);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3397:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3398:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3399:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7946);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7956); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3406:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3409:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3410:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3410:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3410:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3410:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==RULE_ID||LA53_1==22||LA53_1==34||LA53_1==46) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==19||LA53_0==73) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3411:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3411:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3412:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8002);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3428:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3429:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3429:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3430:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter8024);
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


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3454:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3455:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3456:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8060);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall8070); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3463:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3466:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3467:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3467:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3467:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3467:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3468:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3473:2: ( ( ruleStaticQualifier ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==61) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3474:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3474:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3475:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8127);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3488:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==34) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3488:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXFeatureCall8141); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3492:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3493:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3493:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3494:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8162);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3510:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==20) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3510:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall8175); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3514:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3515:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3515:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3516:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8196);
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

                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleXFeatureCall8210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3536:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3537:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3537:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3538:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8235);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3551:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3551:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3551:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3551:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3558:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3559:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,19,FOLLOW_19_in_ruleXFeatureCall8269); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt58=3;
                    alt58 = dfa58.predict(input);
                    switch (alt58) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3584:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3585:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8344);
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
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3602:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3602:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3602:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3602:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3603:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3603:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3604:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8372);
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

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3620:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==20) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3620:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall8385); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3624:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3625:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3625:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3626:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8406);
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

                    otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall8423); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3654:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3655:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3656:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8462);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8473); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3663:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3666:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3667:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3667:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                alt60=1;
            }
            else if ( (LA60_0==60) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3668:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8520);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3680:2: kw= 'super'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleIdOrSuper8544); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3693:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3694:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3695:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8585);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8596); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3702:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3705:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3706:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3706:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    int LA61_2 = input.LA(2);

                    if ( (LA61_2==61) ) {
                        alt61=1;
                    }


                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3707:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8643);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,61,FOLLOW_61_in_ruleStaticQualifier8661); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3731:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3732:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3733:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8702);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8712); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3740:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3743:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3744:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3744:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3744:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3744:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3745:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXConstructorCall8758); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3754:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3755:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3755:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3756:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8781);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3769:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==34) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3769:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXConstructorCall8794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3773:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3774:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3774:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3775:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8815);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3791:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==20) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3791:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall8828); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3795:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3796:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3796:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3797:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8849);
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
                    	    break loop62;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleXConstructorCall8863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleXConstructorCall8877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt65=3;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3833:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3834:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8939);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3851:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3851:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3851:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3851:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3852:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3852:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3853:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8967);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3869:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==20) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3869:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleXConstructorCall8980); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3873:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3874:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3874:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3875:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9001);
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
                    	    break loop64;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleXConstructorCall9018); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3903:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3904:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3905:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9054);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9064); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3912:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3915:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3916:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3916:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3916:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3916:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3917:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3922:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==63) ) {
                alt66=1;
            }
            else if ( (LA66_0==64) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3922:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXBooleanLiteral9111); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3927:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3927:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3928:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3928:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3929:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,64,FOLLOW_64_in_ruleXBooleanLiteral9135); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3950:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3951:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3952:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9185);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9195); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3959:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3962:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3963:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3963:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3963:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3963:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3964:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXNullLiteral9241); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3981:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3982:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3983:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9277);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral9287); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3990:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3993:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3994:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3994:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3994:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3994:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3995:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4000:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4001:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4001:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4002:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral9338); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4026:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4027:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4028:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9379);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9389); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4035:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4038:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4039:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4039:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4039:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4039:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4040:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4045:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4046:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4046:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4047:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9440); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4071:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4072:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4073:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9481);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9491); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4080:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4083:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4084:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4084:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4084:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4084:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4085:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXTypeLiteral9537); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleXTypeLiteral9549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4098:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4099:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4099:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4100:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9572);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXTypeLiteral9584); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4125:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4126:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4127:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9620);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9630); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4134:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4137:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4138:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4138:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4138:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4138:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4139:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleXThrowExpression9676); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4148:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4149:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4149:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4150:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9697);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4174:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4175:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4176:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9733);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9743); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4183:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4186:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4187:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4187:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4187:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4187:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4188:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXReturnExpression9789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4202:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4203:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9820);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4227:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4228:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4229:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9857);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9867); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4236:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4239:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4240:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4240:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4240:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4240:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4241:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXTryCatchFinallyExpression9913); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4250:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4251:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4251:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4252:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9934);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==71) ) {
                alt70=1;
            }
            else if ( (LA70_0==70) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt68=0;
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==71) ) {
                            int LA68_2 = input.LA(2);

                            if ( (synpred23_InternalDomainmodel()) ) {
                                alt68=1;
                            }


                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4270:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4271:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9964);
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
                    	    if ( cnt68 >= 1 ) break loop68;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(68, input);
                                throw eee;
                        }
                        cnt68++;
                    } while (true);

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==70) ) {
                        int LA69_1 = input.LA(2);

                        if ( (synpred24_InternalDomainmodel()) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,70,FOLLOW_70_in_ruleXTryCatchFinallyExpression9986); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4292:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4293:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4293:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4294:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10008);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4311:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4311:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4311:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,70,FOLLOW_70_in_ruleXTryCatchFinallyExpression10030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4315:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4316:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4316:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4317:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10051);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4341:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4342:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4343:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10089);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10099); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4350:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4353:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4354:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4354:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4354:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4354:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4354:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleXCatchClause10144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleXCatchClause10157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4363:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4364:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4364:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4365:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10178);
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

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXCatchClause10190); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4385:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4386:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4386:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4387:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10211);
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


    // $ANTLR start "entryRuleXWithExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4411:1: entryRuleXWithExpression returns [EObject current=null] : iv_ruleXWithExpression= ruleXWithExpression EOF ;
    public final EObject entryRuleXWithExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWithExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4412:2: (iv_ruleXWithExpression= ruleXWithExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4413:2: iv_ruleXWithExpression= ruleXWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWithExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWithExpression_in_entryRuleXWithExpression10247);
            iv_ruleXWithExpression=ruleXWithExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWithExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWithExpression10257); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWithExpression"


    // $ANTLR start "ruleXWithExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4420:1: ruleXWithExpression returns [EObject current=null] : ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) ) ;
    public final EObject ruleXWithExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_variable_2_0 = null;

        EObject lv_mainExpression_4_0 = null;

        EObject lv_blockExpression_5_0 = null;

        EObject lv_blockExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4423:28: ( ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4424:1: ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4424:1: ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4424:2: () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4424:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4425:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWithExpressionAccess().getXWithExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4430:2: (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==17) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==RULE_ID) ) {
                    int LA71_3 = input.LA(3);

                    if ( (LA71_3==17||LA71_3==72) ) {
                        alt71=1;
                    }
                }
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4430:4: otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXWithExpression10304); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXWithExpressionAccess().getColonKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4434:1: ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4435:1: (lv_variable_2_0= ruleJvmFormalParameterWithoutType )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4435:1: (lv_variable_2_0= ruleJvmFormalParameterWithoutType )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4436:3: lv_variable_2_0= ruleJvmFormalParameterWithoutType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getVariableJvmFormalParameterWithoutTypeParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameterWithoutType_in_ruleXWithExpression10325);
                    lv_variable_2_0=ruleJvmFormalParameterWithoutType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"variable",
                              		lv_variable_2_0, 
                              		"JvmFormalParameterWithoutType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4452:4: ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==17) ) {
                alt72=1;
            }
            else if ( (LA72_0==72) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4452:5: (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4452:5: (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4452:7: otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleXWithExpression10341); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXWithExpressionAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4456:1: ( (lv_mainExpression_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4457:1: (lv_mainExpression_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4457:1: (lv_mainExpression_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4458:3: lv_mainExpression_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getMainExpressionXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXWithExpression10362);
                    lv_mainExpression_4_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"mainExpression",
                              		lv_mainExpression_4_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4474:2: ( (lv_blockExpression_5_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4475:1: (lv_blockExpression_5_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4475:1: (lv_blockExpression_5_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4476:3: lv_blockExpression_5_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getBlockExpressionXBlockExpressionParserRuleCall_2_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXWithExpression10383);
                    lv_blockExpression_5_0=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"blockExpression",
                              		lv_blockExpression_5_0, 
                              		"XBlockExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4493:6: ( (lv_blockExpression_6_0= ruleXMustacheExpression ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4493:6: ( (lv_blockExpression_6_0= ruleXMustacheExpression ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4494:1: (lv_blockExpression_6_0= ruleXMustacheExpression )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4494:1: (lv_blockExpression_6_0= ruleXMustacheExpression )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4495:3: lv_blockExpression_6_0= ruleXMustacheExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getBlockExpressionXMustacheExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMustacheExpression_in_ruleXWithExpression10411);
                    lv_blockExpression_6_0=ruleXMustacheExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"blockExpression",
                              		lv_blockExpression_6_0, 
                              		"XMustacheExpression");
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
    // $ANTLR end "ruleXWithExpression"


    // $ANTLR start "entryRuleJvmFormalParameterWithoutType"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4519:1: entryRuleJvmFormalParameterWithoutType returns [EObject current=null] : iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF ;
    public final EObject entryRuleJvmFormalParameterWithoutType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameterWithoutType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4520:2: (iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4521:2: iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterWithoutTypeRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameterWithoutType_in_entryRuleJvmFormalParameterWithoutType10448);
            iv_ruleJvmFormalParameterWithoutType=ruleJvmFormalParameterWithoutType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameterWithoutType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameterWithoutType10458); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameterWithoutType"


    // $ANTLR start "ruleJvmFormalParameterWithoutType"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4528:1: ruleJvmFormalParameterWithoutType returns [EObject current=null] : ( (lv_name_0_0= ruleValidID ) ) ;
    public final EObject ruleJvmFormalParameterWithoutType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4531:28: ( ( (lv_name_0_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4532:1: ( (lv_name_0_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4532:1: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4533:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4533:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4534:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterWithoutTypeAccess().getNameValidIDParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameterWithoutType10503);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterWithoutTypeRule());
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameterWithoutType"


    // $ANTLR start "entryRuleXMustacheExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4558:1: entryRuleXMustacheExpression returns [EObject current=null] : iv_ruleXMustacheExpression= ruleXMustacheExpression EOF ;
    public final EObject entryRuleXMustacheExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMustacheExpression = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4559:2: (iv_ruleXMustacheExpression= ruleXMustacheExpression EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4560:2: iv_ruleXMustacheExpression= ruleXMustacheExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMustacheExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMustacheExpression_in_entryRuleXMustacheExpression10538);
            iv_ruleXMustacheExpression=ruleXMustacheExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMustacheExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMustacheExpression10548); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMustacheExpression"


    // $ANTLR start "ruleXMustacheExpression"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4567:1: ruleXMustacheExpression returns [EObject current=null] : ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' ) ;
    public final EObject ruleXMustacheExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4570:28: ( ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4571:1: ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4571:1: ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4571:2: () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4571:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4572:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXMustacheExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXMustacheExpression10594); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXMustacheExpressionAccess().getColonLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4581:1: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=RULE_INT && LA73_0<=RULE_ID)||LA73_0==13||LA73_0==17||LA73_0==19||LA73_0==34||(LA73_0>=37 && LA73_0<=38)||LA73_0==42||LA73_0==46||LA73_0==49||LA73_0==51||(LA73_0>=54 && LA73_0<=56)||(LA73_0>=58 && LA73_0<=60)||(LA73_0>=62 && LA73_0<=69)||LA73_0==72) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4582:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4582:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4583:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMustacheExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXMustacheExpression10615);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMustacheExpressionRule());
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
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleXMustacheExpression10628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXMustacheExpressionAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleXMustacheExpression"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4611:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4612:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4613:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10665);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10676); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4620:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4623:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4624:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4624:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4625:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10723);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4635:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==22) ) {
                    int LA74_2 = input.LA(2);

                    if ( (LA74_2==RULE_ID) ) {
                        int LA74_3 = input.LA(3);

                        if ( (synpred26_InternalDomainmodel()) ) {
                            alt74=1;
                        }


                    }


                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4635:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4635:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4635:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedName10751); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10774);
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


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4662:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4663:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4664:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10821);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10831); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4671:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4674:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4675:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4675:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==19||LA76_0==73) ) {
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4675:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4675:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4676:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10879);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4684:1: ( () otherlv_2= '[' otherlv_3= ']' )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==46) ) {
                            int LA75_2 = input.LA(2);

                            if ( (LA75_2==48) ) {
                                alt75=1;
                            }


                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4684:2: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4684:2: ()
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4685:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleJvmTypeReference10900); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleJvmTypeReference10912); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_2());
                    	          
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
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4700:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10943);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4716:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4717:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4718:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10978);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10988); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4725:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4728:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4729:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4729:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4729:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4729:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==19) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4729:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleXFunctionTypeRef11026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4733:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4734:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4734:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4735:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11047);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4751:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==20) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4751:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXFunctionTypeRef11060); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4755:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4756:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4756:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4757:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11081);
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
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXFunctionTypeRef11095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,73,FOLLOW_73_in_ruleXFunctionTypeRef11109); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4781:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4782:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4782:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4783:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11130);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4807:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4808:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4809:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11166);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11176); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4816:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4819:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4820:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4820:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4820:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4820:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4821:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4821:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4822:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11224);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleJvmParameterizedTypeReference11245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4840:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4841:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4842:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11267);
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

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4858:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==20) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4858:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleJvmParameterizedTypeReference11280); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4862:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4863:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4863:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4864:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11301);
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
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleJvmParameterizedTypeReference11315); if (state.failed) return current;
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4892:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4893:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4894:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11353);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11363); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4901:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4904:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4905:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4905:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID||LA81_0==19||LA81_0==73) ) {
                alt81=1;
            }
            else if ( (LA81_0==74) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4906:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11410);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4916:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11437);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4932:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4933:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4934:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11472);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11482); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4941:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4944:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4945:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4945:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4945:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4945:2: ()
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4946:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleJvmWildcardTypeReference11528); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4955:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt82=3;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==16) ) {
                alt82=1;
            }
            else if ( (LA82_0==60) ) {
                alt82=2;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4955:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4955:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4956:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4956:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4957:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11550);
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
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4974:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4974:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4975:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4975:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4976:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11577);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5000:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5001:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5002:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11615);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11625); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5009:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5012:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5013:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5013:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5013:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJvmUpperBound11662); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5017:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5018:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5018:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5019:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11683);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5043:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5044:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5045:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11719);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11729); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5052:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5055:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5056:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5056:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5056:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleJvmUpperBoundAnded11766); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5060:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5061:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5061:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5062:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11787);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5086:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5087:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5088:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11823);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11833); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5095:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5098:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5099:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5099:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5099:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleJvmLowerBound11870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5103:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5104:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5104:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5105:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11891);
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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5131:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5132:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5133:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11930);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11941); if (state.failed) return current;

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5140:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5143:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5144:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11980); if (state.failed) return current;
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


    // $ANTLR start "ruleVisibility"
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5159:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) | (enumLiteral_2= 'protected' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5161:28: ( ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) | (enumLiteral_2= 'protected' ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5162:1: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) | (enumLiteral_2= 'protected' ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5162:1: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'private' ) | (enumLiteral_2= 'protected' ) )
            int alt83=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt83=1;
                }
                break;
            case 77:
                {
                alt83=2;
                }
                break;
            case 78:
                {
                alt83=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5162:2: (enumLiteral_0= 'public' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5162:2: (enumLiteral_0= 'public' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5162:4: enumLiteral_0= 'public'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleVisibility12038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPublicEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5168:6: (enumLiteral_1= 'private' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5168:6: (enumLiteral_1= 'private' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5168:8: enumLiteral_1= 'private'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleVisibility12055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getPrivateEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5174:6: (enumLiteral_2= 'protected' )
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5174:6: (enumLiteral_2= 'protected' )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:5174:8: enumLiteral_2= 'protected'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_78_in_ruleVisibility12072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getProtectedEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleVisibility"

    // $ANTLR start synpred1_InternalDomainmodel
    public final void synpred1_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:754:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:755:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:755:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:756:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:756:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:757:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalDomainmodel1638);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:882:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:883:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:883:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:884:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:884:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:885:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalDomainmodel1986);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:983:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:984:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:984:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:985:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:985:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:986:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalDomainmodel2245);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1084:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1085:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1085:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1086:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1086:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1087:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalDomainmodel2504);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1192:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1193:1: 
        {
        }

        match(input,30,FOLLOW_30_in_synpred5_InternalDomainmodel2780); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalDomainmodel

    // $ANTLR start synpred6_InternalDomainmodel
    public final void synpred6_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1220:10: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1221:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1221:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1222:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1222:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1223:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalDomainmodel2853);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1342:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1343:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1343:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1344:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1344:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1345:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalDomainmodel3172);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1450:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1451:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1451:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1452:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1452:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1453:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalDomainmodel3452);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1558:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1559:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1559:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1560:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1560:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1561:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalDomainmodel3732);
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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:4: ( () 'as' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:5: () 'as'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1791:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1792:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred10_InternalDomainmodel4326); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalDomainmodel

    // $ANTLR start synpred11_InternalDomainmodel
    public final void synpred11_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1851:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1852:1: 
        {
        }

        match(input,22,FOLLOW_22_in_synpred11_InternalDomainmodel4480); if (state.failed) return ;
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1853:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1854:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1854:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1855:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalDomainmodel4489);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalDomainmodel4495);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalDomainmodel

    // $ANTLR start synpred12_InternalDomainmodel
    public final void synpred12_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1909:10: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1910:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1910:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt84=3;
        switch ( input.LA(1) ) {
        case 22:
            {
            alt84=1;
            }
            break;
        case 44:
            {
            alt84=2;
            }
            break;
        case 45:
            {
            alt84=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 84, 0, input);

            throw nvae;
        }

        switch (alt84) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1910:4: '.'
                {
                match(input,22,FOLLOW_22_in_synpred12_InternalDomainmodel4598); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1912:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1912:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1913:1: ( '?.' )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1913:1: ( '?.' )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1914:2: '?.'
                {
                match(input,44,FOLLOW_44_in_synpred12_InternalDomainmodel4612); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1919:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1919:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1920:1: ( '*.' )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1920:1: ( '*.' )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:1921:2: '*.'
                {
                match(input,45,FOLLOW_45_in_synpred12_InternalDomainmodel4632); if (state.failed) return ;

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
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2030:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2031:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2031:1: ( '(' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2032:2: '('
        {
        match(input,19,FOLLOW_19_in_synpred13_InternalDomainmodel4859); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalDomainmodel

    // $ANTLR start synpred14_InternalDomainmodel
    public final void synpred14_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2051:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2052:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2052:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==RULE_ID||LA86_0==19||LA86_0==73) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2052:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2052:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2053:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2053:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2054:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4911);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2056:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop85:
                do {
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==20) ) {
                        alt85=1;
                    }


                    switch (alt85) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2056:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred14_InternalDomainmodel4918); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2057:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2058:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2058:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2059:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4925);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop85;
                    }
                } while (true);


                }
                break;

        }

        match(input,47,FOLLOW_47_in_synpred14_InternalDomainmodel4935); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalDomainmodel

    // $ANTLR start synpred16_InternalDomainmodel
    public final void synpred16_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:4: ( 'else' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2675:6: 'else'
        {
        match(input,50,FOLLOW_50_in_synpred16_InternalDomainmodel6407); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalDomainmodel

    // $ANTLR start synpred17_InternalDomainmodel
    public final void synpred17_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2729:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2730:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2730:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:2731:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred17_InternalDomainmodel6547);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,17,FOLLOW_17_in_synpred17_InternalDomainmodel6553); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalDomainmodel

    // $ANTLR start synpred18_InternalDomainmodel
    public final void synpred18_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3304:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3305:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3305:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3306:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred18_InternalDomainmodel7793);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3308:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3309:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3309:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3310:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred18_InternalDomainmodel7802);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred18_InternalDomainmodel

    // $ANTLR start synpred19_InternalDomainmodel
    public final void synpred19_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3551:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3552:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3552:1: ( '(' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3553:2: '('
        {
        match(input,19,FOLLOW_19_in_synpred19_InternalDomainmodel8251); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalDomainmodel

    // $ANTLR start synpred20_InternalDomainmodel
    public final void synpred20_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3572:6: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3573:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3573:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==RULE_ID||LA90_0==19||LA90_0==73) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3573:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3573:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3574:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3574:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3575:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalDomainmodel8303);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3577:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop89:
                do {
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==20) ) {
                        alt89=1;
                    }


                    switch (alt89) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3577:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred20_InternalDomainmodel8310); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3578:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3579:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3579:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3580:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalDomainmodel8317);
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

        match(input,47,FOLLOW_47_in_synpred20_InternalDomainmodel8327); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalDomainmodel

    // $ANTLR start synpred21_InternalDomainmodel
    public final void synpred21_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3821:5: ()
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3822:1: 
        {
        }

        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3822:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==19||LA92_0==73) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3822:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3822:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3823:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3823:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3824:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalDomainmodel8898);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3826:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==20) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3826:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,20,FOLLOW_20_in_synpred21_InternalDomainmodel8905); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3827:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3828:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3828:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:3829:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalDomainmodel8912);
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

        match(input,47,FOLLOW_47_in_synpred21_InternalDomainmodel8922); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalDomainmodel

    // $ANTLR start synpred22_InternalDomainmodel
    public final void synpred22_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4197:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4198:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4198:1: ( ruleXExpression )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4199:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred22_InternalDomainmodel9803);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalDomainmodel

    // $ANTLR start synpred23_InternalDomainmodel
    public final void synpred23_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:5: ( 'catch' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4268:7: 'catch'
        {
        match(input,71,FOLLOW_71_in_synpred23_InternalDomainmodel9948); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalDomainmodel

    // $ANTLR start synpred24_InternalDomainmodel
    public final void synpred24_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:5: ( 'finally' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4287:7: 'finally'
        {
        match(input,70,FOLLOW_70_in_synpred24_InternalDomainmodel9978); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalDomainmodel

    // $ANTLR start synpred26_InternalDomainmodel
    public final void synpred26_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4635:3: ( '.' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4636:2: '.'
        {
        match(input,22,FOLLOW_22_in_synpred26_InternalDomainmodel10742); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalDomainmodel

    // $ANTLR start synpred27_InternalDomainmodel
    public final void synpred27_InternalDomainmodel_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:4: ( '<' )
        // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/domainmodel/parser/antlr/internal/InternalDomainmodel.g:4835:6: '<'
        {
        match(input,34,FOLLOW_34_in_synpred27_InternalDomainmodel11237); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalDomainmodel

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
    public final boolean synpred17_InternalDomainmodel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalDomainmodel_fragment(); // can never throw exception
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


    protected DFA33 dfa33 = new DFA33(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA80 dfa80 = new DFA80(this);
    static final String DFA33_eotS =
        "\75\uffff";
    static final String DFA33_eofS =
        "\1\2\74\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA33_maxS =
        "\1\111\1\0\73\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA33_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\1\1\4\2\1\uffff\26\2\1"+
            "\uffff\15\2\1\uffff\14\2",
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
            return "2030:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
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
                        if ( (synpred13_InternalDomainmodel()) ) {s = 60;}

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
    static final String DFA32_eotS =
        "\36\uffff";
    static final String DFA32_eofS =
        "\36\uffff";
    static final String DFA32_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA32_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA32_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA32_transitionS = {
            "\2\5\1\1\6\uffff\1\5\3\uffff\1\5\1\uffff\1\2\1\uffff\1\35\14"+
            "\uffff\1\5\2\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1"+
            "\5\1\uffff\1\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff"+
            "\1\5\1\3",
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
            return "2051:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_0 = input.LA(1);

                         
                        int index32_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_0==RULE_ID) ) {s = 1;}

                        else if ( (LA32_0==19) ) {s = 2;}

                        else if ( (LA32_0==73) && (synpred14_InternalDomainmodel())) {s = 3;}

                        else if ( (LA32_0==47) && (synpred14_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA32_0>=RULE_INT && LA32_0<=RULE_STRING)||LA32_0==13||LA32_0==17||LA32_0==34||(LA32_0>=37 && LA32_0<=38)||LA32_0==42||LA32_0==46||LA32_0==49||LA32_0==51||(LA32_0>=54 && LA32_0<=56)||LA32_0==60||(LA32_0>=62 && LA32_0<=69)||LA32_0==72) ) {s = 5;}

                        else if ( (LA32_0==21) ) {s = 29;}

                         
                        input.seek(index32_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index32_2);
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
    static final String DFA59_eotS =
        "\75\uffff";
    static final String DFA59_eofS =
        "\1\2\74\uffff";
    static final String DFA59_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA59_maxS =
        "\1\111\1\0\73\uffff";
    static final String DFA59_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA59_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA59_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\1\2\1\uffff\1\1\4\2\1\uffff\26\2\1"+
            "\uffff\15\2\1\uffff\14\2",
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
            return "3551:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
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
                        if ( (synpred19_InternalDomainmodel()) ) {s = 60;}

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
            "\2\5\1\1\6\uffff\1\5\3\uffff\1\5\1\uffff\1\2\1\uffff\1\35\14"+
            "\uffff\1\5\2\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1"+
            "\5\1\uffff\1\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff"+
            "\1\5\1\3",
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
            return "3572:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
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

                        else if ( (LA58_0==19) ) {s = 2;}

                        else if ( (LA58_0==73) && (synpred20_InternalDomainmodel())) {s = 3;}

                        else if ( (LA58_0==47) && (synpred20_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA58_0>=RULE_INT && LA58_0<=RULE_STRING)||LA58_0==13||LA58_0==17||LA58_0==34||(LA58_0>=37 && LA58_0<=38)||LA58_0==42||LA58_0==46||LA58_0==49||LA58_0==51||(LA58_0>=54 && LA58_0<=56)||LA58_0==60||(LA58_0>=62 && LA58_0<=69)||LA58_0==72) ) {s = 5;}

                        else if ( (LA58_0==21) ) {s = 29;}

                         
                        input.seek(index58_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalDomainmodel()) ) {s = 4;}

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
    static final String DFA65_eotS =
        "\36\uffff";
    static final String DFA65_eofS =
        "\36\uffff";
    static final String DFA65_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA65_maxS =
        "\1\111\2\0\33\uffff";
    static final String DFA65_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA65_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA65_transitionS = {
            "\2\5\1\1\6\uffff\1\5\3\uffff\1\5\1\uffff\1\2\1\uffff\1\35\14"+
            "\uffff\1\5\2\uffff\2\5\3\uffff\1\5\3\uffff\1\5\1\4\1\uffff\1"+
            "\5\1\uffff\1\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff"+
            "\1\5\1\3",
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

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3821:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_0 = input.LA(1);

                         
                        int index65_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA65_0==RULE_ID) ) {s = 1;}

                        else if ( (LA65_0==19) ) {s = 2;}

                        else if ( (LA65_0==73) && (synpred21_InternalDomainmodel())) {s = 3;}

                        else if ( (LA65_0==47) && (synpred21_InternalDomainmodel())) {s = 4;}

                        else if ( ((LA65_0>=RULE_INT && LA65_0<=RULE_STRING)||LA65_0==13||LA65_0==17||LA65_0==34||(LA65_0>=37 && LA65_0<=38)||LA65_0==42||LA65_0==46||LA65_0==49||LA65_0==51||(LA65_0>=54 && LA65_0<=56)||LA65_0==60||(LA65_0>=62 && LA65_0<=69)||LA65_0==72) ) {s = 5;}

                        else if ( (LA65_0==21) ) {s = 29;}

                         
                        input.seek(index65_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalDomainmodel()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\75\uffff";
    static final String DFA67_eofS =
        "\1\33\74\uffff";
    static final String DFA67_minS =
        "\1\4\32\0\42\uffff";
    static final String DFA67_maxS =
        "\1\111\32\0\42\uffff";
    static final String DFA67_acceptS =
        "\33\uffff\1\2\40\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\42\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\17\1\21\1\1\6\uffff\1\6\1\33\2\uffff\1\10\1\uffff\1\32\4"+
            "\33\1\uffff\11\33\1\12\2\33\1\4\1\3\3\33\1\2\3\33\1\14\1\uffff"+
            "\1\33\1\23\1\33\1\7\2\33\1\24\1\25\1\26\3\33\1\13\1\uffff\1"+
            "\5\1\15\1\16\1\20\1\22\1\27\1\30\1\31\2\33\1\11\1\33",
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
            return "4197:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA67_25 = input.LA(1);

                         
                        int index67_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA67_26 = input.LA(1);

                         
                        int index67_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalDomainmodel()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index67_26);
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
    static final String DFA80_eotS =
        "\101\uffff";
    static final String DFA80_eofS =
        "\1\2\100\uffff";
    static final String DFA80_minS =
        "\1\4\1\0\77\uffff";
    static final String DFA80_maxS =
        "\1\116\1\0\77\uffff";
    static final String DFA80_acceptS =
        "\2\uffff\1\2\75\uffff\1\1";
    static final String DFA80_specialS =
        "\1\uffff\1\0\77\uffff}>";
    static final String[] DFA80_transitionS = {
            "\3\2\6\uffff\2\2\2\uffff\7\2\1\uffff\11\2\1\1\14\2\1\uffff\15"+
            "\2\1\uffff\14\2\2\uffff\3\2",
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
            "",
            ""
    };

    static final short[] DFA80_eot = DFA.unpackEncodedString(DFA80_eotS);
    static final short[] DFA80_eof = DFA.unpackEncodedString(DFA80_eofS);
    static final char[] DFA80_min = DFA.unpackEncodedStringToUnsignedChars(DFA80_minS);
    static final char[] DFA80_max = DFA.unpackEncodedStringToUnsignedChars(DFA80_maxS);
    static final short[] DFA80_accept = DFA.unpackEncodedString(DFA80_acceptS);
    static final short[] DFA80_special = DFA.unpackEncodedString(DFA80_specialS);
    static final short[][] DFA80_transition;

    static {
        int numStates = DFA80_transitionS.length;
        DFA80_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA80_transition[i] = DFA.unpackEncodedString(DFA80_transitionS[i]);
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = DFA80_eot;
            this.eof = DFA80_eof;
            this.min = DFA80_min;
            this.max = DFA80_max;
            this.accept = DFA80_accept;
            this.special = DFA80_special;
            this.transition = DFA80_transition;
        }
        public String getDescription() {
            return "4835:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalDomainmodel()) ) {s = 64;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
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
    public static final BitSet FOLLOW_13_in_ruleEntity682 = new BitSet(new long[]{0x0000000000044040L,0x0000000000007000L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity703 = new BitSet(new long[]{0x0000000000044040L,0x0000000000007000L});
    public static final BitSet FOLLOW_14_in_ruleEntity716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleFeature809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleProperty927 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleProperty939 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleProperty960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibility_in_ruleOperation1052 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleOperation1065 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleOperation1086 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1098 = new BitSet(new long[]{0x0000000000280040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleOperation1120 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleOperation1133 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleOperation1154 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleOperation1170 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleOperation1182 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleOperation1203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleOperation1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1319 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedNameWithWildCard1338 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildCard1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression1393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment1551 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1567 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1617 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1670 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpSingleAssign1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpMultiAssign1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1965 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression2018 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression2041 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOr2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression2167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2224 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression2277 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2300 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAnd2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2483 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2536 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2559 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpEquality2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpEquality2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2763 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_30_in_ruleXRelationalExpression2799 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2824 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2885 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2908 = new BitSet(new long[]{0x00000007C0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpCompare2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpCompare3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpCompare3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpCompare3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression3094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3151 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3204 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3227 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpOther3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpOther3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3431 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3484 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3507 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpAdd3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpAdd3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3711 = new BitSet(new long[]{0x0000038000800002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3764 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3787 = new BitSet(new long[]{0x0000038000800002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3826 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpMulti3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti3894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpMulti3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3972 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation4040 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary4126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpUnary4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpUnary4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4310 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleXCastedExpression4345 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4368 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4463 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall4512 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4535 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4551 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4573 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_22_in_ruleXMemberFeatureCall4659 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4683 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4720 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_ruleXMemberFeatureCall4749 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4770 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall4783 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4804 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXMemberFeatureCall4818 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4843 = new BitSet(new long[]{0x0000300000480002L});
    public static final BitSet FOLLOW_19_in_ruleXMemberFeatureCall4877 = new BitSet(new long[]{0xD1CAC464002A2070L,0x000000000000033FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4952 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4980 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall4993 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall5014 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall5031 = new BitSet(new long[]{0x0000300000400002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression5072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWithExpression_in_ruleXPrimaryExpression5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral5515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXClosure5798 = new BitSet(new long[]{0x0000800000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5820 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_ruleXClosure5833 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5854 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_ruleXClosure5870 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5891 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXClosure5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6047 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_ruleXShortClosure6060 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6081 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_ruleXShortClosure6097 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure6120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleXParenthesizedExpression6203 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6225 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXParenthesizedExpression6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXIfExpression6328 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXIfExpression6340 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6361 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXIfExpression6373 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6394 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXIfExpression6415 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression6531 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6584 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6608 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleXSwitchExpression6620 = new BitSet(new long[]{0x00200000000A0040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6641 = new BitSet(new long[]{0x00300000000A4040L,0x0000000000000200L});
    public static final BitSet FOLLOW_52_in_ruleXSwitchExpression6655 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6667 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6688 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXSwitchExpression6702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6794 = new BitSet(new long[]{0x0020000000020000L});
    public static final BitSet FOLLOW_53_in_ruleXCasePart6808 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6829 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXCasePart6843 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXForLoopExpression6956 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXForLoopExpression6968 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6989 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXForLoopExpression7001 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7022 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXForLoopExpression7034 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXWhileExpression7147 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXWhileExpression7159 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7180 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXWhileExpression7192 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXDoWhileExpression7305 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7326 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleXDoWhileExpression7338 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXDoWhileExpression7350 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7371 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXDoWhileExpression7383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleXBlockExpression7475 = new BitSet(new long[]{0xDDCA4464000A6070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7497 = new BitSet(new long[]{0xDFCA4464000A6070L,0x000000000000013FL});
    public static final BitSet FOLLOW_57_in_ruleXBlockExpression7510 = new BitSet(new long[]{0xDDCA4464000A6070L,0x000000000000013FL});
    public static final BitSet FOLLOW_14_in_ruleXBlockExpression7526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXVariableDeclaration7744 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_59_in_ruleXVariableDeclaration7775 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7823 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7844 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7873 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleXVariableDeclaration7887 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8002 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter8024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall8070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8127 = new BitSet(new long[]{0x1000000400000040L});
    public static final BitSet FOLLOW_34_in_ruleXFeatureCall8141 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8162 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall8175 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8196 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXFeatureCall8210 = new BitSet(new long[]{0x1000000400000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8235 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleXFeatureCall8269 = new BitSet(new long[]{0xD1CAC464002A2070L,0x000000000000033FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8344 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8372 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall8385 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8406 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall8423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleIdOrSuper8544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8643 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleStaticQualifier8661 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXConstructorCall8758 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8781 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_34_in_ruleXConstructorCall8794 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8815 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall8828 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8849 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleXConstructorCall8863 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXConstructorCall8877 = new BitSet(new long[]{0xD1CAC464002A2070L,0x000000000000033FL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8939 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8967 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXConstructorCall8980 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9001 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXConstructorCall9018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXBooleanLiteral9111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXBooleanLiteral9135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9185 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXNullLiteral9241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral9287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral9338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTypeLiteral9537 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXTypeLiteral9549 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9572 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXTypeLiteral9584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXThrowExpression9676 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXReturnExpression9789 = new BitSet(new long[]{0xD1CA4464000A2072L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXTryCatchFinallyExpression9913 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9934 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9964 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_70_in_ruleXTryCatchFinallyExpression9986 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXTryCatchFinallyExpression10030 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXCatchClause10144 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleXCatchClause10157 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10178 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXCatchClause10190 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWithExpression_in_entryRuleXWithExpression10247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWithExpression10257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXWithExpression10304 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameterWithoutType_in_ruleXWithExpression10325 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000100L});
    public static final BitSet FOLLOW_17_in_ruleXWithExpression10341 = new BitSet(new long[]{0xD1CA4464000A2070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWithExpression10362 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXWithExpression10383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_ruleXWithExpression10411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameterWithoutType_in_entryRuleJvmFormalParameterWithoutType10448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameterWithoutType10458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameterWithoutType10503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_entryRuleXMustacheExpression10538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMustacheExpression10548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXMustacheExpression10594 = new BitSet(new long[]{0xDDCA4464000A6070L,0x000000000000013FL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXMustacheExpression10615 = new BitSet(new long[]{0xDDCA4464000A6070L,0x000000000000013FL});
    public static final BitSet FOLLOW_14_in_ruleXMustacheExpression10628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10723 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedName10751 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10774 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10879 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleJvmTypeReference10900 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleJvmTypeReference10912 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleXFunctionTypeRef11026 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11047 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleXFunctionTypeRef11060 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11081 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleXFunctionTypeRef11095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleXFunctionTypeRef11109 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11224 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleJvmParameterizedTypeReference11245 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11267 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20_in_ruleJvmParameterizedTypeReference11280 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11301 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleJvmParameterizedTypeReference11315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleJvmWildcardTypeReference11528 = new BitSet(new long[]{0x1000000000010002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJvmUpperBound11662 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleJvmUpperBoundAnded11766 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleJvmLowerBound11870 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleVisibility12038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleVisibility12055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleVisibility12072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalDomainmodel1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalDomainmodel1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalDomainmodel2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalDomainmodel2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred5_InternalDomainmodel2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalDomainmodel2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalDomainmodel3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalDomainmodel3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalDomainmodel3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred10_InternalDomainmodel4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred11_InternalDomainmodel4480 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalDomainmodel4489 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalDomainmodel4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred12_InternalDomainmodel4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred12_InternalDomainmodel4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred12_InternalDomainmodel4632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred13_InternalDomainmodel4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4911 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred14_InternalDomainmodel4918 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalDomainmodel4925 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred14_InternalDomainmodel4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred16_InternalDomainmodel6407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred17_InternalDomainmodel6547 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred17_InternalDomainmodel6553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred18_InternalDomainmodel7793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred18_InternalDomainmodel7802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred19_InternalDomainmodel8251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalDomainmodel8303 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred20_InternalDomainmodel8310 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred20_InternalDomainmodel8317 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred20_InternalDomainmodel8327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalDomainmodel8898 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_20_in_synpred21_InternalDomainmodel8905 = new BitSet(new long[]{0x0000000000080040L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalDomainmodel8912 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_synpred21_InternalDomainmodel8922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred22_InternalDomainmodel9803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_synpred23_InternalDomainmodel9948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred24_InternalDomainmodel9978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred26_InternalDomainmodel10742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred27_InternalDomainmodel11237 = new BitSet(new long[]{0x0000000000000002L});

}
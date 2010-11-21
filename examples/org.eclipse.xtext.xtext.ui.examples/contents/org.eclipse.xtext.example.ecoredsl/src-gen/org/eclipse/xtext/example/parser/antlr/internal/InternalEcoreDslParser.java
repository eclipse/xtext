package org.eclipse.xtext.example.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_SERIALIZABLE", "RULE_BAG", "RULE_RANDOM", "RULE_READONLY", "RULE_INT", "RULE_LOCAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'='", "';'", "'package'", "'nsURI'", "'nsPrefix'", "'{'", "'}'", "'datatype'", "':'", "'@'", "'('", "','", "')'", "'abstract'", "'interface'", "'class'", "'<'", "'>'", "'extends'", "'ID'", "'volatile'", "'transient'", "'unsettable'", "'derived'", "'attr'", "'['", "'..'", "']'", "'val'", "'ref'", "'#'", "'enum'", "'?'", "'super'", "'op'", "'void'", "'throws'", "'.'", "'$'", "'-'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int RULE_STRING=5;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int RULE_READONLY=9;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__17=17;
    public static final int RULE_INT=10;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int RULE_RANDOM=8;
    public static final int RULE_SERIALIZABLE=6;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__44=44;
    public static final int RULE_BAG=7;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int RULE_WS=14;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int RULE_LOCAL=11;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalEcoreDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcoreDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcoreDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g"; }



     	private EcoreDslGrammarAccess grammarAccess;
     	
        public InternalEcoreDslParser(TokenStream input, IAstFactory factory, EcoreDslGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EcoreDsl";	
       	}
       	
       	@Override
       	protected EcoreDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEcoreDsl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:70:1: entryRuleEcoreDsl returns [EObject current=null] : iv_ruleEcoreDsl= ruleEcoreDsl EOF ;
    public final EObject entryRuleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEcoreDsl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:71:2: (iv_ruleEcoreDsl= ruleEcoreDsl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:72:2: iv_ruleEcoreDsl= ruleEcoreDsl EOF
            {
             newCompositeNode(grammarAccess.getEcoreDslRule()); 
            pushFollow(FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl75);
            iv_ruleEcoreDsl=ruleEcoreDsl();

            state._fsp--;

             current =iv_ruleEcoreDsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEcoreDsl85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEcoreDsl"


    // $ANTLR start "ruleEcoreDsl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:79:1: ruleEcoreDsl returns [EObject current=null] : ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) ) ;
    public final EObject ruleEcoreDsl() throws RecognitionException {
        EObject current = null;

        EObject lv_metamodelDeclarations_0_0 = null;

        EObject lv_package_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:82:28: ( ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:1: ( ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )* ( (lv_package_1_0= ruleEPackageDecl ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:83:2: ( (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:84:1: (lv_metamodelDeclarations_0_0= ruleReferencedMetamodel )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:85:3: lv_metamodelDeclarations_0_0= ruleReferencedMetamodel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEcoreDslAccess().getMetamodelDeclarationsReferencedMetamodelParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl131);
            	    lv_metamodelDeclarations_0_0=ruleReferencedMetamodel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEcoreDslRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"metamodelDeclarations",
            	            		lv_metamodelDeclarations_0_0, 
            	            		"ReferencedMetamodel");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:101:3: ( (lv_package_1_0= ruleEPackageDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:102:1: (lv_package_1_0= ruleEPackageDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:102:1: (lv_package_1_0= ruleEPackageDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:103:3: lv_package_1_0= ruleEPackageDecl
            {
             
            	        newCompositeNode(grammarAccess.getEcoreDslAccess().getPackageEPackageDeclParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl153);
            lv_package_1_0=ruleEPackageDecl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEcoreDslRule());
            	        }
                   		set(
                   			current, 
                   			"package",
                    		lv_package_1_0, 
                    		"EPackageDecl");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleEcoreDsl"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:127:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:128:2: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:129:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel189);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();

            state._fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:136:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )? ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_alias_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:139:28: ( (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )? ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:140:1: (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )? ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:140:1: (otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )? ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:140:3: otherlv_0= 'import' ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )? ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleReferencedMetamodel236); 

                	newLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:144:1: ( ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:144:2: ( (lv_alias_1_0= RULE_ID ) ) otherlv_2= '='
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:144:2: ( (lv_alias_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:145:1: (lv_alias_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:145:1: (lv_alias_1_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:146:3: lv_alias_1_0= RULE_ID
                    {
                    lv_alias_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel254); 

                    			newLeafNode(lv_alias_1_0, grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferencedMetamodelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"alias",
                            		lv_alias_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleReferencedMetamodel271); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getEqualsSignKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:166:3: ( (otherlv_3= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:167:1: (otherlv_3= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:167:1: (otherlv_3= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:168:3: otherlv_3= RULE_STRING
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencedMetamodelRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel293); 

            		newLeafNode(otherlv_3, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleReferencedMetamodel305); 

                	newLeafNode(otherlv_4, grammarAccess.getReferencedMetamodelAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleEPackageDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:191:1: entryRuleEPackageDecl returns [EObject current=null] : iv_ruleEPackageDecl= ruleEPackageDecl EOF ;
    public final EObject entryRuleEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:192:2: (iv_ruleEPackageDecl= ruleEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:193:2: iv_ruleEPackageDecl= ruleEPackageDecl EOF
            {
             newCompositeNode(grammarAccess.getEPackageDeclRule()); 
            pushFollow(FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl341);
            iv_ruleEPackageDecl=ruleEPackageDecl();

            state._fsp--;

             current =iv_ruleEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEPackageDecl351); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEPackageDecl"


    // $ANTLR start "ruleEPackageDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:200:1: ruleEPackageDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= ruleQID ) ) otherlv_3= 'nsURI' otherlv_4= '=' ( (lv_nsURI_5_0= RULE_STRING ) ) otherlv_6= 'nsPrefix' otherlv_7= '=' ( (lv_nsPrefix_8_0= ruleQID ) ) otherlv_9= '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_nsURI_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject lv_eAnnotations_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_nsPrefix_8_0 = null;

        EObject lv_eSubpackages_10_0 = null;

        EObject lv_eClassifiers_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:203:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= ruleQID ) ) otherlv_3= 'nsURI' otherlv_4= '=' ( (lv_nsURI_5_0= RULE_STRING ) ) otherlv_6= 'nsPrefix' otherlv_7= '=' ( (lv_nsPrefix_8_0= ruleQID ) ) otherlv_9= '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* otherlv_12= '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= ruleQID ) ) otherlv_3= 'nsURI' otherlv_4= '=' ( (lv_nsURI_5_0= RULE_STRING ) ) otherlv_6= 'nsPrefix' otherlv_7= '=' ( (lv_nsPrefix_8_0= ruleQID ) ) otherlv_9= '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* otherlv_12= '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= ruleQID ) ) otherlv_3= 'nsURI' otherlv_4= '=' ( (lv_nsURI_5_0= RULE_STRING ) ) otherlv_6= 'nsPrefix' otherlv_7= '=' ( (lv_nsPrefix_8_0= ruleQID ) ) otherlv_9= '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* otherlv_12= '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= ruleQID ) ) otherlv_3= 'nsURI' otherlv_4= '=' ( (lv_nsURI_5_0= RULE_STRING ) ) otherlv_6= 'nsPrefix' otherlv_7= '=' ( (lv_nsPrefix_8_0= ruleQID ) ) otherlv_9= '{' ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )* otherlv_12= '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:204:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:205:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:205:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:206:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl397);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleEPackageDecl410); 

                	newLeafNode(otherlv_1, grammarAccess.getEPackageDeclAccess().getPackageKeyword_1());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:226:1: ( (lv_name_2_0= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:227:1: (lv_name_2_0= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:227:1: (lv_name_2_0= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:228:3: lv_name_2_0= ruleQID
            {
             
            	        newCompositeNode(grammarAccess.getEPackageDeclAccess().getNameQIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl431);
            lv_name_2_0=ruleQID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEPackageDeclRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleEPackageDecl443); 

                	newLeafNode(otherlv_3, grammarAccess.getEPackageDeclAccess().getNsURIKeyword_3());
                
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleEPackageDecl455); 

                	newLeafNode(otherlv_4, grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_4());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:252:1: ( (lv_nsURI_5_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:253:1: (lv_nsURI_5_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:253:1: (lv_nsURI_5_0= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:254:3: lv_nsURI_5_0= RULE_STRING
            {
            lv_nsURI_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEPackageDecl472); 

            			newLeafNode(lv_nsURI_5_0, grammarAccess.getEPackageDeclAccess().getNsURISTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEPackageDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"nsURI",
                    		lv_nsURI_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleEPackageDecl489); 

                	newLeafNode(otherlv_6, grammarAccess.getEPackageDeclAccess().getNsPrefixKeyword_6());
                
            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleEPackageDecl501); 

                	newLeafNode(otherlv_7, grammarAccess.getEPackageDeclAccess().getEqualsSignKeyword_7());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:278:1: ( (lv_nsPrefix_8_0= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:279:1: (lv_nsPrefix_8_0= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:279:1: (lv_nsPrefix_8_0= ruleQID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:280:3: lv_nsPrefix_8_0= ruleQID
            {
             
            	        newCompositeNode(grammarAccess.getEPackageDeclAccess().getNsPrefixQIDParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleQID_in_ruleEPackageDecl522);
            lv_nsPrefix_8_0=ruleQID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEPackageDeclRule());
            	        }
                   		set(
                   			current, 
                   			"nsPrefix",
                    		lv_nsPrefix_8_0, 
                    		"QID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleEPackageDecl534); 

                	newLeafNode(otherlv_9, grammarAccess.getEPackageDeclAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:300:1: ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:300:2: ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:300:2: ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:301:1: (lv_eSubpackages_10_0= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:301:1: (lv_eSubpackages_10_0= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:302:3: lv_eSubpackages_10_0= ruleSubEPackageDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl556);
            	    lv_eSubpackages_10_0=ruleSubEPackageDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eSubpackages",
            	            		lv_eSubpackages_10_0, 
            	            		"SubEPackageDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:319:6: ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:319:6: ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:320:1: (lv_eClassifiers_11_0= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:320:1: (lv_eClassifiers_11_0= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:321:3: lv_eClassifiers_11_0= ruleEClassifierDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl583);
            	    lv_eClassifiers_11_0=ruleEClassifierDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eClassifiers",
            	            		lv_eClassifiers_11_0, 
            	            		"EClassifierDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleEPackageDecl597); 

                	newLeafNode(otherlv_12, grammarAccess.getEPackageDeclAccess().getRightCurlyBracketKeyword_11());
                

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
    // $ANTLR end "ruleEPackageDecl"


    // $ANTLR start "entryRuleSubEPackageDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:349:1: entryRuleSubEPackageDecl returns [EObject current=null] : iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF ;
    public final EObject entryRuleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubEPackageDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:350:2: (iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:351:2: iv_ruleSubEPackageDecl= ruleSubEPackageDecl EOF
            {
             newCompositeNode(grammarAccess.getSubEPackageDeclRule()); 
            pushFollow(FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl633);
            iv_ruleSubEPackageDecl=ruleSubEPackageDecl();

            state._fsp--;

             current =iv_ruleSubEPackageDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubEPackageDecl643); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubEPackageDecl"


    // $ANTLR start "ruleSubEPackageDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:358:1: ruleSubEPackageDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleSubEPackageDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eSubpackages_4_0 = null;

        EObject lv_eClassifiers_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:361:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:362:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:362:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:362:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )* otherlv_6= '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:362:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:363:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:363:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:364:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl689);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleSubEPackageDecl702); 

                	newLeafNode(otherlv_1, grammarAccess.getSubEPackageDeclAccess().getPackageKeyword_1());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:384:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:385:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:385:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:386:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubEPackageDecl719); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSubEPackageDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubEPackageDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleSubEPackageDecl736); 

                	newLeafNode(otherlv_3, grammarAccess.getSubEPackageDeclAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:406:1: ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:406:2: ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:406:2: ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:407:1: (lv_eSubpackages_4_0= ruleSubEPackageDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:407:1: (lv_eSubpackages_4_0= ruleSubEPackageDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:408:3: lv_eSubpackages_4_0= ruleSubEPackageDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubEPackageDeclAccess().getESubpackagesSubEPackageDeclParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl758);
            	    lv_eSubpackages_4_0=ruleSubEPackageDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eSubpackages",
            	            		lv_eSubpackages_4_0, 
            	            		"SubEPackageDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:425:6: ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:425:6: ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:426:1: (lv_eClassifiers_5_0= ruleEClassifierDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:426:1: (lv_eClassifiers_5_0= ruleEClassifierDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:427:3: lv_eClassifiers_5_0= ruleEClassifierDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSubEPackageDeclAccess().getEClassifiersEClassifierDeclParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl785);
            	    lv_eClassifiers_5_0=ruleEClassifierDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSubEPackageDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eClassifiers",
            	            		lv_eClassifiers_5_0, 
            	            		"EClassifierDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleSubEPackageDecl799); 

                	newLeafNode(otherlv_6, grammarAccess.getSubEPackageDeclAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleSubEPackageDecl"


    // $ANTLR start "entryRuleEClassifierDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:455:1: entryRuleEClassifierDecl returns [EObject current=null] : iv_ruleEClassifierDecl= ruleEClassifierDecl EOF ;
    public final EObject entryRuleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassifierDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:456:2: (iv_ruleEClassifierDecl= ruleEClassifierDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:457:2: iv_ruleEClassifierDecl= ruleEClassifierDecl EOF
            {
             newCompositeNode(grammarAccess.getEClassifierDeclRule()); 
            pushFollow(FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl835);
            iv_ruleEClassifierDecl=ruleEClassifierDecl();

            state._fsp--;

             current =iv_ruleEClassifierDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassifierDecl845); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClassifierDecl"


    // $ANTLR start "ruleEClassifierDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:464:1: ruleEClassifierDecl returns [EObject current=null] : (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) ;
    public final EObject ruleEClassifierDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EClassDecl_0 = null;

        EObject this_EDataTypeDecl_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:467:28: ( (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:468:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:469:5: this_EClassDecl_0= ruleEClassDecl
                    {
                     
                            newCompositeNode(grammarAccess.getEClassifierDeclAccess().getEClassDeclParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl892);
                    this_EClassDecl_0=ruleEClassDecl();

                    state._fsp--;

                     
                            current = this_EClassDecl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:479:5: this_EDataTypeDecl_1= ruleEDataTypeDecl
                    {
                     
                            newCompositeNode(grammarAccess.getEClassifierDeclAccess().getEDataTypeDeclParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl919);
                    this_EDataTypeDecl_1=ruleEDataTypeDecl();

                    state._fsp--;

                     
                            current = this_EDataTypeDecl_1; 
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
    // $ANTLR end "ruleEClassifierDecl"


    // $ANTLR start "entryRuleEDataTypeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:495:1: entryRuleEDataTypeDecl returns [EObject current=null] : iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF ;
    public final EObject entryRuleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDataTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:496:2: (iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:497:2: iv_ruleEDataTypeDecl= ruleEDataTypeDecl EOF
            {
             newCompositeNode(grammarAccess.getEDataTypeDeclRule()); 
            pushFollow(FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl954);
            iv_ruleEDataTypeDecl=ruleEDataTypeDecl();

            state._fsp--;

             current =iv_ruleEDataTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEDataTypeDecl964); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDataTypeDecl"


    // $ANTLR start "ruleEDataTypeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:504:1: ruleEDataTypeDecl returns [EObject current=null] : ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) ;
    public final EObject ruleEDataTypeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_serializable_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_eAnnotations_0_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_5_0 = null;

        EObject this_EEnumDecl_7 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:507:28: ( ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:2: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:2: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:3: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:508:3: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:509:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:509:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:510:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1011);
                    	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEDataTypeDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eAnnotations",
                    	            		lv_eAnnotations_0_0, 
                    	            		"EAnnotationDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:526:3: ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_SERIALIZABLE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:527:1: (lv_serializable_1_0= RULE_SERIALIZABLE )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:527:1: (lv_serializable_1_0= RULE_SERIALIZABLE )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:528:3: lv_serializable_1_0= RULE_SERIALIZABLE
                            {
                            lv_serializable_1_0=(Token)match(input,RULE_SERIALIZABLE,FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1029); 

                            			newLeafNode(lv_serializable_1_0, grammarAccess.getEDataTypeDeclAccess().getSerializableSerializableTerminalRuleCall_0_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getEDataTypeDeclRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"serializable",
                                    		lv_serializable_1_0, 
                                    		"Serializable");
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:3: (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:544:5: otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleEDataTypeDecl1048); 

                        	newLeafNode(otherlv_2, grammarAccess.getEDataTypeDeclAccess().getDatatypeKeyword_0_2_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:548:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:549:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:549:1: (lv_name_3_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:550:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEDataTypeDecl1065); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getEDataTypeDeclAccess().getNameIDTerminalRuleCall_0_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEDataTypeDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleEDataTypeDecl1082); 

                        	newLeafNode(otherlv_4, grammarAccess.getEDataTypeDeclAccess().getColonKeyword_0_2_2());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:570:1: ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:571:1: (lv_instanceClassName_5_0= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:571:1: (lv_instanceClassName_5_0= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:572:3: lv_instanceClassName_5_0= ruleSTRING_OR_QID
                    {
                     
                    	        newCompositeNode(grammarAccess.getEDataTypeDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_0_2_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1103);
                    lv_instanceClassName_5_0=ruleSTRING_OR_QID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEDataTypeDeclRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceClassName",
                            		lv_instanceClassName_5_0, 
                            		"STRING_OR_QID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleEDataTypeDecl1115); 

                        	newLeafNode(otherlv_6, grammarAccess.getEDataTypeDeclAccess().getSemicolonKeyword_0_2_4());
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:594:5: this_EEnumDecl_7= ruleEEnumDecl
                    {
                     
                            newCompositeNode(grammarAccess.getEDataTypeDeclAccess().getEEnumDeclParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1145);
                    this_EEnumDecl_7=ruleEEnumDecl();

                    state._fsp--;

                     
                            current = this_EEnumDecl_7; 
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
    // $ANTLR end "ruleEDataTypeDecl"


    // $ANTLR start "entryRuleEAnnotationDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:610:1: entryRuleEAnnotationDecl returns [EObject current=null] : iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF ;
    public final EObject entryRuleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAnnotationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:611:2: (iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:612:2: iv_ruleEAnnotationDecl= ruleEAnnotationDecl EOF
            {
             newCompositeNode(grammarAccess.getEAnnotationDeclRule()); 
            pushFollow(FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1180);
            iv_ruleEAnnotationDecl=ruleEAnnotationDecl();

            state._fsp--;

             current =iv_ruleEAnnotationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAnnotationDecl1190); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEAnnotationDecl"


    // $ANTLR start "ruleEAnnotationDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:619:1: ruleEAnnotationDecl returns [EObject current=null] : (otherlv_0= '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleEAnnotationDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_source_1_0 = null;

        EObject lv_details_3_0 = null;

        EObject lv_details_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:622:28: ( (otherlv_0= '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:623:1: (otherlv_0= '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:623:1: (otherlv_0= '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:623:3: otherlv_0= '@' ( (lv_source_1_0= ruleSTRING_OR_QID ) ) (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleEAnnotationDecl1227); 

                	newLeafNode(otherlv_0, grammarAccess.getEAnnotationDeclAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:627:1: ( (lv_source_1_0= ruleSTRING_OR_QID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:628:1: (lv_source_1_0= ruleSTRING_OR_QID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:628:1: (lv_source_1_0= ruleSTRING_OR_QID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:629:3: lv_source_1_0= ruleSTRING_OR_QID
            {
             
            	        newCompositeNode(grammarAccess.getEAnnotationDeclAccess().getSourceSTRING_OR_QIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1248);
            lv_source_1_0=ruleSTRING_OR_QID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEAnnotationDeclRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_1_0, 
                    		"STRING_OR_QID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:645:2: (otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:645:4: otherlv_2= '(' ( (lv_details_3_0= ruleMapEntry ) ) (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleEAnnotationDecl1261); 

                        	newLeafNode(otherlv_2, grammarAccess.getEAnnotationDeclAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:649:1: ( (lv_details_3_0= ruleMapEntry ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:650:1: (lv_details_3_0= ruleMapEntry )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:650:1: (lv_details_3_0= ruleMapEntry )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:651:3: lv_details_3_0= ruleMapEntry
                    {
                     
                    	        newCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1282);
                    lv_details_3_0=ruleMapEntry();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEAnnotationDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"details",
                            		lv_details_3_0, 
                            		"MapEntry");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:667:2: (otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:667:4: otherlv_4= ',' ( (lv_details_5_0= ruleMapEntry ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleEAnnotationDecl1295); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getEAnnotationDeclAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:671:1: ( (lv_details_5_0= ruleMapEntry ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:672:1: (lv_details_5_0= ruleMapEntry )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:672:1: (lv_details_5_0= ruleMapEntry )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:673:3: lv_details_5_0= ruleMapEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEAnnotationDeclAccess().getDetailsMapEntryParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1316);
                    	    lv_details_5_0=ruleMapEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEAnnotationDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"details",
                    	            		lv_details_5_0, 
                    	            		"MapEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleEAnnotationDecl1330); 

                        	newLeafNode(otherlv_6, grammarAccess.getEAnnotationDeclAccess().getRightParenthesisKeyword_2_3());
                        

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
    // $ANTLR end "ruleEAnnotationDecl"


    // $ANTLR start "entryRuleEClassDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:701:1: entryRuleEClassDecl returns [EObject current=null] : iv_ruleEClassDecl= ruleEClassDecl EOF ;
    public final EObject entryRuleEClassDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:702:2: (iv_ruleEClassDecl= ruleEClassDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:703:2: iv_ruleEClassDecl= ruleEClassDecl EOF
            {
             newCompositeNode(grammarAccess.getEClassDeclRule()); 
            pushFollow(FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1368);
            iv_ruleEClassDecl=ruleEClassDecl();

            state._fsp--;

             current =iv_ruleEClassDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEClassDecl1378); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClassDecl"


    // $ANTLR start "ruleEClassDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:710:1: ruleEClassDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )? (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? otherlv_16= '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* otherlv_19= '}' ) ;
    public final EObject ruleEClassDecl() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token lv_interface_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eTypeParameters_6_0 = null;

        EObject lv_eTypeParameters_8_0 = null;

        EObject lv_eGenericSuperTypes_11_0 = null;

        EObject lv_eGenericSuperTypes_13_0 = null;

        AntlrDatatypeRuleToken lv_instanceClassName_15_0 = null;

        EObject lv_eStructuralFeatures_17_0 = null;

        EObject lv_eOperations_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:713:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )? (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? otherlv_16= '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* otherlv_19= '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:714:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )? (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? otherlv_16= '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* otherlv_19= '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:714:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )? (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? otherlv_16= '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* otherlv_19= '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:714:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_abstract_1_0= 'abstract' ) )? ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )? (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )? (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )? otherlv_16= '{' ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )* otherlv_19= '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:714:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:715:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:715:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:716:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1424);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:732:3: ( (lv_abstract_1_0= 'abstract' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:733:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:733:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:734:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,30,FOLLOW_30_in_ruleEClassDecl1443); 

                            newLeafNode(lv_abstract_1_0, grammarAccess.getEClassDeclAccess().getAbstractAbstractKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEClassDeclRule());
                    	        }
                           		setWithLastConsumed(current, "abstract", true, "abstract");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:747:3: ( ( (lv_interface_2_0= 'interface' ) ) | otherlv_3= 'class' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:747:4: ( (lv_interface_2_0= 'interface' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:747:4: ( (lv_interface_2_0= 'interface' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:748:1: (lv_interface_2_0= 'interface' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:748:1: (lv_interface_2_0= 'interface' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:749:3: lv_interface_2_0= 'interface'
                    {
                    lv_interface_2_0=(Token)match(input,31,FOLLOW_31_in_ruleEClassDecl1476); 

                            newLeafNode(lv_interface_2_0, grammarAccess.getEClassDeclAccess().getInterfaceInterfaceKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEClassDeclRule());
                    	        }
                           		setWithLastConsumed(current, "interface", true, "interface");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:763:7: otherlv_3= 'class'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleEClassDecl1507); 

                        	newLeafNode(otherlv_3, grammarAccess.getEClassDeclAccess().getClassKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:767:2: ( (lv_name_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:768:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:768:1: (lv_name_4_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:769:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEClassDecl1525); 

            			newLeafNode(lv_name_4_0, grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEClassDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:785:2: (otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:785:4: otherlv_5= '<' ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) ) (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )* otherlv_9= '>'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleEClassDecl1543); 

                        	newLeafNode(otherlv_5, grammarAccess.getEClassDeclAccess().getLessThanSignKeyword_4_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:789:1: ( (lv_eTypeParameters_6_0= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:790:1: (lv_eTypeParameters_6_0= ruleETypeParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:790:1: (lv_eTypeParameters_6_0= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:791:3: lv_eTypeParameters_6_0= ruleETypeParameterDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1564);
                    lv_eTypeParameters_6_0=ruleETypeParameterDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_6_0, 
                            		"ETypeParameterDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:2: (otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==28) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:807:4: otherlv_7= ',' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    	    {
                    	    otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleEClassDecl1577); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getEClassDeclAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:811:1: ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:812:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:812:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:813:3: lv_eTypeParameters_8_0= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1598);
                    	    lv_eTypeParameters_8_0=ruleETypeParameterDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_8_0, 
                    	            		"ETypeParameterDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleEClassDecl1612); 

                        	newLeafNode(otherlv_9, grammarAccess.getEClassDeclAccess().getGreaterThanSignKeyword_4_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:833:3: (otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:833:5: otherlv_10= 'extends' ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )*
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_35_in_ruleEClassDecl1627); 

                        	newLeafNode(otherlv_10, grammarAccess.getEClassDeclAccess().getExtendsKeyword_5_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:837:1: ( (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:1: (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:838:1: (lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:839:3: lv_eGenericSuperTypes_11_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1648);
                    lv_eGenericSuperTypes_11_0=ruleEGenericTypeReferenceDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eGenericSuperTypes",
                            		lv_eGenericSuperTypes_11_0, 
                            		"EGenericTypeReferenceDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:855:2: (otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==28) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:855:4: otherlv_12= ',' ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) )
                    	    {
                    	    otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleEClassDecl1661); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEClassDeclAccess().getCommaKeyword_5_2_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:859:1: ( (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:860:1: (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:860:1: (lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:861:3: lv_eGenericSuperTypes_13_0= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getEGenericSuperTypesEGenericTypeReferenceDeclParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1682);
                    	    lv_eGenericSuperTypes_13_0=ruleEGenericTypeReferenceDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eGenericSuperTypes",
                    	            		lv_eGenericSuperTypes_13_0, 
                    	            		"EGenericTypeReferenceDecl");
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

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:877:6: (otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:877:8: otherlv_14= ':' ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) )
                    {
                    otherlv_14=(Token)match(input,25,FOLLOW_25_in_ruleEClassDecl1699); 

                        	newLeafNode(otherlv_14, grammarAccess.getEClassDeclAccess().getColonKeyword_6_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:881:1: ( (lv_instanceClassName_15_0= ruleSTRING_OR_QID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:882:1: (lv_instanceClassName_15_0= ruleSTRING_OR_QID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:882:1: (lv_instanceClassName_15_0= ruleSTRING_OR_QID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:883:3: lv_instanceClassName_15_0= ruleSTRING_OR_QID
                    {
                     
                    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getInstanceClassNameSTRING_OR_QIDParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl1720);
                    lv_instanceClassName_15_0=ruleSTRING_OR_QID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
                    	        }
                           		set(
                           			current, 
                           			"instanceClassName",
                            		lv_instanceClassName_15_0, 
                            		"STRING_OR_QID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,22,FOLLOW_22_in_ruleEClassDecl1734); 

                	newLeafNode(otherlv_16, grammarAccess.getEClassDeclAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:903:1: ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )*
            loop21:
            do {
                int alt21=3;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:903:2: ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:903:2: ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:904:1: (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:904:1: (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:905:3: lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getEStructuralFeaturesEStructuralFeatureDeclParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl1756);
            	    lv_eStructuralFeatures_17_0=ruleEStructuralFeatureDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eStructuralFeatures",
            	            		lv_eStructuralFeatures_17_0, 
            	            		"EStructuralFeatureDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:922:6: ( (lv_eOperations_18_0= ruleEOperationDecl ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:922:6: ( (lv_eOperations_18_0= ruleEOperationDecl ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:923:1: (lv_eOperations_18_0= ruleEOperationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:923:1: (lv_eOperations_18_0= ruleEOperationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:924:3: lv_eOperations_18_0= ruleEOperationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEClassDeclAccess().getEOperationsEOperationDeclParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEOperationDecl_in_ruleEClassDecl1783);
            	    lv_eOperations_18_0=ruleEOperationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEClassDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eOperations",
            	            		lv_eOperations_18_0, 
            	            		"EOperationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_19=(Token)match(input,23,FOLLOW_23_in_ruleEClassDecl1797); 

                	newLeafNode(otherlv_19, grammarAccess.getEClassDeclAccess().getRightCurlyBracketKeyword_9());
                

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
    // $ANTLR end "ruleEClassDecl"


    // $ANTLR start "entryRuleEStructuralFeatureDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:952:1: entryRuleEStructuralFeatureDecl returns [EObject current=null] : iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF ;
    public final EObject entryRuleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStructuralFeatureDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:953:2: (iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:954:2: iv_ruleEStructuralFeatureDecl= ruleEStructuralFeatureDecl EOF
            {
             newCompositeNode(grammarAccess.getEStructuralFeatureDeclRule()); 
            pushFollow(FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl1833);
            iv_ruleEStructuralFeatureDecl=ruleEStructuralFeatureDecl();

            state._fsp--;

             current =iv_ruleEStructuralFeatureDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl1843); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEStructuralFeatureDecl"


    // $ANTLR start "ruleEStructuralFeatureDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:961:1: ruleEStructuralFeatureDecl returns [EObject current=null] : (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) ;
    public final EObject ruleEStructuralFeatureDecl() throws RecognitionException {
        EObject current = null;

        EObject this_EAttributeDecl_0 = null;

        EObject this_EReferenceDecl_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:964:28: ( (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:965:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:965:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:966:5: this_EAttributeDecl_0= ruleEAttributeDecl
                    {
                     
                            newCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEAttributeDeclParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl1890);
                    this_EAttributeDecl_0=ruleEAttributeDecl();

                    state._fsp--;

                     
                            current = this_EAttributeDecl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:976:5: this_EReferenceDecl_1= ruleEReferenceDecl
                    {
                     
                            newCompositeNode(grammarAccess.getEStructuralFeatureDeclAccess().getEReferenceDeclParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl1917);
                    this_EReferenceDecl_1=ruleEReferenceDecl();

                    state._fsp--;

                     
                            current = this_EReferenceDecl_1; 
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
    // $ANTLR end "ruleEStructuralFeatureDecl"


    // $ANTLR start "entryRuleEAttributeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:992:1: entryRuleEAttributeDecl returns [EObject current=null] : iv_ruleEAttributeDecl= ruleEAttributeDecl EOF ;
    public final EObject entryRuleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttributeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:993:2: (iv_ruleEAttributeDecl= ruleEAttributeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:994:2: iv_ruleEAttributeDecl= ruleEAttributeDecl EOF
            {
             newCompositeNode(grammarAccess.getEAttributeDeclRule()); 
            pushFollow(FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl1952);
            iv_ruleEAttributeDecl=ruleEAttributeDecl();

            state._fsp--;

             current =iv_ruleEAttributeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAttributeDecl1962); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEAttributeDecl"


    // $ANTLR start "ruleEAttributeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1001:1: ruleEAttributeDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* otherlv_9= 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )? ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? otherlv_19= ';' ) ;
    public final EObject ruleEAttributeDecl() throws RecognitionException {
        EObject current = null;

        Token lv_iD_1_0=null;
        Token lv_unique_2_0=null;
        Token lv_ordered_3_0=null;
        Token lv_changeable_4_0=null;
        Token lv_volatile_5_0=null;
        Token lv_transient_6_0=null;
        Token lv_unsettable_7_0=null;
        Token lv_derived_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_lowerBound_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_name_16_0=null;
        Token otherlv_17=null;
        Token lv_defaultValueLiteral_18_0=null;
        Token otherlv_19=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_10_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1004:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* otherlv_9= 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )? ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? otherlv_19= ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1005:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* otherlv_9= 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )? ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? otherlv_19= ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1005:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* otherlv_9= 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )? ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? otherlv_19= ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1005:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* otherlv_9= 'attr' ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )? ( (lv_name_16_0= RULE_ID ) ) (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )? otherlv_19= ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1005:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1006:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1006:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1007:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEAttributeDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2008);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1023:3: ( ( (lv_iD_1_0= 'ID' ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )*
            loop24:
            do {
                int alt24=9;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt24=1;
                    }
                    break;
                case RULE_BAG:
                    {
                    alt24=2;
                    }
                    break;
                case RULE_RANDOM:
                    {
                    alt24=3;
                    }
                    break;
                case RULE_READONLY:
                    {
                    alt24=4;
                    }
                    break;
                case 37:
                    {
                    alt24=5;
                    }
                    break;
                case 38:
                    {
                    alt24=6;
                    }
                    break;
                case 39:
                    {
                    alt24=7;
                    }
                    break;
                case 40:
                    {
                    alt24=8;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1023:4: ( (lv_iD_1_0= 'ID' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1023:4: ( (lv_iD_1_0= 'ID' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1024:1: (lv_iD_1_0= 'ID' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1024:1: (lv_iD_1_0= 'ID' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1025:3: lv_iD_1_0= 'ID'
            	    {
            	    lv_iD_1_0=(Token)match(input,36,FOLLOW_36_in_ruleEAttributeDecl2028); 

            	            newLeafNode(lv_iD_1_0, grammarAccess.getEAttributeDeclAccess().getIDIDKeyword_1_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "iD", true, "ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1039:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1039:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1040:1: (lv_unique_2_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1040:1: (lv_unique_2_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1041:3: lv_unique_2_0= RULE_BAG
            	    {
            	    lv_unique_2_0=(Token)match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEAttributeDecl2064); 

            	    			newLeafNode(lv_unique_2_0, grammarAccess.getEAttributeDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"unique",
            	            		lv_unique_2_0, 
            	            		"Bag");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1058:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1058:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1059:1: (lv_ordered_3_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1059:1: (lv_ordered_3_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1060:3: lv_ordered_3_0= RULE_RANDOM
            	    {
            	    lv_ordered_3_0=(Token)match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2092); 

            	    			newLeafNode(lv_ordered_3_0, grammarAccess.getEAttributeDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"ordered",
            	            		lv_ordered_3_0, 
            	            		"Random");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1077:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1078:1: (lv_changeable_4_0= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1078:1: (lv_changeable_4_0= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1079:3: lv_changeable_4_0= RULE_READONLY
            	    {
            	    lv_changeable_4_0=(Token)match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2120); 

            	    			newLeafNode(lv_changeable_4_0, grammarAccess.getEAttributeDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"changeable",
            	            		lv_changeable_4_0, 
            	            		"Readonly");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1096:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1096:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1097:1: (lv_volatile_5_0= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1097:1: (lv_volatile_5_0= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1098:3: lv_volatile_5_0= 'volatile'
            	    {
            	    lv_volatile_5_0=(Token)match(input,37,FOLLOW_37_in_ruleEAttributeDecl2149); 

            	            newLeafNode(lv_volatile_5_0, grammarAccess.getEAttributeDeclAccess().getVolatileVolatileKeyword_1_4_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "volatile", true, "volatile");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1112:6: ( (lv_transient_6_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1112:6: ( (lv_transient_6_0= 'transient' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1113:1: (lv_transient_6_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1113:1: (lv_transient_6_0= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1114:3: lv_transient_6_0= 'transient'
            	    {
            	    lv_transient_6_0=(Token)match(input,38,FOLLOW_38_in_ruleEAttributeDecl2186); 

            	            newLeafNode(lv_transient_6_0, grammarAccess.getEAttributeDeclAccess().getTransientTransientKeyword_1_5_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "transient", true, "transient");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1128:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1128:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1129:1: (lv_unsettable_7_0= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1129:1: (lv_unsettable_7_0= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1130:3: lv_unsettable_7_0= 'unsettable'
            	    {
            	    lv_unsettable_7_0=(Token)match(input,39,FOLLOW_39_in_ruleEAttributeDecl2223); 

            	            newLeafNode(lv_unsettable_7_0, grammarAccess.getEAttributeDeclAccess().getUnsettableUnsettableKeyword_1_6_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "unsettable", true, "unsettable");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1144:6: ( (lv_derived_8_0= 'derived' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1144:6: ( (lv_derived_8_0= 'derived' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1145:1: (lv_derived_8_0= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1145:1: (lv_derived_8_0= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1146:3: lv_derived_8_0= 'derived'
            	    {
            	    lv_derived_8_0=(Token)match(input,40,FOLLOW_40_in_ruleEAttributeDecl2260); 

            	            newLeafNode(lv_derived_8_0, grammarAccess.getEAttributeDeclAccess().getDerivedDerivedKeyword_1_7_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "derived", true, "derived");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_9=(Token)match(input,41,FOLLOW_41_in_ruleEAttributeDecl2287); 

                	newLeafNode(otherlv_9, grammarAccess.getEAttributeDeclAccess().getAttrKeyword_2());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1163:1: ( (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1164:1: (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1164:1: (lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1165:3: lv_eGenericType_10_0= ruleEGenericTypeReferenceDecl
            {
             
            	        newCompositeNode(grammarAccess.getEAttributeDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2308);
            lv_eGenericType_10_0=ruleEGenericTypeReferenceDecl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEAttributeDeclRule());
            	        }
                   		set(
                   			current, 
                   			"eGenericType",
                    		lv_eGenericType_10_0, 
                    		"EGenericTypeReferenceDecl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1181:2: (otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1181:4: otherlv_11= '[' ( (lv_lowerBound_12_0= RULE_INT ) ) (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )? otherlv_15= ']'
                    {
                    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleEAttributeDecl2321); 

                        	newLeafNode(otherlv_11, grammarAccess.getEAttributeDeclAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1185:1: ( (lv_lowerBound_12_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1186:1: (lv_lowerBound_12_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1186:1: (lv_lowerBound_12_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1187:3: lv_lowerBound_12_0= RULE_INT
                    {
                    lv_lowerBound_12_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEAttributeDecl2338); 

                    			newLeafNode(lv_lowerBound_12_0, grammarAccess.getEAttributeDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_12_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1203:2: (otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==43) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1203:4: otherlv_13= '..' ( (lv_upperBound_14_0= ruleSINT ) )
                            {
                            otherlv_13=(Token)match(input,43,FOLLOW_43_in_ruleEAttributeDecl2356); 

                                	newLeafNode(otherlv_13, grammarAccess.getEAttributeDeclAccess().getFullStopFullStopKeyword_4_2_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1207:1: ( (lv_upperBound_14_0= ruleSINT ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1208:1: (lv_upperBound_14_0= ruleSINT )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1208:1: (lv_upperBound_14_0= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1209:3: lv_upperBound_14_0= ruleSINT
                            {
                             
                            	        newCompositeNode(grammarAccess.getEAttributeDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEAttributeDecl2377);
                            lv_upperBound_14_0=ruleSINT();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEAttributeDeclRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"upperBound",
                                    		lv_upperBound_14_0, 
                                    		"SINT");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_15=(Token)match(input,44,FOLLOW_44_in_ruleEAttributeDecl2391); 

                        	newLeafNode(otherlv_15, grammarAccess.getEAttributeDeclAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1229:3: ( (lv_name_16_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1230:1: (lv_name_16_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1230:1: (lv_name_16_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1231:3: lv_name_16_0= RULE_ID
            {
            lv_name_16_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEAttributeDecl2410); 

            			newLeafNode(lv_name_16_0, grammarAccess.getEAttributeDeclAccess().getNameIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_16_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1247:2: (otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1247:4: otherlv_17= '=' ( (lv_defaultValueLiteral_18_0= RULE_STRING ) )
                    {
                    otherlv_17=(Token)match(input,17,FOLLOW_17_in_ruleEAttributeDecl2428); 

                        	newLeafNode(otherlv_17, grammarAccess.getEAttributeDeclAccess().getEqualsSignKeyword_6_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1251:1: ( (lv_defaultValueLiteral_18_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1252:1: (lv_defaultValueLiteral_18_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1252:1: (lv_defaultValueLiteral_18_0= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1253:3: lv_defaultValueLiteral_18_0= RULE_STRING
                    {
                    lv_defaultValueLiteral_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEAttributeDecl2445); 

                    			newLeafNode(lv_defaultValueLiteral_18_0, grammarAccess.getEAttributeDeclAccess().getDefaultValueLiteralSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEAttributeDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"defaultValueLiteral",
                            		lv_defaultValueLiteral_18_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,18,FOLLOW_18_in_ruleEAttributeDecl2464); 

                	newLeafNode(otherlv_19, grammarAccess.getEAttributeDeclAccess().getSemicolonKeyword_7());
                

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
    // $ANTLR end "ruleEAttributeDecl"


    // $ANTLR start "entryRuleEReferenceDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1281:1: entryRuleEReferenceDecl returns [EObject current=null] : iv_ruleEReferenceDecl= ruleEReferenceDecl EOF ;
    public final EObject entryRuleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1282:2: (iv_ruleEReferenceDecl= ruleEReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1283:2: iv_ruleEReferenceDecl= ruleEReferenceDecl EOF
            {
             newCompositeNode(grammarAccess.getEReferenceDeclRule()); 
            pushFollow(FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2500);
            iv_ruleEReferenceDecl=ruleEReferenceDecl();

            state._fsp--;

             current =iv_ruleEReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEReferenceDecl2510); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEReferenceDecl"


    // $ANTLR start "ruleEReferenceDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1290:1: ruleEReferenceDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )? (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) otherlv_20= ';' ) ;
    public final EObject ruleEReferenceDecl() throws RecognitionException {
        EObject current = null;

        Token lv_resolveProxies_1_0=null;
        Token lv_unique_2_0=null;
        Token lv_ordered_3_0=null;
        Token lv_changeable_4_0=null;
        Token lv_volatile_5_0=null;
        Token lv_transient_6_0=null;
        Token lv_unsettable_7_0=null;
        Token lv_derived_8_0=null;
        Token lv_containment_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_lowerBound_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_name_19_0=null;
        Token otherlv_20=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_11_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1293:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )? (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) otherlv_20= ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )? (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) otherlv_20= ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )? (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) otherlv_20= ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )* ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' ) ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )? (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )? ( (lv_name_19_0= RULE_ID ) ) otherlv_20= ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1294:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==26) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1295:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1295:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1296:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEReferenceDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2556);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1312:3: ( ( (lv_resolveProxies_1_0= RULE_LOCAL ) ) | ( (lv_unique_2_0= RULE_BAG ) ) | ( (lv_ordered_3_0= RULE_RANDOM ) ) | ( (lv_changeable_4_0= RULE_READONLY ) ) | ( (lv_volatile_5_0= 'volatile' ) ) | ( (lv_transient_6_0= 'transient' ) ) | ( (lv_unsettable_7_0= 'unsettable' ) ) | ( (lv_derived_8_0= 'derived' ) ) )*
            loop29:
            do {
                int alt29=9;
                switch ( input.LA(1) ) {
                case RULE_LOCAL:
                    {
                    alt29=1;
                    }
                    break;
                case RULE_BAG:
                    {
                    alt29=2;
                    }
                    break;
                case RULE_RANDOM:
                    {
                    alt29=3;
                    }
                    break;
                case RULE_READONLY:
                    {
                    alt29=4;
                    }
                    break;
                case 37:
                    {
                    alt29=5;
                    }
                    break;
                case 38:
                    {
                    alt29=6;
                    }
                    break;
                case 39:
                    {
                    alt29=7;
                    }
                    break;
                case 40:
                    {
                    alt29=8;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1312:4: ( (lv_resolveProxies_1_0= RULE_LOCAL ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1312:4: ( (lv_resolveProxies_1_0= RULE_LOCAL ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1313:1: (lv_resolveProxies_1_0= RULE_LOCAL )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1313:1: (lv_resolveProxies_1_0= RULE_LOCAL )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1314:3: lv_resolveProxies_1_0= RULE_LOCAL
            	    {
            	    lv_resolveProxies_1_0=(Token)match(input,RULE_LOCAL,FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl2575); 

            	    			newLeafNode(lv_resolveProxies_1_0, grammarAccess.getEReferenceDeclAccess().getResolveProxiesLocalTerminalRuleCall_1_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"resolveProxies",
            	            		lv_resolveProxies_1_0, 
            	            		"Local");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1331:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1331:6: ( (lv_unique_2_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1332:1: (lv_unique_2_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1332:1: (lv_unique_2_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1333:3: lv_unique_2_0= RULE_BAG
            	    {
            	    lv_unique_2_0=(Token)match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEReferenceDecl2603); 

            	    			newLeafNode(lv_unique_2_0, grammarAccess.getEReferenceDeclAccess().getUniqueBagTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"unique",
            	            		lv_unique_2_0, 
            	            		"Bag");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1350:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1350:6: ( (lv_ordered_3_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1351:1: (lv_ordered_3_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1351:1: (lv_ordered_3_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1352:3: lv_ordered_3_0= RULE_RANDOM
            	    {
            	    lv_ordered_3_0=(Token)match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl2631); 

            	    			newLeafNode(lv_ordered_3_0, grammarAccess.getEReferenceDeclAccess().getOrderedRandomTerminalRuleCall_1_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"ordered",
            	            		lv_ordered_3_0, 
            	            		"Random");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1369:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1369:6: ( (lv_changeable_4_0= RULE_READONLY ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1370:1: (lv_changeable_4_0= RULE_READONLY )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1370:1: (lv_changeable_4_0= RULE_READONLY )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1371:3: lv_changeable_4_0= RULE_READONLY
            	    {
            	    lv_changeable_4_0=(Token)match(input,RULE_READONLY,FOLLOW_RULE_READONLY_in_ruleEReferenceDecl2659); 

            	    			newLeafNode(lv_changeable_4_0, grammarAccess.getEReferenceDeclAccess().getChangeableReadonlyTerminalRuleCall_1_3_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"changeable",
            	            		lv_changeable_4_0, 
            	            		"Readonly");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1388:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1388:6: ( (lv_volatile_5_0= 'volatile' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1389:1: (lv_volatile_5_0= 'volatile' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1389:1: (lv_volatile_5_0= 'volatile' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1390:3: lv_volatile_5_0= 'volatile'
            	    {
            	    lv_volatile_5_0=(Token)match(input,37,FOLLOW_37_in_ruleEReferenceDecl2688); 

            	            newLeafNode(lv_volatile_5_0, grammarAccess.getEReferenceDeclAccess().getVolatileVolatileKeyword_1_4_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "volatile", true, "volatile");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1404:6: ( (lv_transient_6_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1404:6: ( (lv_transient_6_0= 'transient' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1405:1: (lv_transient_6_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1405:1: (lv_transient_6_0= 'transient' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1406:3: lv_transient_6_0= 'transient'
            	    {
            	    lv_transient_6_0=(Token)match(input,38,FOLLOW_38_in_ruleEReferenceDecl2725); 

            	            newLeafNode(lv_transient_6_0, grammarAccess.getEReferenceDeclAccess().getTransientTransientKeyword_1_5_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "transient", true, "transient");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1420:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1420:6: ( (lv_unsettable_7_0= 'unsettable' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1421:1: (lv_unsettable_7_0= 'unsettable' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1421:1: (lv_unsettable_7_0= 'unsettable' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1422:3: lv_unsettable_7_0= 'unsettable'
            	    {
            	    lv_unsettable_7_0=(Token)match(input,39,FOLLOW_39_in_ruleEReferenceDecl2762); 

            	            newLeafNode(lv_unsettable_7_0, grammarAccess.getEReferenceDeclAccess().getUnsettableUnsettableKeyword_1_6_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "unsettable", true, "unsettable");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1436:6: ( (lv_derived_8_0= 'derived' ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1436:6: ( (lv_derived_8_0= 'derived' ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1437:1: (lv_derived_8_0= 'derived' )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1437:1: (lv_derived_8_0= 'derived' )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1438:3: lv_derived_8_0= 'derived'
            	    {
            	    lv_derived_8_0=(Token)match(input,40,FOLLOW_40_in_ruleEReferenceDecl2799); 

            	            newLeafNode(lv_derived_8_0, grammarAccess.getEReferenceDeclAccess().getDerivedDerivedKeyword_1_7_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	    	        }
            	           		setWithLastConsumed(current, "derived", true, "derived");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1451:4: ( ( (lv_containment_9_0= 'val' ) ) | otherlv_10= 'ref' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            else if ( (LA30_0==46) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1451:5: ( (lv_containment_9_0= 'val' ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1451:5: ( (lv_containment_9_0= 'val' ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1452:1: (lv_containment_9_0= 'val' )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1452:1: (lv_containment_9_0= 'val' )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1453:3: lv_containment_9_0= 'val'
                    {
                    lv_containment_9_0=(Token)match(input,45,FOLLOW_45_in_ruleEReferenceDecl2833); 

                            newLeafNode(lv_containment_9_0, grammarAccess.getEReferenceDeclAccess().getContainmentValKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
                    	        }
                           		setWithLastConsumed(current, "containment", true, "val");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1467:7: otherlv_10= 'ref'
                    {
                    otherlv_10=(Token)match(input,46,FOLLOW_46_in_ruleEReferenceDecl2864); 

                        	newLeafNode(otherlv_10, grammarAccess.getEReferenceDeclAccess().getRefKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1471:2: ( (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1472:1: (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1472:1: (lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1473:3: lv_eGenericType_11_0= ruleEGenericTypeReferenceDecl
            {
             
            	        newCompositeNode(grammarAccess.getEReferenceDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl2886);
            lv_eGenericType_11_0=ruleEGenericTypeReferenceDecl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEReferenceDeclRule());
            	        }
                   		set(
                   			current, 
                   			"eGenericType",
                    		lv_eGenericType_11_0, 
                    		"EGenericTypeReferenceDecl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1489:2: (otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1489:4: otherlv_12= '[' ( (lv_lowerBound_13_0= RULE_INT ) ) (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )? otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,42,FOLLOW_42_in_ruleEReferenceDecl2899); 

                        	newLeafNode(otherlv_12, grammarAccess.getEReferenceDeclAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1493:1: ( (lv_lowerBound_13_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1494:1: (lv_lowerBound_13_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1494:1: (lv_lowerBound_13_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1495:3: lv_lowerBound_13_0= RULE_INT
                    {
                    lv_lowerBound_13_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEReferenceDecl2916); 

                    			newLeafNode(lv_lowerBound_13_0, grammarAccess.getEReferenceDeclAccess().getLowerBoundINTTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lowerBound",
                            		lv_lowerBound_13_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1511:2: (otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1511:4: otherlv_14= '..' ( (lv_upperBound_15_0= ruleSINT ) )
                            {
                            otherlv_14=(Token)match(input,43,FOLLOW_43_in_ruleEReferenceDecl2934); 

                                	newLeafNode(otherlv_14, grammarAccess.getEReferenceDeclAccess().getFullStopFullStopKeyword_4_2_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1515:1: ( (lv_upperBound_15_0= ruleSINT ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1516:1: (lv_upperBound_15_0= ruleSINT )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1516:1: (lv_upperBound_15_0= ruleSINT )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1517:3: lv_upperBound_15_0= ruleSINT
                            {
                             
                            	        newCompositeNode(grammarAccess.getEReferenceDeclAccess().getUpperBoundSINTParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSINT_in_ruleEReferenceDecl2955);
                            lv_upperBound_15_0=ruleSINT();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEReferenceDeclRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"upperBound",
                                    		lv_upperBound_15_0, 
                                    		"SINT");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,44,FOLLOW_44_in_ruleEReferenceDecl2969); 

                        	newLeafNode(otherlv_16, grammarAccess.getEReferenceDeclAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1537:3: (otherlv_17= '#' ( (otherlv_18= RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1537:5: otherlv_17= '#' ( (otherlv_18= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,47,FOLLOW_47_in_ruleEReferenceDecl2984); 

                        	newLeafNode(otherlv_17, grammarAccess.getEReferenceDeclAccess().getNumberSignKeyword_5_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1541:1: ( (otherlv_18= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1542:1: (otherlv_18= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1542:1: (otherlv_18= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1543:3: otherlv_18= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
                    	        }
                            
                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3004); 

                    		newLeafNode(otherlv_18, grammarAccess.getEReferenceDeclAccess().getEOppositeEReferenceCrossReference_5_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1554:4: ( (lv_name_19_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1555:1: (lv_name_19_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1555:1: (lv_name_19_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1556:3: lv_name_19_0= RULE_ID
            {
            lv_name_19_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEReferenceDecl3023); 

            			newLeafNode(lv_name_19_0, grammarAccess.getEReferenceDeclAccess().getNameIDTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEReferenceDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_19_0, 
                    		"ID");
            	    

            }


            }

            otherlv_20=(Token)match(input,18,FOLLOW_18_in_ruleEReferenceDecl3040); 

                	newLeafNode(otherlv_20, grammarAccess.getEReferenceDeclAccess().getSemicolonKeyword_7());
                

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
    // $ANTLR end "ruleEReferenceDecl"


    // $ANTLR start "entryRuleEEnumDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1584:1: entryRuleEEnumDecl returns [EObject current=null] : iv_ruleEEnumDecl= ruleEEnumDecl EOF ;
    public final EObject entryRuleEEnumDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1585:2: (iv_ruleEEnumDecl= ruleEEnumDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1586:2: iv_ruleEEnumDecl= ruleEEnumDecl EOF
            {
             newCompositeNode(grammarAccess.getEEnumDeclRule()); 
            pushFollow(FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3076);
            iv_ruleEEnumDecl=ruleEEnumDecl();

            state._fsp--;

             current =iv_ruleEEnumDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumDecl3086); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEEnumDecl"


    // $ANTLR start "ruleEEnumDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1593:1: ruleEEnumDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ otherlv_5= '}' ) ;
    public final EObject ruleEEnumDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eLiterals_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1596:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ otherlv_5= '}' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1597:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1597:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ otherlv_5= '}' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1597:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* otherlv_1= 'enum' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+ otherlv_5= '}'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1597:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1598:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1598:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1599:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEEnumDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3132);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEEnumDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleEEnumDecl3145); 

                	newLeafNode(otherlv_1, grammarAccess.getEEnumDeclAccess().getEnumKeyword_1());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1619:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1620:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1620:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1621:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumDecl3162); 

            			newLeafNode(lv_name_2_0, grammarAccess.getEEnumDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEEnumDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleEEnumDecl3179); 

                	newLeafNode(otherlv_3, grammarAccess.getEEnumDeclAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1641:1: ( (lv_eLiterals_4_0= ruleEEnumLiteralDecl ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID||LA35_0==26) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1642:1: (lv_eLiterals_4_0= ruleEEnumLiteralDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1642:1: (lv_eLiterals_4_0= ruleEEnumLiteralDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1643:3: lv_eLiterals_4_0= ruleEEnumLiteralDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEEnumDeclAccess().getELiteralsEEnumLiteralDeclParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3200);
            	    lv_eLiterals_4_0=ruleEEnumLiteralDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEEnumDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eLiterals",
            	            		lv_eLiterals_4_0, 
            	            		"EEnumLiteralDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleEEnumDecl3213); 

                	newLeafNode(otherlv_5, grammarAccess.getEEnumDeclAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleEEnumDecl"


    // $ANTLR start "entryRuleEEnumLiteralDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1671:1: entryRuleEEnumLiteralDecl returns [EObject current=null] : iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF ;
    public final EObject entryRuleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEEnumLiteralDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1672:2: (iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1673:2: iv_ruleEEnumLiteralDecl= ruleEEnumLiteralDecl EOF
            {
             newCompositeNode(grammarAccess.getEEnumLiteralDeclRule()); 
            pushFollow(FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3249);
            iv_ruleEEnumLiteralDecl=ruleEEnumLiteralDecl();

            state._fsp--;

             current =iv_ruleEEnumLiteralDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3259); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEEnumLiteralDecl"


    // $ANTLR start "ruleEEnumLiteralDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1680:1: ruleEEnumLiteralDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? otherlv_5= ';' ) ;
    public final EObject ruleEEnumLiteralDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token lv_literal_4_0=null;
        Token otherlv_5=null;
        EObject lv_eAnnotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1683:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? otherlv_5= ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1684:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? otherlv_5= ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1684:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? otherlv_5= ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1684:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )? ( (lv_literal_4_0= RULE_STRING ) )? otherlv_5= ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1684:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1685:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1685:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1686:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEEnumLiteralDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3305);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEEnumLiteralDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1702:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1703:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1703:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1704:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3323); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEEnumLiteralDeclAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEEnumLiteralDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1720:2: (otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==17) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1720:4: otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleEEnumLiteralDecl3341); 

                        	newLeafNode(otherlv_2, grammarAccess.getEEnumLiteralDeclAccess().getEqualsSignKeyword_2_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1724:1: ( (lv_value_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1725:1: (lv_value_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1725:1: (lv_value_3_0= RULE_INT )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1726:3: lv_value_3_0= RULE_INT
                    {
                    lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3358); 

                    			newLeafNode(lv_value_3_0, grammarAccess.getEEnumLiteralDeclAccess().getValueINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEEnumLiteralDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1742:4: ( (lv_literal_4_0= RULE_STRING ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1743:1: (lv_literal_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1743:1: (lv_literal_4_0= RULE_STRING )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1744:3: lv_literal_4_0= RULE_STRING
                    {
                    lv_literal_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3382); 

                    			newLeafNode(lv_literal_4_0, grammarAccess.getEEnumLiteralDeclAccess().getLiteralSTRINGTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEEnumLiteralDeclRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"literal",
                            		lv_literal_4_0, 
                            		"STRING");
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleEEnumLiteralDecl3400); 

                	newLeafNode(otherlv_5, grammarAccess.getEEnumLiteralDeclAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleEEnumLiteralDecl"


    // $ANTLR start "entryRuleETypeParameterDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1772:1: entryRuleETypeParameterDecl returns [EObject current=null] : iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF ;
    public final EObject entryRuleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleETypeParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1773:2: (iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1774:2: iv_ruleETypeParameterDecl= ruleETypeParameterDecl EOF
            {
             newCompositeNode(grammarAccess.getETypeParameterDeclRule()); 
            pushFollow(FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl3436);
            iv_ruleETypeParameterDecl=ruleETypeParameterDecl();

            state._fsp--;

             current =iv_ruleETypeParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleETypeParameterDecl3446); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleETypeParameterDecl"


    // $ANTLR start "ruleETypeParameterDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1781:1: ruleETypeParameterDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? ) ;
    public final EObject ruleETypeParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_eBounds_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1784:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1785:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1785:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )? )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1785:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )?
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1785:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1786:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1786:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1787:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleETypeParameterDecl3488); 

            			newLeafNode(lv_name_0_0, grammarAccess.getETypeParameterDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getETypeParameterDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1803:2: (otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1803:4: otherlv_1= 'extends' ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleETypeParameterDecl3506); 

                        	newLeafNode(otherlv_1, grammarAccess.getETypeParameterDeclAccess().getExtendsKeyword_1_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1807:1: ( (lv_eBounds_2_0= ruleEGenericTypeDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1808:1: (lv_eBounds_2_0= ruleEGenericTypeDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1808:1: (lv_eBounds_2_0= ruleEGenericTypeDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1809:3: lv_eBounds_2_0= ruleEGenericTypeDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getETypeParameterDeclAccess().getEBoundsEGenericTypeDeclParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl3527);
                    lv_eBounds_2_0=ruleEGenericTypeDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getETypeParameterDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eBounds",
                            		lv_eBounds_2_0, 
                            		"EGenericTypeDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleETypeParameterDecl"


    // $ANTLR start "entryRuleEGenericTypeReferenceDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1833:1: entryRuleEGenericTypeReferenceDecl returns [EObject current=null] : iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF ;
    public final EObject entryRuleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeReferenceDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1834:2: (iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1835:2: iv_ruleEGenericTypeReferenceDecl= ruleEGenericTypeReferenceDecl EOF
            {
             newCompositeNode(grammarAccess.getEGenericTypeReferenceDeclRule()); 
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl3565);
            iv_ruleEGenericTypeReferenceDecl=ruleEGenericTypeReferenceDecl();

            state._fsp--;

             current =iv_ruleEGenericTypeReferenceDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl3575); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEGenericTypeReferenceDecl"


    // $ANTLR start "ruleEGenericTypeReferenceDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1842:1: ruleEGenericTypeReferenceDecl returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleEGenericTypeReferenceDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_eTypeArguments_2_0 = null;

        EObject lv_eTypeArguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1845:28: ( ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            else if ( (LA42_0==47) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1846:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1847:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1847:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1848:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeReferenceDeclRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3621); 

                    		newLeafNode(otherlv_0, grammarAccess.getEGenericTypeReferenceDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1859:2: (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==33) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1859:4: otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>'
                            {
                            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleEGenericTypeReferenceDecl3634); 

                                	newLeafNode(otherlv_1, grammarAccess.getEGenericTypeReferenceDeclAccess().getLessThanSignKeyword_0_1_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1863:1: ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1864:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1864:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1865:3: lv_eTypeArguments_2_0= ruleEGenericTypeDecl
                            {
                             
                            	        newCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3655);
                            lv_eTypeArguments_2_0=ruleEGenericTypeDecl();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEGenericTypeReferenceDeclRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eTypeArguments",
                                    		lv_eTypeArguments_2_0, 
                                    		"EGenericTypeDecl");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1881:2: (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==28) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1881:4: otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    {
                            	    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleEGenericTypeReferenceDecl3668); 

                            	        	newLeafNode(otherlv_3, grammarAccess.getEGenericTypeReferenceDeclAccess().getCommaKeyword_0_1_2_0());
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1885:1: ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1886:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    {
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1886:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1887:3: lv_eTypeArguments_4_0= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3689);
                            	    lv_eTypeArguments_4_0=ruleEGenericTypeDecl();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getEGenericTypeReferenceDeclRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"eTypeArguments",
                            	            		lv_eTypeArguments_4_0, 
                            	            		"EGenericTypeDecl");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop40;
                                }
                            } while (true);

                            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleEGenericTypeReferenceDecl3703); 

                                	newLeafNode(otherlv_5, grammarAccess.getEGenericTypeReferenceDeclAccess().getGreaterThanSignKeyword_0_1_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1908:6: (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1908:6: (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1908:8: otherlv_6= '#' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,47,FOLLOW_47_in_ruleEGenericTypeReferenceDecl3725); 

                        	newLeafNode(otherlv_6, grammarAccess.getEGenericTypeReferenceDeclAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1912:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1913:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1913:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1914:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeReferenceDeclRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3745); 

                    		newLeafNode(otherlv_7, grammarAccess.getEGenericTypeReferenceDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
                    	

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
    // $ANTLR end "ruleEGenericTypeReferenceDecl"


    // $ANTLR start "entryRuleEGenericTypeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1933:1: entryRuleEGenericTypeDecl returns [EObject current=null] : iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF ;
    public final EObject entryRuleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEGenericTypeDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1934:2: (iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1935:2: iv_ruleEGenericTypeDecl= ruleEGenericTypeDecl EOF
            {
             newCompositeNode(grammarAccess.getEGenericTypeDeclRule()); 
            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl3782);
            iv_ruleEGenericTypeDecl=ruleEGenericTypeDecl();

            state._fsp--;

             current =iv_ruleEGenericTypeDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEGenericTypeDecl3792); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEGenericTypeDecl"


    // $ANTLR start "ruleEGenericTypeDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1942:1: ruleEGenericTypeDecl returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) ) ;
    public final EObject ruleEGenericTypeDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_eTypeArguments_2_0 = null;

        EObject lv_eTypeArguments_4_0 = null;

        EObject lv_eUpperBound_10_0 = null;

        EObject lv_eLowerBound_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1945:28: ( ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:1: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? ) | (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) ) )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
                }
                break;
            case 47:
                {
                alt46=2;
                }
                break;
            case 49:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )? )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )?
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1946:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1947:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1947:1: (otherlv_0= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1948:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeDeclRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3838); 

                    		newLeafNode(otherlv_0, grammarAccess.getEGenericTypeDeclAccess().getEClassifierEClassifierCrossReference_0_0_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1959:2: (otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==33) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1959:4: otherlv_1= '<' ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) ) (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )* otherlv_5= '>'
                            {
                            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleEGenericTypeDecl3851); 

                                	newLeafNode(otherlv_1, grammarAccess.getEGenericTypeDeclAccess().getLessThanSignKeyword_0_1_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1963:1: ( (lv_eTypeArguments_2_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1964:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1964:1: (lv_eTypeArguments_2_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1965:3: lv_eTypeArguments_2_0= ruleEGenericTypeDecl
                            {
                             
                            	        newCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3872);
                            lv_eTypeArguments_2_0=ruleEGenericTypeDecl();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEGenericTypeDeclRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eTypeArguments",
                                    		lv_eTypeArguments_2_0, 
                                    		"EGenericTypeDecl");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1981:2: (otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==28) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1981:4: otherlv_3= ',' ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    {
                            	    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleEGenericTypeDecl3885); 

                            	        	newLeafNode(otherlv_3, grammarAccess.getEGenericTypeDeclAccess().getCommaKeyword_0_1_2_0());
                            	        
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1985:1: ( (lv_eTypeArguments_4_0= ruleEGenericTypeDecl ) )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1986:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    {
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1986:1: (lv_eTypeArguments_4_0= ruleEGenericTypeDecl )
                            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:1987:3: lv_eTypeArguments_4_0= ruleEGenericTypeDecl
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getETypeArgumentsEGenericTypeDeclParserRuleCall_0_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3906);
                            	    lv_eTypeArguments_4_0=ruleEGenericTypeDecl();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getEGenericTypeDeclRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"eTypeArguments",
                            	            		lv_eTypeArguments_4_0, 
                            	            		"EGenericTypeDecl");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);

                            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleEGenericTypeDecl3920); 

                                	newLeafNode(otherlv_5, grammarAccess.getEGenericTypeDeclAccess().getGreaterThanSignKeyword_0_1_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:6: (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:6: (otherlv_6= '#' ( (otherlv_7= RULE_ID ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2008:8: otherlv_6= '#' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,47,FOLLOW_47_in_ruleEGenericTypeDecl3942); 

                        	newLeafNode(otherlv_6, grammarAccess.getEGenericTypeDeclAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2012:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2013:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2014:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEGenericTypeDeclRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3962); 

                    		newLeafNode(otherlv_7, grammarAccess.getEGenericTypeDeclAccess().getETypeParameterETypeParameterCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:6: (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:6: (otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2026:8: otherlv_8= '?' ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) )
                    {
                    otherlv_8=(Token)match(input,49,FOLLOW_49_in_ruleEGenericTypeDecl3982); 

                        	newLeafNode(otherlv_8, grammarAccess.getEGenericTypeDeclAccess().getQuestionMarkKeyword_2_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2030:1: ( (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) ) | (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) ) )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==35) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==50) ) {
                        alt45=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2030:2: (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2030:2: (otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2030:4: otherlv_9= 'extends' ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) )
                            {
                            otherlv_9=(Token)match(input,35,FOLLOW_35_in_ruleEGenericTypeDecl3996); 

                                	newLeafNode(otherlv_9, grammarAccess.getEGenericTypeDeclAccess().getExtendsKeyword_2_1_0_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2034:1: ( (lv_eUpperBound_10_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2035:1: (lv_eUpperBound_10_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2035:1: (lv_eUpperBound_10_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2036:3: lv_eUpperBound_10_0= ruleEGenericTypeDecl
                            {
                             
                            	        newCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getEUpperBoundEGenericTypeDeclParserRuleCall_2_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4017);
                            lv_eUpperBound_10_0=ruleEGenericTypeDecl();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEGenericTypeDeclRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"eUpperBound",
                                    		lv_eUpperBound_10_0, 
                                    		"EGenericTypeDecl");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2053:6: (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2053:6: (otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2053:8: otherlv_11= 'super' ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) )
                            {
                            otherlv_11=(Token)match(input,50,FOLLOW_50_in_ruleEGenericTypeDecl4037); 

                                	newLeafNode(otherlv_11, grammarAccess.getEGenericTypeDeclAccess().getSuperKeyword_2_1_1_0());
                                
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2057:1: ( (lv_eLowerBound_12_0= ruleEGenericTypeDecl ) )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2058:1: (lv_eLowerBound_12_0= ruleEGenericTypeDecl )
                            {
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2058:1: (lv_eLowerBound_12_0= ruleEGenericTypeDecl )
                            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2059:3: lv_eLowerBound_12_0= ruleEGenericTypeDecl
                            {
                             
                            	        newCompositeNode(grammarAccess.getEGenericTypeDeclAccess().getELowerBoundEGenericTypeDeclParserRuleCall_2_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4058);
                            lv_eLowerBound_12_0=ruleEGenericTypeDecl();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getEGenericTypeDeclRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"eLowerBound",
                                    		lv_eLowerBound_12_0, 
                                    		"EGenericTypeDecl");
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
    // $ANTLR end "ruleEGenericTypeDecl"


    // $ANTLR start "entryRuleEOperationDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2083:1: entryRuleEOperationDecl returns [EObject current=null] : iv_ruleEOperationDecl= ruleEOperationDecl EOF ;
    public final EObject entryRuleEOperationDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOperationDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2084:2: (iv_ruleEOperationDecl= ruleEOperationDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2085:2: iv_ruleEOperationDecl= ruleEOperationDecl EOF
            {
             newCompositeNode(grammarAccess.getEOperationDeclRule()); 
            pushFollow(FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4097);
            iv_ruleEOperationDecl=ruleEOperationDecl();

            state._fsp--;

             current =iv_ruleEOperationDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEOperationDecl4107); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEOperationDecl"


    // $ANTLR start "ruleEOperationDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2092:1: ruleEOperationDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* otherlv_3= 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )? otherlv_12= '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? otherlv_16= ')' (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? otherlv_21= ';' ) ;
    public final EObject ruleEOperationDecl() throws RecognitionException {
        EObject current = null;

        Token lv_unique_1_0=null;
        Token lv_ordered_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_4_0 = null;

        EObject lv_eTypeParameters_8_0 = null;

        EObject lv_eTypeParameters_10_0 = null;

        EObject lv_eParameters_13_0 = null;

        EObject lv_eParameters_15_0 = null;

        EObject lv_eGenericExceptions_18_0 = null;

        EObject lv_eGenericExceptions_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2095:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* otherlv_3= 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )? otherlv_12= '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? otherlv_16= ')' (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? otherlv_21= ';' ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2096:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* otherlv_3= 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )? otherlv_12= '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? otherlv_16= ')' (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? otherlv_21= ';' )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2096:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* otherlv_3= 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )? otherlv_12= '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? otherlv_16= ')' (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? otherlv_21= ';' )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2096:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )* otherlv_3= 'op' ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )? otherlv_12= '(' ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )? otherlv_16= ')' (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )? otherlv_21= ';'
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2096:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==26) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2097:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2097:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2098:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4153);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2114:3: ( ( (lv_unique_1_0= RULE_BAG ) ) | ( (lv_ordered_2_0= RULE_RANDOM ) ) )*
            loop48:
            do {
                int alt48=3;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_BAG) ) {
                    alt48=1;
                }
                else if ( (LA48_0==RULE_RANDOM) ) {
                    alt48=2;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2114:4: ( (lv_unique_1_0= RULE_BAG ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2114:4: ( (lv_unique_1_0= RULE_BAG ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2115:1: (lv_unique_1_0= RULE_BAG )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2115:1: (lv_unique_1_0= RULE_BAG )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2116:3: lv_unique_1_0= RULE_BAG
            	    {
            	    lv_unique_1_0=(Token)match(input,RULE_BAG,FOLLOW_RULE_BAG_in_ruleEOperationDecl4172); 

            	    			newLeafNode(lv_unique_1_0, grammarAccess.getEOperationDeclAccess().getUniqueBagTerminalRuleCall_1_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEOperationDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"unique",
            	            		true, 
            	            		"Bag");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2133:6: ( (lv_ordered_2_0= RULE_RANDOM ) )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2133:6: ( (lv_ordered_2_0= RULE_RANDOM ) )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2134:1: (lv_ordered_2_0= RULE_RANDOM )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2134:1: (lv_ordered_2_0= RULE_RANDOM )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2135:3: lv_ordered_2_0= RULE_RANDOM
            	    {
            	    lv_ordered_2_0=(Token)match(input,RULE_RANDOM,FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4200); 

            	    			newLeafNode(lv_ordered_2_0, grammarAccess.getEOperationDeclAccess().getOrderedRandomTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEOperationDeclRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"ordered",
            	            		true, 
            	            		"Random");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleEOperationDecl4219); 

                	newLeafNode(otherlv_3, grammarAccess.getEOperationDeclAccess().getOpKeyword_2());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2155:1: ( ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) ) | otherlv_5= 'void' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==47) ) {
                alt49=1;
            }
            else if ( (LA49_0==52) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2155:2: ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2155:2: ( (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2156:1: (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2156:1: (lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2157:3: lv_eGenericType_4_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4241);
                    lv_eGenericType_4_0=ruleEGenericTypeReferenceDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	        }
                           		set(
                           			current, 
                           			"eGenericType",
                            		lv_eGenericType_4_0, 
                            		"EGenericTypeReferenceDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2174:7: otherlv_5= 'void'
                    {
                    otherlv_5=(Token)match(input,52,FOLLOW_52_in_ruleEOperationDecl4259); 

                        	newLeafNode(otherlv_5, grammarAccess.getEOperationDeclAccess().getVoidKeyword_3_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2178:2: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2179:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2179:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2180:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEOperationDecl4277); 

            			newLeafNode(lv_name_6_0, grammarAccess.getEOperationDeclAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEOperationDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_6_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2196:2: (otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==33) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2196:4: otherlv_7= '<' ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) ) (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )* otherlv_11= '>'
                    {
                    otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleEOperationDecl4295); 

                        	newLeafNode(otherlv_7, grammarAccess.getEOperationDeclAccess().getLessThanSignKeyword_5_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2200:1: ( (lv_eTypeParameters_8_0= ruleETypeParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2201:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2201:1: (lv_eTypeParameters_8_0= ruleETypeParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2202:3: lv_eTypeParameters_8_0= ruleETypeParameterDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4316);
                    lv_eTypeParameters_8_0=ruleETypeParameterDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eTypeParameters",
                            		lv_eTypeParameters_8_0, 
                            		"ETypeParameterDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2218:2: (otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==28) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2218:4: otherlv_9= ',' ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) )
                    	    {
                    	    otherlv_9=(Token)match(input,28,FOLLOW_28_in_ruleEOperationDecl4329); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getEOperationDeclAccess().getCommaKeyword_5_2_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2222:1: ( (lv_eTypeParameters_10_0= ruleETypeParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2223:1: (lv_eTypeParameters_10_0= ruleETypeParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2223:1: (lv_eTypeParameters_10_0= ruleETypeParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2224:3: lv_eTypeParameters_10_0= ruleETypeParameterDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getETypeParametersETypeParameterDeclParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4350);
                    	    lv_eTypeParameters_10_0=ruleETypeParameterDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eTypeParameters",
                    	            		lv_eTypeParameters_10_0, 
                    	            		"ETypeParameterDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleEOperationDecl4364); 

                        	newLeafNode(otherlv_11, grammarAccess.getEOperationDeclAccess().getGreaterThanSignKeyword_5_3());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,27,FOLLOW_27_in_ruleEOperationDecl4378); 

                	newLeafNode(otherlv_12, grammarAccess.getEOperationDeclAccess().getLeftParenthesisKeyword_6());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2248:1: ( ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID||LA53_0==26||LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2248:2: ( (lv_eParameters_13_0= ruleEParameterDecl ) ) (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )*
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2248:2: ( (lv_eParameters_13_0= ruleEParameterDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2249:1: (lv_eParameters_13_0= ruleEParameterDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2249:1: (lv_eParameters_13_0= ruleEParameterDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2250:3: lv_eParameters_13_0= ruleEParameterDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4400);
                    lv_eParameters_13_0=ruleEParameterDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eParameters",
                            		lv_eParameters_13_0, 
                            		"EParameterDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2266:2: (otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==28) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2266:4: otherlv_14= ',' ( (lv_eParameters_15_0= ruleEParameterDecl ) )
                    	    {
                    	    otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleEOperationDecl4413); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getEOperationDeclAccess().getCommaKeyword_7_1_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2270:1: ( (lv_eParameters_15_0= ruleEParameterDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2271:1: (lv_eParameters_15_0= ruleEParameterDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2271:1: (lv_eParameters_15_0= ruleEParameterDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2272:3: lv_eParameters_15_0= ruleEParameterDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEParametersEParameterDeclParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4434);
                    	    lv_eParameters_15_0=ruleEParameterDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eParameters",
                    	            		lv_eParameters_15_0, 
                    	            		"EParameterDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            otherlv_16=(Token)match(input,29,FOLLOW_29_in_ruleEOperationDecl4450); 

                	newLeafNode(otherlv_16, grammarAccess.getEOperationDeclAccess().getRightParenthesisKeyword_8());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2292:1: (otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2292:3: otherlv_17= 'throws' ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) ) (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )*
                    {
                    otherlv_17=(Token)match(input,53,FOLLOW_53_in_ruleEOperationDecl4463); 

                        	newLeafNode(otherlv_17, grammarAccess.getEOperationDeclAccess().getThrowsKeyword_9_0());
                        
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2296:1: ( (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl ) )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:1: (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl )
                    {
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2297:1: (lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl )
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2298:3: lv_eGenericExceptions_18_0= ruleEGenericTypeReferenceDecl
                    {
                     
                    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4484);
                    lv_eGenericExceptions_18_0=ruleEGenericTypeReferenceDecl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	        }
                           		add(
                           			current, 
                           			"eGenericExceptions",
                            		lv_eGenericExceptions_18_0, 
                            		"EGenericTypeReferenceDecl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:2: (otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2314:4: otherlv_19= ',' ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) )
                    	    {
                    	    otherlv_19=(Token)match(input,28,FOLLOW_28_in_ruleEOperationDecl4497); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getEOperationDeclAccess().getCommaKeyword_9_2_0());
                    	        
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2318:1: ( (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl ) )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2319:1: (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl )
                    	    {
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2319:1: (lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl )
                    	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2320:3: lv_eGenericExceptions_20_0= ruleEGenericTypeReferenceDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEOperationDeclAccess().getEGenericExceptionsEGenericTypeReferenceDeclParserRuleCall_9_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4518);
                    	    lv_eGenericExceptions_20_0=ruleEGenericTypeReferenceDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEOperationDeclRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"eGenericExceptions",
                    	            		lv_eGenericExceptions_20_0, 
                    	            		"EGenericTypeReferenceDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_21=(Token)match(input,18,FOLLOW_18_in_ruleEOperationDecl4534); 

                	newLeafNode(otherlv_21, grammarAccess.getEOperationDeclAccess().getSemicolonKeyword_10());
                

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
    // $ANTLR end "ruleEOperationDecl"


    // $ANTLR start "entryRuleEParameterDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2348:1: entryRuleEParameterDecl returns [EObject current=null] : iv_ruleEParameterDecl= ruleEParameterDecl EOF ;
    public final EObject entryRuleEParameterDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEParameterDecl = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2349:2: (iv_ruleEParameterDecl= ruleEParameterDecl EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2350:2: iv_ruleEParameterDecl= ruleEParameterDecl EOF
            {
             newCompositeNode(grammarAccess.getEParameterDeclRule()); 
            pushFollow(FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl4570);
            iv_ruleEParameterDecl=ruleEParameterDecl();

            state._fsp--;

             current =iv_ruleEParameterDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEParameterDecl4580); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEParameterDecl"


    // $ANTLR start "ruleEParameterDecl"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2357:1: ruleEParameterDecl returns [EObject current=null] : ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEParameterDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_eAnnotations_0_0 = null;

        EObject lv_eGenericType_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2360:28: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:1: ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2361:2: ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==26) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2362:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2362:1: (lv_eAnnotations_0_0= ruleEAnnotationDecl )
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2363:3: lv_eAnnotations_0_0= ruleEAnnotationDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEParameterDeclAccess().getEAnnotationsEAnnotationDeclParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl4626);
            	    lv_eAnnotations_0_0=ruleEAnnotationDecl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEParameterDeclRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"eAnnotations",
            	            		lv_eAnnotations_0_0, 
            	            		"EAnnotationDecl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2379:3: ( (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2380:1: (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2380:1: (lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2381:3: lv_eGenericType_1_0= ruleEGenericTypeReferenceDecl
            {
             
            	        newCompositeNode(grammarAccess.getEParameterDeclAccess().getEGenericTypeEGenericTypeReferenceDeclParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl4648);
            lv_eGenericType_1_0=ruleEGenericTypeReferenceDecl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEParameterDeclRule());
            	        }
                   		set(
                   			current, 
                   			"eGenericType",
                    		lv_eGenericType_1_0, 
                    		"EGenericTypeReferenceDecl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2397:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2398:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2398:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2399:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEParameterDecl4665); 

            			newLeafNode(lv_name_2_0, grammarAccess.getEParameterDeclAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEParameterDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleEParameterDecl"


    // $ANTLR start "entryRuleMapEntry"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2423:1: entryRuleMapEntry returns [EObject current=null] : iv_ruleMapEntry= ruleMapEntry EOF ;
    public final EObject entryRuleMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapEntry = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2424:2: (iv_ruleMapEntry= ruleMapEntry EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2425:2: iv_ruleMapEntry= ruleMapEntry EOF
            {
             newCompositeNode(grammarAccess.getMapEntryRule()); 
            pushFollow(FOLLOW_ruleMapEntry_in_entryRuleMapEntry4706);
            iv_ruleMapEntry=ruleMapEntry();

            state._fsp--;

             current =iv_ruleMapEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapEntry4716); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapEntry"


    // $ANTLR start "ruleMapEntry"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2432:1: ruleMapEntry returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2435:28: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2436:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2436:1: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2436:2: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2436:2: ( (lv_key_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2437:1: (lv_key_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2437:1: (lv_key_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2438:3: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMapEntry4758); 

            			newLeafNode(lv_key_0_0, grammarAccess.getMapEntryAccess().getKeyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMapEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"key",
                    		lv_key_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleMapEntry4775); 

                	newLeafNode(otherlv_1, grammarAccess.getMapEntryAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2458:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2459:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2459:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2460:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMapEntry4792); 

            			newLeafNode(lv_value_2_0, grammarAccess.getMapEntryAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMapEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleMapEntry"


    // $ANTLR start "entryRuleQID"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2484:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2485:2: (iv_ruleQID= ruleQID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2486:2: iv_ruleQID= ruleQID EOF
            {
             newCompositeNode(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID4834);
            iv_ruleQID=ruleQID();

            state._fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID4845); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2493:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2496:28: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2497:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2497:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )* )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2497:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID4885); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2504:1: ( (kw= '.' | kw= '$' ) this_ID_3= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=54 && LA58_0<=55)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2504:2: (kw= '.' | kw= '$' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2504:2: (kw= '.' | kw= '$' )
            	    int alt57=2;
            	    int LA57_0 = input.LA(1);

            	    if ( (LA57_0==54) ) {
            	        alt57=1;
            	    }
            	    else if ( (LA57_0==55) ) {
            	        alt57=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2505:2: kw= '.'
            	            {
            	            kw=(Token)match(input,54,FOLLOW_54_in_ruleQID4905); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2512:2: kw= '$'
            	            {
            	            kw=(Token)match(input,55,FOLLOW_55_in_ruleQID4924); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getQIDAccess().getDollarSignKeyword_1_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQID4940); 

            	    		current.merge(this_ID_3);
            	        
            	     
            	        newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop58;
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
    // $ANTLR end "ruleQID"


    // $ANTLR start "entryRuleSTRING_OR_QID"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2532:1: entryRuleSTRING_OR_QID returns [String current=null] : iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF ;
    public final String entryRuleSTRING_OR_QID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_OR_QID = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2533:2: (iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2534:2: iv_ruleSTRING_OR_QID= ruleSTRING_OR_QID EOF
            {
             newCompositeNode(grammarAccess.getSTRING_OR_QIDRule()); 
            pushFollow(FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID4988);
            iv_ruleSTRING_OR_QID=ruleSTRING_OR_QID();

            state._fsp--;

             current =iv_ruleSTRING_OR_QID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_OR_QID4999); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTRING_OR_QID"


    // $ANTLR start "ruleSTRING_OR_QID"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2541:1: ruleSTRING_OR_QID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_OR_QID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_QID_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2544:28: ( (this_STRING_0= RULE_STRING | this_QID_1= ruleQID ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:1: (this_STRING_0= RULE_STRING | this_QID_1= ruleQID )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_STRING) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2545:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5039); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getSTRING_OR_QIDAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2554:5: this_QID_1= ruleQID
                    {
                     
                            newCompositeNode(grammarAccess.getSTRING_OR_QIDAccess().getQIDParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQID_in_ruleSTRING_OR_QID5072);
                    this_QID_1=ruleQID();

                    state._fsp--;


                    		current.merge(this_QID_1);
                        
                     
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
    // $ANTLR end "ruleSTRING_OR_QID"


    // $ANTLR start "entryRuleSINT"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2572:1: entryRuleSINT returns [String current=null] : iv_ruleSINT= ruleSINT EOF ;
    public final String entryRuleSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSINT = null;


        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2573:2: (iv_ruleSINT= ruleSINT EOF )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2574:2: iv_ruleSINT= ruleSINT EOF
            {
             newCompositeNode(grammarAccess.getSINTRule()); 
            pushFollow(FOLLOW_ruleSINT_in_entryRuleSINT5118);
            iv_ruleSINT=ruleSINT();

            state._fsp--;

             current =iv_ruleSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSINT5129); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSINT"


    // $ANTLR start "ruleSINT"
    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2581:1: ruleSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2584:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2585:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2585:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2585:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2585:2: (kw= '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.example.ecoredsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalEcoreDsl.g:2586:2: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleSINT5168); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSINTAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSINT5185); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getSINTAccess().getINTTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleSINT"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA4_eotS =
        "\23\uffff";
    static final String DFA4_eofS =
        "\23\uffff";
    static final String DFA4_minS =
        "\1\6\1\uffff\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21"+
        "\1\5\1\34";
    static final String DFA4_maxS =
        "\1\60\1\uffff\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1"+
        "\60\1\21\1\5\1\35";
    static final String DFA4_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\16\uffff";
    static final String DFA4_specialS =
        "\23\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\4\14\uffff\1\3\3\uffff\1\1\1\4\1\uffff\1\2\3\uffff\3\4\17"+
            "\uffff\1\4",
            "",
            "\1\6\1\5",
            "",
            "",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\12",
            "\1\13",
            "\1\13",
            "\1\14",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\15",
            "\1\16\1\17",
            "\1\20",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\3\uffff\3\4\17\uffff"+
            "\1\4",
            "\1\21",
            "\1\22",
            "\1\16\1\17"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 300:1: ( ( (lv_eSubpackages_10_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_11_0= ruleEClassifierDecl ) ) )*";
        }
    }
    static final String DFA6_eotS =
        "\23\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\6\1\uffff\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21"+
        "\1\5\1\34";
    static final String DFA6_maxS =
        "\1\60\1\uffff\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1"+
        "\60\1\21\1\5\1\35";
    static final String DFA6_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\2\16\uffff";
    static final String DFA6_specialS =
        "\23\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\4\14\uffff\1\3\3\uffff\1\1\1\4\1\uffff\1\2\3\uffff\3\4\17"+
            "\uffff\1\4",
            "",
            "\1\6\1\5",
            "",
            "",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\12",
            "\1\13",
            "\1\13",
            "\1\14",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\1\7\2\uffff\3\4\17"+
            "\uffff\1\4\5\uffff\1\10\1\11",
            "\1\15",
            "\1\16\1\17",
            "\1\20",
            "\1\4\14\uffff\1\3\4\uffff\1\4\1\uffff\1\2\3\uffff\3\4\17\uffff"+
            "\1\4",
            "\1\21",
            "\1\22",
            "\1\16\1\17"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 406:1: ( ( (lv_eSubpackages_4_0= ruleSubEPackageDecl ) ) | ( (lv_eClassifiers_5_0= ruleEClassifierDecl ) ) )*";
        }
    }
    static final String DFA7_eotS =
        "\22\uffff";
    static final String DFA7_eofS =
        "\22\uffff";
    static final String DFA7_minS =
        "\1\6\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21\1\5\1\34";
    static final String DFA7_maxS =
        "\1\60\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1\60\1\21"+
        "\1\5\1\35";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA7_specialS =
        "\22\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\21\uffff\1\3\1\uffff\1\1\3\uffff\3\2\17\uffff\1\3",
            "\1\5\1\4",
            "",
            "",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3"+
            "\5\uffff\1\7\1\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\3\21\uffff\1\3\1\uffff\1\1\1\6\2\uffff\3\2\17\uffff\1\3"+
            "\5\uffff\1\7\1\10",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "\1\3\21\uffff\1\3\1\uffff\1\1\3\uffff\3\2\17\uffff\1\3",
            "\1\20",
            "\1\21",
            "\1\15\1\16"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "468:1: (this_EClassDecl_0= ruleEClassDecl | this_EDataTypeDecl_1= ruleEDataTypeDecl )";
        }
    }
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\6\1\4\2\uffff\2\6\3\4\1\21\1\6\1\5\1\34\1\4\1\6\1\21\1\5\1\34";
    static final String DFA10_maxS =
        "\1\60\1\5\2\uffff\1\60\1\67\3\4\1\21\1\67\1\5\1\35\1\4\1\60\1\21"+
        "\1\5\1\35";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2\16\uffff";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\21\uffff\1\2\1\uffff\1\1\25\uffff\1\3",
            "\1\5\1\4",
            "",
            "",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3\5\uffff\1\7"+
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\2\21\uffff\1\2\1\uffff\1\1\1\6\24\uffff\1\3\5\uffff\1\7"+
            "\1\10",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "\1\2\21\uffff\1\2\1\uffff\1\1\25\uffff\1\3",
            "\1\20",
            "\1\21",
            "\1\15\1\16"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "508:1: ( ( ( (lv_eAnnotations_0_0= ruleEAnnotationDecl ) )* ( (lv_serializable_1_0= RULE_SERIALIZABLE ) )? (otherlv_2= 'datatype' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_instanceClassName_5_0= ruleSTRING_OR_QID ) ) otherlv_6= ';' ) ) | this_EEnumDecl_7= ruleEEnumDecl )";
        }
    }
    static final String DFA21_eotS =
        "\25\uffff";
    static final String DFA21_eofS =
        "\25\uffff";
    static final String DFA21_minS =
        "\1\7\1\uffff\1\4\1\uffff\2\7\1\uffff\2\7\3\4\1\21\1\7\1\5\1\34\1"+
        "\4\1\7\1\21\1\5\1\34";
    static final String DFA21_maxS =
        "\1\63\1\uffff\1\5\1\uffff\2\63\1\uffff\1\63\1\67\3\4\1\21\1\67\1"+
        "\5\1\35\1\4\1\63\1\21\1\5\1\35";
    static final String DFA21_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\2\uffff\1\2\16\uffff";
    static final String DFA21_specialS =
        "\25\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\4\1\5\1\3\1\uffff\1\3\13\uffff\1\1\2\uffff\1\2\11\uffff\6"+
            "\3\3\uffff\2\3\4\uffff\1\6",
            "",
            "\1\10\1\7",
            "",
            "\1\4\1\5\1\3\1\uffff\1\3\30\uffff\6\3\3\uffff\2\3\4\uffff\1"+
            "\6",
            "\1\4\1\5\1\3\1\uffff\1\3\30\uffff\6\3\3\uffff\2\3\4\uffff\1"+
            "\6",
            "",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6\2\uffff\1\12\1\13",
            "\1\14",
            "\1\15",
            "\1\15",
            "\1\16",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\1\11\10\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6\2\uffff\1\12\1\13",
            "\1\17",
            "\1\20\1\21",
            "\1\22",
            "\1\4\1\5\1\3\1\uffff\1\3\16\uffff\1\2\11\uffff\6\3\3\uffff"+
            "\2\3\4\uffff\1\6",
            "\1\23",
            "\1\24",
            "\1\20\1\21"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 903:1: ( ( (lv_eStructuralFeatures_17_0= ruleEStructuralFeatureDecl ) ) | ( (lv_eOperations_18_0= ruleEOperationDecl ) ) )*";
        }
    }
    static final String DFA22_eotS =
        "\31\uffff";
    static final String DFA22_eofS =
        "\31\uffff";
    static final String DFA22_minS =
        "\1\7\1\4\1\uffff\7\7\1\uffff\2\7\3\4\1\21\1\7\1\5\1\34\1\4\1\7\1"+
        "\21\1\5\1\34";
    static final String DFA22_maxS =
        "\1\56\1\5\1\uffff\7\56\1\uffff\1\56\1\67\3\4\1\21\1\67\1\5\1\35"+
        "\1\4\1\56\1\21\1\5\1\35";
    static final String DFA22_acceptS =
        "\2\uffff\1\1\7\uffff\1\2\16\uffff";
    static final String DFA22_specialS =
        "\31\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\11\uffff\1\2\1\6\1\7"+
            "\1\10\1\11\1\2\3\uffff\2\12",
            "\1\14\1\13",
            "",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\30\uffff\1\2\1\6\1\7\1\10\1\11\1"+
            "\2\3\uffff\2\12",
            "",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1"+
            "\6\1\7\1\10\1\11\1\2\3\uffff\2\12",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1"+
            "\6\1\7\1\10\1\11\1\2\3\uffff\2\12\7\uffff\1\16\1\17",
            "\1\20",
            "\1\21",
            "\1\21",
            "\1\22",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\1\15\10\uffff\1\2\1"+
            "\6\1\7\1\10\1\11\1\2\3\uffff\2\12\7\uffff\1\16\1\17",
            "\1\23",
            "\1\24\1\25",
            "\1\26",
            "\1\3\1\4\1\5\1\uffff\1\12\16\uffff\1\1\11\uffff\1\2\1\6\1\7"+
            "\1\10\1\11\1\2\3\uffff\2\12",
            "\1\27",
            "\1\30",
            "\1\24\1\25"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "965:1: (this_EAttributeDecl_0= ruleEAttributeDecl | this_EReferenceDecl_1= ruleEReferenceDecl )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEcoreDsl_in_entryRuleEcoreDsl75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEcoreDsl85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleEcoreDsl131 = new BitSet(new long[]{0x0000000004090000L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_ruleEcoreDsl153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel236 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel254 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleReferencedMetamodel271 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel293 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReferencedMetamodel305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEPackageDecl_in_entryRuleEPackageDecl341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEPackageDecl351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEPackageDecl397 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleEPackageDecl410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl431 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEPackageDecl443 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageDecl472 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEPackageDecl489 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEPackageDecl501 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQID_in_ruleEPackageDecl522 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEPackageDecl534 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleEPackageDecl556 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleEPackageDecl583 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleEPackageDecl597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_entryRuleSubEPackageDecl633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubEPackageDecl643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleSubEPackageDecl689 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_19_in_ruleSubEPackageDecl702 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubEPackageDecl719 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSubEPackageDecl736 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleSubEPackageDecl_in_ruleSubEPackageDecl758 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_ruleSubEPackageDecl785 = new BitSet(new long[]{0x00010001C5880040L});
    public static final BitSet FOLLOW_23_in_ruleSubEPackageDecl799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassifierDecl_in_entryRuleEClassifierDecl835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassifierDecl845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_ruleEClassifierDecl892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_ruleEClassifierDecl919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEDataTypeDecl_in_entryRuleEDataTypeDecl954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEDataTypeDecl964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEDataTypeDecl1011 = new BitSet(new long[]{0x0000000005000040L});
    public static final BitSet FOLLOW_RULE_SERIALIZABLE_in_ruleEDataTypeDecl1029 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleEDataTypeDecl1048 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEDataTypeDecl1065 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEDataTypeDecl1082 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEDataTypeDecl1103 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEDataTypeDecl1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_ruleEDataTypeDecl1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_entryRuleEAnnotationDecl1180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAnnotationDecl1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleEAnnotationDecl1227 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEAnnotationDecl1248 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleEAnnotationDecl1261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1282 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEAnnotationDecl1295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMapEntry_in_ruleEAnnotationDecl1316 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEAnnotationDecl1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEClassDecl_in_entryRuleEClassDecl1368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEClassDecl1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEClassDecl1424 = new BitSet(new long[]{0x00000001C4000000L});
    public static final BitSet FOLLOW_30_in_ruleEClassDecl1443 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31_in_ruleEClassDecl1476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_32_in_ruleEClassDecl1507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEClassDecl1525 = new BitSet(new long[]{0x0000000A02400000L});
    public static final BitSet FOLLOW_33_in_ruleEClassDecl1543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1564 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1577 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEClassDecl1598 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEClassDecl1612 = new BitSet(new long[]{0x0000000802400000L});
    public static final BitSet FOLLOW_35_in_ruleEClassDecl1627 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1648 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_28_in_ruleEClassDecl1661 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEClassDecl1682 = new BitSet(new long[]{0x0000000012400000L});
    public static final BitSet FOLLOW_25_in_ruleEClassDecl1699 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_ruleEClassDecl1720 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEClassDecl1734 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_ruleEClassDecl1756 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_ruleEClassDecl1783 = new BitSet(new long[]{0x000863F004800B80L});
    public static final BitSet FOLLOW_23_in_ruleEClassDecl1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEStructuralFeatureDecl_in_entryRuleEStructuralFeatureDecl1833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEStructuralFeatureDecl1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_ruleEStructuralFeatureDecl1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_ruleEStructuralFeatureDecl1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAttributeDecl_in_entryRuleEAttributeDecl1952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAttributeDecl1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEAttributeDecl2008 = new BitSet(new long[]{0x000003F004000380L});
    public static final BitSet FOLLOW_36_in_ruleEAttributeDecl2028 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEAttributeDecl2064 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEAttributeDecl2092 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEAttributeDecl2120 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_37_in_ruleEAttributeDecl2149 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_38_in_ruleEAttributeDecl2186 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_39_in_ruleEAttributeDecl2223 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_40_in_ruleEAttributeDecl2260 = new BitSet(new long[]{0x000003F000000380L});
    public static final BitSet FOLLOW_41_in_ruleEAttributeDecl2287 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEAttributeDecl2308 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_ruleEAttributeDecl2321 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEAttributeDecl2338 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAttributeDecl2356 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEAttributeDecl2377 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEAttributeDecl2391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEAttributeDecl2410 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleEAttributeDecl2428 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEAttributeDecl2445 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEAttributeDecl2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEReferenceDecl_in_entryRuleEReferenceDecl2500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEReferenceDecl2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEReferenceDecl2556 = new BitSet(new long[]{0x000061E004000B80L});
    public static final BitSet FOLLOW_RULE_LOCAL_in_ruleEReferenceDecl2575 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEReferenceDecl2603 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEReferenceDecl2631 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_RULE_READONLY_in_ruleEReferenceDecl2659 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_37_in_ruleEReferenceDecl2688 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_38_in_ruleEReferenceDecl2725 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_39_in_ruleEReferenceDecl2762 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_40_in_ruleEReferenceDecl2799 = new BitSet(new long[]{0x000061E000000B80L});
    public static final BitSet FOLLOW_45_in_ruleEReferenceDecl2833 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_46_in_ruleEReferenceDecl2864 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEReferenceDecl2886 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_42_in_ruleEReferenceDecl2899 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEReferenceDecl2916 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleEReferenceDecl2934 = new BitSet(new long[]{0x0100000000000400L});
    public static final BitSet FOLLOW_ruleSINT_in_ruleEReferenceDecl2955 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleEReferenceDecl2969 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_47_in_ruleEReferenceDecl2984 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3004 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEReferenceDecl3023 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEReferenceDecl3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumDecl_in_entryRuleEEnumDecl3076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumDecl3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumDecl3132 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_ruleEEnumDecl3145 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumDecl3162 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEEnumDecl3179 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_ruleEEnumDecl3200 = new BitSet(new long[]{0x0000000004800010L});
    public static final BitSet FOLLOW_23_in_ruleEEnumDecl3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEEnumLiteralDecl_in_entryRuleEEnumLiteralDecl3249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEEnumLiteralDecl3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEEnumLiteralDecl3305 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEEnumLiteralDecl3323 = new BitSet(new long[]{0x0000000000060020L});
    public static final BitSet FOLLOW_17_in_ruleEEnumLiteralDecl3341 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEEnumLiteralDecl3358 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEEnumLiteralDecl3382 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEEnumLiteralDecl3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_entryRuleETypeParameterDecl3436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleETypeParameterDecl3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleETypeParameterDecl3488 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleETypeParameterDecl3506 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleETypeParameterDecl3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_entryRuleEGenericTypeReferenceDecl3565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeReferenceDecl3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3621 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeReferenceDecl3634 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3655 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeReferenceDecl3668 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeReferenceDecl3689 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeReferenceDecl3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeReferenceDecl3725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeReferenceDecl3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_entryRuleEGenericTypeDecl3782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEGenericTypeDecl3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3838 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleEGenericTypeDecl3851 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3872 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEGenericTypeDecl3885 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl3906 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEGenericTypeDecl3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEGenericTypeDecl3942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEGenericTypeDecl3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEGenericTypeDecl3982 = new BitSet(new long[]{0x0004000800000000L});
    public static final BitSet FOLLOW_35_in_ruleEGenericTypeDecl3996 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEGenericTypeDecl4037 = new BitSet(new long[]{0x0002800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeDecl_in_ruleEGenericTypeDecl4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEOperationDecl_in_entryRuleEOperationDecl4097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEOperationDecl4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEOperationDecl4153 = new BitSet(new long[]{0x0008000004000180L});
    public static final BitSet FOLLOW_RULE_BAG_in_ruleEOperationDecl4172 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_RULE_RANDOM_in_ruleEOperationDecl4200 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_51_in_ruleEOperationDecl4219 = new BitSet(new long[]{0x0010800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52_in_ruleEOperationDecl4259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEOperationDecl4277 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_33_in_ruleEOperationDecl4295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4316 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl4329 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleETypeParameterDecl_in_ruleEOperationDecl4350 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_34_in_ruleEOperationDecl4364 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEOperationDecl4378 = new BitSet(new long[]{0x0000800024000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4400 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl4413 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_ruleEOperationDecl4434 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_ruleEOperationDecl4450 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_53_in_ruleEOperationDecl4463 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4484 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleEOperationDecl4497 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEOperationDecl4518 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleEOperationDecl4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEParameterDecl_in_entryRuleEParameterDecl4570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEParameterDecl4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAnnotationDecl_in_ruleEParameterDecl4626 = new BitSet(new long[]{0x0000800004000010L});
    public static final BitSet FOLLOW_ruleEGenericTypeReferenceDecl_in_ruleEParameterDecl4648 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEParameterDecl4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapEntry_in_entryRuleMapEntry4706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapEntry4716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMapEntry4758 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMapEntry4775 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMapEntry4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID4834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID4885 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleQID4905 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_ruleQID4924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQID4940 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_OR_QID_in_entryRuleSTRING_OR_QID4988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_OR_QID4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_OR_QID5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_ruleSTRING_OR_QID5072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSINT_in_entryRuleSINT5118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSINT5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSINT5168 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSINT5185 = new BitSet(new long[]{0x0000000000000002L});

}